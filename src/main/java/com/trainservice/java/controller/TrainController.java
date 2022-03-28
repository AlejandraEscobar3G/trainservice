package com.trainservice.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.trainservice.java.dto.ResponseDto;
import com.trainservice.java.dto.TrainDetailsRequestDto;
import com.trainservice.java.dto.TrainDetailsResponseDto;
import com.trainservice.java.dto.TrainResponseDto;
import com.trainservice.java.service.TrainService;

@RestController
public class TrainController {
	
	@Autowired
	TrainService trainService;
	
	@GetMapping("/trains")
	public ResponseEntity<TrainResponseDto> getAllTrains() {
		TrainResponseDto trainResponseDto = trainService.getAllTrains();
		return new ResponseEntity<TrainResponseDto>(trainResponseDto, HttpStatus.OK);
	}
	
	@PostMapping("/trains")
	public ResponseEntity<ResponseDto> saveTrain(@RequestBody TrainDetailsRequestDto trainDetailsRequestDto) {
		ResponseDto responseDto = trainService.saveTrain(trainDetailsRequestDto);
		return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
	}
	
	@GetMapping("/trains/{trainId}")
	public ResponseEntity<TrainDetailsResponseDto> getTrainById(@PathVariable Integer trainId) {
		TrainDetailsResponseDto trainDetailsResponseDto = trainService.getTrainById(trainId);
		return new ResponseEntity<TrainDetailsResponseDto>(trainDetailsResponseDto, HttpStatus.OK);
	}
}
