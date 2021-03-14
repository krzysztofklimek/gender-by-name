package com.example.demo.service;

import com.example.demo.enums.Gender;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import com.example.demo.enums.FileName;

@Service
public class NameServiceImpl implements NameService{
	
	
	@Override
	public boolean verifyGenderName(String nameToken, String fileName) throws FileNotFoundException {
		boolean properGenderName;
		Scanner sc = new Scanner(new File(fileName));
		properGenderName = compareNames(sc, nameToken);
		sc.close();
		return properGenderName;
	}
	
	private boolean compareNames(Scanner sc, String nameToken) {
		boolean equals = false;
		while(sc.hasNext() && !equals) {
			var nameFromFile = sc.next();
			equals = nameFromFile.equalsIgnoreCase(nameToken);
		}
		return equals;
	}
	
	@Override
	public String displayNames(){
		StringBuilder names = new StringBuilder();
		try (Scanner scMale = new Scanner(new File(FileName.MALE_NAMES.getFileName()))) {
			names.append("MALE NAMES:");
			while(scMale.hasNext())
				names.append(" " + scMale.next() + ",");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try (Scanner scFemale = new Scanner(new File(FileName.FEMALE_NAMES.getFileName()))) {
			names.deleteCharAt(names.length() - 1);
			names.append("; FEMALE NAMES:");
			while(scFemale.hasNext()) 
				names.append(" " + scFemale.next() + ",");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		names.deleteCharAt(names.length() - 1);
		names.append(";");
		return names.toString();
	}
	
}
