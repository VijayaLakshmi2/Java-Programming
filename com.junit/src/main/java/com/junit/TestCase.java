package com.junit;

import org.junit.After;

import org.junit.AfterClass;

import org.junit.Before;

import org.junit.BeforeClass;

import org.junit.Test;

public class TestCase {

	int num1;

	int num2;

	int result;

	@Test

	public void add() {

		int actualresult = num1 + num2;

		System.out.println("Executing  Test1");

		System.out.println(actualresult);

	}

	@Test

	public void multiply() {

		int actualresult = num1 * num2;

		System.out.println("Executing  Test 2");

		System.out.println(actualresult);

	}

	@After

	public void tearDown() {

		System.out.println("Executing After Test");

		num1 = 0;

		num2 = 0;

		System.out.println(+num1 + num2);

	}

	@Before

	public void setUp() {

		num1 = 2;

		num2 = 2;

		result = 5;

		System.out.println("Executing Before Test");

	}

	@BeforeClass

	public static void beforeClass() {

		System.out.println("Executing Before Class");

	}

	@AfterClass

	public static void afterClass() {

		System.out.println("Executing After Class");

	}

}