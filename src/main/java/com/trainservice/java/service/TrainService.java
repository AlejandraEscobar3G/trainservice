package com.trainservice.java.service;

import com.trainservice.java.dto.ResponseDto;
import com.trainservice.java.dto.TrainDetailsRequestDto;
import com.trainservice.java.dto.TrainDetailsResponseDto;
import com.trainservice.java.dto.TrainResponseDto;

public interface TrainService {

	TrainResponseDto getAllTrains();

	ResponseDto saveTrain(TrainDetailsRequestDto trainDetailsRequestDto);

	TrainDetailsResponseDto getTrainById(Integer trainId);
	
}
