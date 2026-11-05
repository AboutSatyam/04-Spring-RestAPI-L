package com.satyam._5resttouristmanageapiglobalexcep.dao;

import com.satyam._5resttouristmanageapiglobalexcep.model.Tourist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITouristRepo extends JpaRepository<Tourist, Integer> {
}
