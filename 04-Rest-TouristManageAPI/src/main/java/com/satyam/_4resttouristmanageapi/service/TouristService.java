package com.satyam._4resttouristmanageapi.service;

import com.satyam._4resttouristmanageapi.dao.ITouristRepo;
import com.satyam._4resttouristmanageapi.exception.TouristNotFoundException;
import com.satyam._4resttouristmanageapi.model.Tourist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return List.of();
    }
}
