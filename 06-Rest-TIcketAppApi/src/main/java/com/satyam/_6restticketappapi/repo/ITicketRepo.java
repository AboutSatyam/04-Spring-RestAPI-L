package com.satyam._6restticketappapi.repo;

import com.satyam._6restticketappapi.model.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITicketRepo extends JpaRepository<Passenger, Integer> {

}
