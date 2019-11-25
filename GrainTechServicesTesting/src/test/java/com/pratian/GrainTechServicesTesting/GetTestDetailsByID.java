package com.pratian.GrainTechServicesTesting;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pratian.utilities.ExcelReadWrite;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

@Test
public class GetTestDetailsByID {
	
	ExcelReadWrite excelReadWrite = null;
	@BeforeMethod
	public void setup() {

		// Defining the BaseURL
		RestAssured.baseURI = "http://172.30.15.16:3000";
		excelReadWrite = new ExcelReadWrite();
	}
	@Test
	public void GetData() throws ParseException, IOException {

		//Object[][] getData = excelReadWrite.getTestData("GetTestDetailsByID");
		RequestSpecification request1 = RestAssured.given();
		request1.header("Content-Type", "application/json");
		String input = "5b5ecef26895be1224d66b43";

		Response response = request1.get("/GrainAnalysis/GetTestDetailsByID/{Id}", input);
		String data = response.asString();

		JSONObject obj = (JSONObject) new JSONParser().parse(data);

		String supplier = obj.get("SupplierDetails").toString();
		JSONObject supplierDetails = (JSONObject) new JSONParser().parse(supplier);
		String supplierName = supplierDetails.get("Name").toString();
		String supplierCountry = supplierDetails.get("Country").toString();
		String supplierRegion = supplierDetails.get("Region").toString();
		String supplierCity = supplierDetails.get("City").toString();
		String supplierZipCode = supplierDetails.get("ZipCode").toString();

		System.out.println(obj);
		System.out.println(supplierName);
		System.out.println(supplierCountry);
		System.out.println(supplierRegion);
		System.out.println(supplierCity);
		System.out.println(supplierZipCode);

	}

}
