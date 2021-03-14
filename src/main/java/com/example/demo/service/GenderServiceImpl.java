package com.example.demo.service;

import java.io.FileNotFoundException;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.enums.FileName;
import com.example.demo.enums.Gender;

@Service
public class GenderServiceImpl implements GenderService {
	
	
	@Autowired
	NameService nameService;

	
	@Override
	public Gender verifyGenderFirstVariant(String name) {
		Gender gender = Gender.INCONCLUSIVE;
		Scanner sc = new Scanner(name).useDelimiter(" ");
		if(sc.hasNext()) {
			String nameToken = sc.next();
			try {
				if(nameService.verifyGenderName(nameToken, FileName.MALE_NAMES.getFileName()))
					gender = Gender.MALE;
				else if(nameService.verifyGenderName(nameToken, FileName.FEMALE_NAMES.getFileName()))
					gender = Gender.FEMALE;
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		sc.close();
		return gender;
	}
	
	
	@Override
	public Gender verifyGenderSecondVariant(String name) {
		int maleNames = 0;
		int femaleNames = 0;
		Scanner sc = new Scanner(name).useDelimiter(" ");
		while(sc.hasNext()) {
			String nameToken = sc.next();
			try {
				
				if(nameService.verifyGenderName(nameToken, FileName.MALE_NAMES.getFileName()))
					maleNames++;
				if(nameService.verifyGenderName(nameToken, FileName.FEMALE_NAMES.getFileName()))
					femaleNames++;

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		sc.close();
		if(maleNames > femaleNames)
			return Gender.MALE;
		else if(maleNames < femaleNames)
			return Gender.FEMALE;
		else
			return Gender.INCONCLUSIVE;
	}

}
