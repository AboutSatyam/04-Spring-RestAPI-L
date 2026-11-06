package com.satyam._7swaggerticketap_06.web;

import com.satyam._7swaggerticketap_06.model.Passenger;
import com.satyam._7swaggerticketap_06.model.Ticket;
import com.satyam._7swaggerticketap_06.service.ITicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TicketController {

    private ITicketService service;

    @Autowired
    public void setService(ITicketService service) {
        this.service = service;
    }

    @PostMapping("/book-ticket")
    public String bookTicket(@ModelAttribute Passenger passenger, Model model) {
        Integer ticketNumber = service.registerPassenger(passenger);
        model.addAttribute("ticketNumber", ticketNumber);
        return "index"; //Logical view name
    }


    @GetMapping("/passenger-form")
    public String bookTicketFrom(@ModelAttribute Passenger passenger, Model model) {

        model.addAttribute("passenger", new Passenger());
        return "index"; //Logical view name
    }

    @GetMapping("/form")
    public String ticketFrom(@ModelAttribute Passenger passenger, Model model) {

        model.addAttribute("passenger", new Passenger());
        return "ticket-form"; //Logical view name
    }

    @GetMapping("/get-from")
    public String getTicket(@RequestParam("ticketNumber") Integer ticketNumber, Model model) {
        Ticket ticket = service.getFullTicket(ticketNumber);
        model.addAttribute("ticket", ticket);
        return "ticket-info";
    }

}
