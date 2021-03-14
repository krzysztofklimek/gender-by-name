package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.GenderService;
import com.example.demo.service.NameService;

@RestController
public class GenderController {
	
	@Autowired
	GenderService genderService;
	
	@Autowired
	NameService nameService;
	
	
	@GetMapping(value="{variant}/{name}")
	public String firstVariant(@PathVariable int variant, @PathVariable String name){
		if(variant == 1)
			return genderService.verifyGenderFirstVariant(name).getGenderMessage();
		else if(variant == 2)
			return genderService.verifyGenderSecondVariant(name).getGenderMessage();
		else
			return "wrong variant value";
	}
	
	@GetMapping(value="names")
	public String secondVariant(){
		return nameService.displayNames();
	}
}
