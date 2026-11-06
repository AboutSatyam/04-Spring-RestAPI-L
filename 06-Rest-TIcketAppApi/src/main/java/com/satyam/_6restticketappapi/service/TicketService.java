package com.satyam._6restticketappapi.service;

import com.satyam._6restticketappapi.model.Passenger;
import com.satyam._6restticketappapi.repo.ITicketRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class TicketService implements ITicketService {

    private ITicketRepo repo;

    @Autowired
    public void setRepo(ITicketRepo repo) {
        this.repo = repo;
    }

    @Override
    public Passenger registerPassenger(Passenger passenger) {
        return repo.save(passenger);
    }

    @Override
    public Passenger fetchPassengerInfo(Integer id) {
        Optional<Passenger> optional = repo.findById(id);
        return optional.get();
    }
}
