package com.trainservice.java.entity;

public class TrainAmenitie {
	
	private Integer trainAmenitieId;
	private Amenitie trainAmenitie; // ENUM
	private Integer trainId;
	
	public Integer getTrainAmenitieId() {
		return trainAmenitieId;
	}
	public void setTrainAmenitieId(Integer trainAmenitieId) {
		this.trainAmenitieId = trainAmenitieId;
	}
	public Amenitie getTrainAmenitie() {
		return trainAmenitie;
	}
	public void setTrainAmenitie(Amenitie trainAmenitie) {
		this.trainAmenitie = trainAmenitie;
	}
	public Integer getTrainId() {
		return trainId;
	}
	public void setTrainId(Integer trainId) {
		this.trainId = trainId;
	}
}
