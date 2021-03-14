package com.example.demo.enums;

public enum FileName {
	
	
	MALE_NAMES("maleNames.txt"), FEMALE_NAMES("femaleNames.txt");
	
	String fileName;
	
	private FileName(String fileName) {
		this.fileName = fileName;
	}
	
	public String getFileName() {
		return this.fileName;
	}
	
}
