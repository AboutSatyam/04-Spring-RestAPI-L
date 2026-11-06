package com.satyam._6restticketappapi.service;

import com.satyam._6restticketappapi.model.Passenger;

public interface ITicketService {

    Passenger registerPassenger(Passenger passenger);
    Passenger fetchPassengerInfo(Integer id);

}
