package com.example.demo.service;

import java.io.FileNotFoundException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.enums.FileName;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NameServiceTest {
	
	@Autowired
	NameService nameService;
	
	@Test
	public void verifyGenderName_withProperNames_true() throws FileNotFoundException {
		Assert.assertTrue(nameService.verifyGenderName("Krzysztof", FileName.MALE_NAMES.getFileName()));
		Assert.assertTrue(nameService.verifyGenderName("Katarzyna", FileName.FEMALE_NAMES.getFileName()));
	}
	
	@Test
	public void verifyGenderName_withoutProperNames_false() throws FileNotFoundException {
		Assert.assertFalse(nameService.verifyGenderName("ccececece", FileName.MALE_NAMES.getFileName()));
		Assert.assertFalse(nameService.verifyGenderName("asdfgasdf", FileName.FEMALE_NAMES.getFileName()));
	}
	

}
