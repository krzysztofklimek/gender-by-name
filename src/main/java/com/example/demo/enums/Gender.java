package com.example.demo.enums;

public enum Gender {

	MALE("Male"), FEMALE("Female"), INCONCLUSIVE("Inconclusive");
	
	String genderMessage;
	
	private Gender(String genderMessage) {
		this.genderMessage = genderMessage;
	}
	
	public String getGenderMessage() {
		return this.genderMessage;
	}
	
}
