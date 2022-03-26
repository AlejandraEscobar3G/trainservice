package com.trainservice.java.dto;

public class TrainDetailsResponseDto extends ResponseDto {
	
	private TrainDetailsDto data;

	public TrainDetailsResponseDto() {
		super();
	}

	public TrainDetailsDto getData() {
		return data;
	}

	public void setData(TrainDetailsDto data) {
		this.data = data;
	}
}
