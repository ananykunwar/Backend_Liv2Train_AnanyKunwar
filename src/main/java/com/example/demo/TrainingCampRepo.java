package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
//repository for main TrainingCamp entity class
public interface TrainingCampRepo extends JpaRepository<TrainingCamp, String> {

}
