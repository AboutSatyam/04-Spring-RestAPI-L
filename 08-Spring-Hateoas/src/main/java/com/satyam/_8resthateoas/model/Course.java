package com.satyam._8resthateoas.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course extends RepresentationModel {

    private Integer cid;
    private String name;
    private Double cost;


}
