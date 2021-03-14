package com.example.demo.service;

import java.io.FileNotFoundException;

public interface NameService {

	boolean verifyGenderName(String name, String fileName) throws FileNotFoundException;
	String displayNames();
	
}
