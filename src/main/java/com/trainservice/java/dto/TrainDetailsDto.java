package com.trainservice.java.dto;

import java.util.List;

public class TrainDetailsDto {
	
	private String trainName;
	private Integer trainCapacity;
	private List<TrainAmenitieDetailsDto> trainAmenities;
	
	public String getTrainName() {
		return trainName;
	}
	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}
	public Integer getTrainCapacity() {
		return trainCapacity;
	}
	public void setTrainCapacity(Integer trainCapacity) {
		this.trainCapacity = trainCapacity;
	}
	public List<TrainAmenitieDetailsDto> getTrainAmenities() {
		return trainAmenities;
	}
	public void setTrainAmenities(List<TrainAmenitieDetailsDto> trainAmenities) {
		this.trainAmenities = trainAmenities;
	}
}
