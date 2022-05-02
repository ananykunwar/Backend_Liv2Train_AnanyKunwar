package com.example.demo;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//Controller section of application
@CrossOrigin
@RestController
public class TrainingController {

	@Autowired
	TrainingCampRepo repo;
	
	//POST API to create and save new training center
	@PostMapping("/api/loadTrainingCampDetail")
	public TrainingCamp loadTrainingCamp(@Valid @RequestBody TrainingCamp trainingCamp){
		repo.save(trainingCamp);
		return trainingCamp;
	}
	
	//GET API to get list of all stored training centers information
	@GetMapping("/api/getTrainingCampDetail")
	public List<TrainingCamp> getTrainingCamp(){
		return repo.findAll();
	}
	
	//GET API to get details of specific training center as per CenterCode value 
	@GetMapping("/api/getTrainingCampDetail/centerCode/{centerCode}")
	public TrainingCamp getByCenterCode(@PathVariable("centerCode") String centerCode) {
		TrainingCamp trainingCamp = repo.findById(centerCode).get();
		return trainingCamp;
	}
	 
	
}
