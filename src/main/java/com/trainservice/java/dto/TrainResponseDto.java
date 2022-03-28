package com.trainservice.java.dto;

import java.util.List;

import com.trainservice.java.entity.Train;

public class TrainResponseDto extends ResponseDto {

	private List<Train> data;

	public TrainResponseDto(String message, String statusCode) {
		super(message, statusCode);
	}

	public List<Train> getData() {
		return data;
	}

	public void setData(List<Train> data) {
		this.data = data;
	}

}
