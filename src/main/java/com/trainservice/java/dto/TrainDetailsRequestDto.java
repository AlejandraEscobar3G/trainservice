package com.trainservice.java.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class TrainDetailsRequestDto {
	
	@NotEmpty(message = "Train name is mandatory")
	private String trainName;
	
	@NotNull(message = "Train capacity is mandatory")
	private Integer trainCapacity;
	
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
}
