package com.example.demo.service;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.enums.Gender;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GenderServiceTest {
	
	@Autowired
	GenderService genderService;
	
	@Test
	public void verifyGenderFirstVariant_withProperName_returnMaleGender() {
		Assert.assertEquals(Gender.MALE, genderService.verifyGenderFirstVariant("Krzysztof"));
	}
	
	@Test
	public void verifyGenderFirstVariant_withWrongName_returnInconclusiveGender() {
		Assert.assertEquals(Gender.INCONCLUSIVE, genderService.verifyGenderFirstVariant("Imieee"));
	}
	
	@Test
	public void verifyGenderSecondVariant_withTwoMaleNamesAndOneFemale_returnMaleGender() {
		Assert.assertEquals(Gender.MALE, genderService.verifyGenderFirstVariant("Krzysztof Ewa Patryk"));
	}
	
	@Test
	public void verifyGenderSecondVariant_withTwoFealeNamesAndOneMale_returnFealeGender() {
		Assert.assertEquals(Gender.FEMALE, genderService.verifyGenderFirstVariant("Katarzyna Katarzyna Krzysztof"));
	}

}
