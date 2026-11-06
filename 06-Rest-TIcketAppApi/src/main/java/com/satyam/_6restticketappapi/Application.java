package com.satyam._6restticketappapi;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(
        title = "TicketBookingAPI",
        version = "v1.0",
        description = "Thsi API Will Book And Generate Ticket "),
        servers = @Server(url = "http://localhost:8080/TicketBookingAPI/",
                description = "This Is Depoly in Followig URL")
)
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
