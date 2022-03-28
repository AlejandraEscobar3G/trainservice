package com.trainservice.java.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trainservice.java.dto.ResponseDto;
import com.trainservice.java.dto.TrainDetailsDto;
import com.trainservice.java.dto.TrainDetailsRequestDto;
import com.trainservice.java.dto.TrainDetailsResponseDto;
import com.trainservice.java.dto.TrainResponseDto;
import com.trainservice.java.entity.Train;
import com.trainservice.java.repo.TrainRepo;
import com.trainservice.java.service.TrainService;

@Service
public class TrainServiceImpl implements TrainService {

	@Autowired
	TrainRepo trainRepo;
	
	@Override
	public TrainResponseDto getAllTrains() {
		List<Train> trainList = trainRepo.findAll();
		
		TrainResponseDto trainResponseDto = new TrainResponseDto("Trains fetched", "T-200");
		trainResponseDto.setData(trainList);
		
		return trainResponseDto;
	}

	@Override
	public ResponseDto saveTrain(TrainDetailsRequestDto trainDetailsRequestDto) {
		Train train = new Train();
		train.setTrainName(trainDetailsRequestDto.getTrainName());
		train.setTrainCapacity(trainDetailsRequestDto.getTrainCapacity());
		
		trainRepo.save(train);
		
		return new ResponseDto("Train Saved", "T-200");
	}

	@Override
	public TrainDetailsResponseDto getTrainById(Integer trainId) {
		Optional<Train> trainOptional = trainRepo.findById(trainId);
		
		//if(trainOptional.isEmpty())
			// throw train not found exception
		
		Train train = trainOptional.get();
		TrainDetailsDto data = new TrainDetailsDto();
		BeanUtils.copyProperties(train, data);
		
		TrainDetailsResponseDto trainDetailsResponseDto = new TrainDetailsResponseDto("Train fetched", "T-200");
		trainDetailsResponseDto.setData(data);
		
		return trainDetailsResponseDto;
	}

}
