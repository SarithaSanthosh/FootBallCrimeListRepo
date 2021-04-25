package com.saritha.football.services.footballcrimelistservices.model.footballcrimeresponse;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;

public class FootBallCrimeData {
	
	String address;
	String name;
	String category;
	@Override
	public String toString() {
		return "FootBallCrimeData [address=" + address + ", name=" + name + ", category=" + category + ", month="
				+ month + "]";
	}
	@JsonFormat(pattern= "MM-yyyy")
	LocalDate month;
	public LocalDate getMonth() {
		return month;
	}
	public void setMonth(LocalDate month) {
		this.month = month;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	

}
