package com.example.hackathon;

public class VibrationDataStructure {
	private String collecting_time;
	private double geo_longitude;
	private double geo_latitude;
	private double[] gyro_data;
	private String sensor_id;
	private int sensor_type;
	public String getCollecting_time() {
		return collecting_time;
	}
	public void setCollecting_time(String collecting_time) {
		this.collecting_time = collecting_time;
	}
	public double getGeo_longitude() {
		return geo_longitude;
	}
	public void setGeo_longitude(double geo_longitude) {
		this.geo_longitude = geo_longitude;
	}
	public double getGeo_latitude() {
		return geo_latitude;
	}
	public void setGeo_latitude(double geo_latitude) {
		this.geo_latitude = geo_latitude;
	}
	public double[] getGyro_data() {
		return gyro_data;
	}
	public void setGyro_data(double[] gyro_data) {
		this.gyro_data = gyro_data;
	}
	public String getSensor_id() {
		return sensor_id;
	}
	public void setSensor_id(String sensor_id) {
		this.sensor_id = sensor_id;
	}
	public int getSensor_type() {
		return sensor_type;
	}
	public void setSensor_type(int sensor_type) {
		this.sensor_type = sensor_type;
	}
	
	
}
