package com.satyam._7swaggerticketap_06.model;

import lombok.Data;

@Data

public class Ticket {

    private Integer ticketNumber;
    private String status;
    private Double ticketPrice;
    private String name;
    private String departure;
    private String arrival;
    private String dateOfJourney;
}
