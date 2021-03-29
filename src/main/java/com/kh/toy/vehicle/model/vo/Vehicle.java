package com.kh.toy.vehicle.model.vo;

public class Vehicle {
	private String vehicleIdx; // 차량관리번호
	private String generationIdx; //세대관리번호
	private String vehicleNumber; //차량번호
	private String vehicleIMG; //qr이미지
	private int isVehicle; //삭제여부


	public String getVehicleIdx() {
		return vehicleIdx;
	}


	public void setVehicleIdx(String vehicleIdx) {
		this.vehicleIdx = vehicleIdx;
	}


	public String getGenerationIdx() {
		return generationIdx;
	}


	public void setGenerationIdx(String generationIdx) {
		this.generationIdx = generationIdx;
	}


	public String getVehicleNumber() {
		return vehicleNumber;
	}


	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}


	public String getVehicleIMG() {
		return vehicleIMG;
	}


	public void setVehicleIMG(String vehicleIMG) {
		this.vehicleIMG = vehicleIMG;
	}


	public int getIsVehicle() {
		return isVehicle;
	}


	public void setIsVehicle(int isVehicle) {
		this.isVehicle = isVehicle;
	}


	@Override
	public String toString() {
		return "Vehicle [vehicleIdx=" + vehicleIdx + ", generationIdx=" + generationIdx + ", vehicleNumber="
				+ vehicleNumber + ", vehicleIMG=" + vehicleIMG + ", isVehicle=" + isVehicle + "]";
	}

	
	
}
