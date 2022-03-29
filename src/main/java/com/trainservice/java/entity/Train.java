package com.trainservice.java.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Train {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer trainId;
	
	private String trainName;
	private Integer trainCapacity;
	
	public Integer getTrainId() {
		return trainId;
	}
	public void setTrainId(Integer trainId) {
		this.trainId = trainId;
	}
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
