package com.satyam._7swaggerticketap_06.service;

import com.satyam._7swaggerticketap_06.model.Passenger;
import com.satyam._7swaggerticketap_06.model.Ticket;

public interface ITicketService {

    public Integer registerPassenger(Passenger passenger);

    public Ticket getFullTicket(Integer ticketNumber);

}
