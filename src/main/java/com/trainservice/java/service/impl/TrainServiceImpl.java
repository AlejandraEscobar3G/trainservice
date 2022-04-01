package com.trainservice.java.service.impl;

import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trainservice.java.constants.ApiConstants;
import com.trainservice.java.dto.ResponseDto;
import com.trainservice.java.dto.TrainDetailsDto;
import com.trainservice.java.dto.TrainDetailsRequestDto;
import com.trainservice.java.dto.TrainDetailsResponseDto;
import com.trainservice.java.dto.TrainResponseDto;
import com.trainservice.java.entity.Train;
import com.trainservice.java.exception.TrainNotFoundException;
import com.trainservice.java.repo.TrainRepo;
import com.trainservice.java.service.TrainService;

@Service
public class TrainServiceImpl implements TrainService {
	
	final static Logger logger = Logger.getLogger(TrainServiceImpl.class);

	@Autowired
	TrainRepo trainRepo;
	
	@Override
	public TrainResponseDto getAllTrains() {
		logger.info("Fetching trains");
		List<Train> trainList = trainRepo.findAll();
		
		TrainResponseDto trainResponseDto = new TrainResponseDto("Trains fetched", ApiConstants.TRAINS_SUCCESSFULLY_FETCHED);
		logger.info("Fetched all available trains");
		trainResponseDto.setData(trainList);
		
		return trainResponseDto;
	}

	@Override
	public ResponseDto saveTrain(TrainDetailsRequestDto trainDetailsRequestDto) {
		logger.info("Saving new train");
		Train train = new Train();
		train.setTrainName(trainDetailsRequestDto.getTrainName());
		train.setTrainCapacity(trainDetailsRequestDto.getTrainCapacity());
		
		trainRepo.save(train);
		logger.info("New train saved");
		
		return new ResponseDto("Train Saved", ApiConstants.TRAIN_SUCCESSFULLY_SAVED);
	}

	@Override
	public TrainDetailsResponseDto getTrainById(Integer trainId) {
		logger.info("Fetching single train by id " + trainId);
		Optional<Train> trainOptional = trainRepo.findById(trainId);
		
		if(trainOptional.isEmpty()) {
			logger.error("Error fetching single train " + trainId + " because of: " + ApiConstants.TRAIN_NOT_FOUND);
			throw new TrainNotFoundException("Train not found: " + trainId);
		}
		
		Train train = trainOptional.get();
		TrainDetailsDto data = new TrainDetailsDto();
		BeanUtils.copyProperties(train, data);
		
		TrainDetailsResponseDto trainDetailsResponseDto = new TrainDetailsResponseDto("Train fetched", ApiConstants.TRAINS_SUCCESSFULLY_FETCHED);
		trainDetailsResponseDto.setData(data);
		
		logger.info("Fetched train " + trainId);
		return trainDetailsResponseDto;
	}

}
