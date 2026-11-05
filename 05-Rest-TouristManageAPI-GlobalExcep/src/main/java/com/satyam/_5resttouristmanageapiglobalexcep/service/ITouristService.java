package com.satyam._5resttouristmanageapiglobalexcep.service;

import com.satyam._5resttouristmanageapiglobalexcep.exception.TouristNotFoundException;
import com.satyam._5resttouristmanageapiglobalexcep.model.Tourist;

import java.util.List;

public interface ITouristService {
    String registerTourist(Tourist tourist);

    Tourist fetchTouristById(Integer id) throws TouristNotFoundException;

    List<Tourist> fetchAllTouristinfo();

    String updateTheTouristInfo(Tourist tourist);

    String updateTheTouristBudget(Integer id, Double budget);

    String deleteTheTouristInfoById(Integer id);

}
