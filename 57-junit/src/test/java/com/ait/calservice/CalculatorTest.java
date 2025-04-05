package com.ait.calservice;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ait.service.CalculatorService;

public class CalculatorTest {
	private CalculatorService calculatorService;
	//setup
	@BeforeAll
	static void initAll() {
		System.out.println("starting calculation service");
	}
	@BeforeEach
	 void init() {
		calculatorService=new CalculatorService();
		System.out.println("starting a test");
	}
	@AfterEach
	void tearDown() {
		System.out.println("finshed a test");
	}
	@AfterAll
	static void tearDownAll() {
		System.out.println("finshed a calculation service");
	}
	@Test
	void testAdd() {
		int value = calculatorService.add(2, 3);
		assertEquals(6, value);
	}
	
}
