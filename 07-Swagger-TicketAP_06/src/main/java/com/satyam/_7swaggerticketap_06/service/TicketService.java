package com.satyam._7swaggerticketap_06.service;

import com.satyam._7swaggerticketap_06.model.Passenger;
import com.satyam._7swaggerticketap_06.model.Ticket;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
// No Logic
public class TicketService implements ITicketService {

    private String url = "http://localhost:8080/TicketBookingAPI/api/book-ticket/get-ticketnumber";
    private String get_url = "http://localhost:8080/TicketBookingAPI/api/book-ticket/get-ticket/{ticketNumber}";


    @Override
    public Integer registerPassenger(Passenger passenger) {

        // RestTemplate
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Integer> response = restTemplate.postForEntity(url, passenger, Integer.class);//
        Integer ticketNumber = response.getBody();

        // WebClient Method
//        WebClient.create().post().uri().bodyValue().retrieve().bodyToMono().block()


        return ticketNumber;
    }
    @Override
    public Ticket getFullTicket(Integer ticketNumber) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Ticket> response = restTemplate.getForEntity(get_url, Ticket.class, ticketNumber);//
        Ticket ticket = response.getBody();
        return ticket;
        // WebClient Method
     //   WebClient.create().get().uri( , ).bodyValue().retrieve().bodyToMono().block()

    }
}
