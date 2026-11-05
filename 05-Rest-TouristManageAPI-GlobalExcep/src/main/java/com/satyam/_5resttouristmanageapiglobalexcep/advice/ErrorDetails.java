package com.satyam._5resttouristmanageapiglobalexcep.advice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDetails {

    private String status_Code;
    private String msg;
    private LocalDateTime Date_time;

}
