package com.satyam._4resttouristmanageapi.dao;

import com.satyam._4resttouristmanageapi.model.Tourist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITouristRepo extends JpaRepository<Tourist, Integer> {
}
