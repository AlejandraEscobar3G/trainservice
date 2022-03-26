package com.trainservice.java.service;

import com.trainservice.java.dto.ResponseDto;
import com.trainservice.java.dto.TrainDetailsDto;
import com.trainservice.java.dto.TrainDetailsResponseDto;
import com.trainservice.java.dto.TrainResponseDto;

public interface TrainService {

	TrainResponseDto getAllTrains();

	ResponseDto saveTrain(TrainDetailsDto trainDetailsDto);

	TrainDetailsResponseDto getTrainById(Integer trainId);
	
}
