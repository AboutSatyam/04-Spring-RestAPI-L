package com.satyam._6restticketappapi.rest;

import com.satyam._6restticketappapi.model.Passenger;
import com.satyam._6restticketappapi.model.Ticket;
import com.satyam._6restticketappapi.service.ITicketService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/book-ticket")
@Tag(name = "TicketBookingAPI Class Level", description = "There Is Two Api First Will generate" +
        " Ticket no based on Passenger Input And Second Will generate the Ticket Based On Ticket Info")
public class TicketController {

    private ITicketService service;

    @Autowired
    public void setService(ITicketService service) {
        this.service = service;
    }

    @PostMapping("/get-ticketnumber")
    @Operation(summary = "POST Operation", description = "This API Will Accept Passenger Info And Generate  Ticket No")
    public ResponseEntity<Integer> registerPassenger(@RequestBody Passenger passenger) {

        Passenger pass = service.registerPassenger(passenger);
        Integer ticketNumber = pass.getPid();
        return new ResponseEntity<Integer>(ticketNumber, HttpStatus.CREATED);
    }

    @GetMapping("/get-ticketnumber/{ticketNumber}")
    @Operation(summary = "GET Operation", description = "This API Will Accept ID  And Generate FUll Ticket ")

    public ResponseEntity<Ticket> getTicket(@PathVariable("ticketNumber") Integer ticketNumber) {

        Passenger passenger = service.fetchPassengerInfo(ticketNumber);
        Ticket ticket = new Ticket();
        ticket.setTicketNumber(passenger.getPid());
        ticket.setName(passenger.getName());
        ticket.setDeparture(passenger.getDeparture());
        ticket.setArrival(passenger.getArrival());
        ticket.setDateOfJourney(passenger.getDateOfJourney());

        ticket.setStatus("Confirmed");
        ticket.setTicketPrice(1494.8);
        return new ResponseEntity<Ticket>(ticket, HttpStatus.OK);
    }

}
