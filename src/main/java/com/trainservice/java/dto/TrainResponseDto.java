package com.trainservice.java.dto;

import java.util.List;

public class TrainResponseDto extends ResponseDto {

	private List<TrainDetailsDto> data;
	
	public TrainResponseDto() {
		super();
	}

	public List<TrainDetailsDto> getData() {
		return data;
	}

	public void setData(List<TrainDetailsDto> data) {
		this.data = data;
	}

}
