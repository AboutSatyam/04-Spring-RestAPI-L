package com.satyam._5resttouristmanageapiglobalexcep.service;

import com.satyam._5resttouristmanageapiglobalexcep.dao.ITouristRepo;
import com.satyam._5resttouristmanageapiglobalexcep.exception.TouristNotFoundException;
import com.satyam._5resttouristmanageapiglobalexcep.model.Tourist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TouristService implements ITouristService {
    private ITouristRepo repo;

    @Autowired
    public void setRepo(ITouristRepo repo) {
        this.repo = repo;
    }

    @Override
    public String registerTourist(Tourist tourist) {
        Tourist tour = repo.save(tourist);
        return "Tourist Register SucussFully  With ID " + tour.getId();
    }

    @Override
    public Tourist fetchTouristById(Integer id) throws TouristNotFoundException {

//        Optional<Tourist> optional = repo.findById(id);
//        if (optional.isPresent()) {
//            return optional.get();
//        } else {
//            throw new TouristNotFoundException("Tourist With Give Id Not Found ");}

        return repo.findById(id)
                .orElseThrow(() -> new TouristNotFoundException("Tourist With Give Id Not Found "));
    }

    @Override
    public List<Tourist> fetchAllTouristinfo() {
        return repo.findAll();
    }

    @Override
    public String updateTheTouristInfo(Tourist tourist) {

        Optional<Tourist> optional = repo.findById(tourist.getId());

        if (optional.isPresent()) {
//            Tourist trst = optional.get();
            repo.save(tourist);
            return "Tourist Info Is Updated Successfully";

        } else {
            throw new TouristNotFoundException("Tourist With Given Id Is Not Found ");
        }
    }

    @Override
    public String updateTheTouristBudget(Integer id, Double budget) {
        Optional<Tourist> optional = repo.findById(id);

        if (optional.isPresent()) {

            Tourist tourist = optional.get();
            tourist.setBudget(budget);
            repo.save(tourist);
            return "Tourist Budget Is Updated Successfully";

        }
        return "No Tourist With Given Id";
    }

    @Override
    public String deleteTheTouristInfoById(Integer id) {
        Optional<Tourist> optional = repo.findById(id);
        if (optional.isPresent()) {
            repo.deleteById(id);
            return "Tourist Record Is Delete Sucess With Id " + id;
        } else {
            throw new TouristNotFoundException("Tourist With Given Id Is Not Found For Deletion");
        }
    }
}
