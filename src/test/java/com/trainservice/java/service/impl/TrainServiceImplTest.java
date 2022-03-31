package com.trainservice.java.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.trainservice.java.dto.TrainDetailsResponseDto;
import com.trainservice.java.dto.TrainResponseDto;
import com.trainservice.java.entity.Train;
import com.trainservice.java.exception.TrainNotFoundException;
import com.trainservice.java.repo.TrainRepo;

@ExtendWith(MockitoExtension.class)
public class TrainServiceImplTest {
	
	@Mock
	TrainRepo trainRepo;
	
	@InjectMocks
	TrainServiceImpl trainServiceImpl;
	
	Train train;
	Train train2;
	
	@BeforeEach
	public void init() {
		train = new Train();
		train.setTrainId(1);
		train.setTrainName("Charly");
		train.setTrainCapacity(12);
		
		train2 = new Train();
		train2.setTrainId(5);
		train2.setTrainName("Robert");
		train2.setTrainCapacity(99);
	}
	
	@Test
	@DisplayName("Get all trains: POSITIVE")
	public void getAllTrainsTest() {
		when(trainRepo.findAll()).thenReturn(List.of(train, train2));
		
		TrainResponseDto trainResponseDto = trainServiceImpl.getAllTrains();
		assertTrue(trainResponseDto.getData().size() > 0);
	}
	
	@Test
	@Disabled
	@DisplayName("Get all trains: NEGATIVE")
	public void getAllTrainsNegativeTest() {
		when(trainRepo.findAll()).thenReturn(null);
		
		TrainResponseDto trainResponseDto = trainServiceImpl.getAllTrains();
		assertNull(trainResponseDto.getData());
	}
	
	@Test
	@DisplayName("Get train by id: POSITIVE")
	public void getTrainByIdTest() {
		when(trainRepo.findById(5)).thenReturn(Optional.of(train2));
		
		TrainDetailsResponseDto responseDto = trainServiceImpl.getTrainById(5);
		assertNotNull(responseDto);
		assertEquals(5, responseDto.getData().getTrainId());
	}
	
	@Test
	@DisplayName("Get train by id: NEGATIVE")
	public void getTrainByIdNegativeTest() {
		when(trainRepo.findById(8)).thenReturn(Optional.empty());
		
		assertThrows(TrainNotFoundException.class, () -> trainServiceImpl.getTrainById(8));
	}

}
