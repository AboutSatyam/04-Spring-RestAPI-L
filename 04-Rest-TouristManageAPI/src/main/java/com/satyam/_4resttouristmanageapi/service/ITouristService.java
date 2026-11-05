package com.satyam._4resttouristmanageapi.service;

import com.satyam._4resttouristmanageapi.exception.TouristNotFoundException;
import com.satyam._4resttouristmanageapi.model.Tourist;

import java.util.List;

public interface ITouristService {
    String registerTourist(Tourist tourist);

    Tourist fetchTouristById(Integer id) throws TouristNotFoundException;

    List<Tourist> fetchAllTouristinfo();

    String updateTheTouristInfo(Tourist tourist);

    String updateTheTouristBudget(Integer id, Double budget);

    String deleteTheTouristInfoById(Integer id);

}
