package com.pratian.GrainTechServicesTesting;

import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.commons.codec.binary.Base64;
import org.apache.poi.util.IOUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pratian.entities.TestDetail;
import com.pratian.utilities.ExcelReadWrite;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

@Test
public class GrainAnalysisNewTest {
	
	
	ExcelReadWrite excelReadWrite = null;
	TestDetail testDetail=null;
	@BeforeMethod
	public void setup() {

		// Defining the BaseURL
		RestAssured.baseURI = "http://172.30.15.16:3000";
		excelReadWrite = new ExcelReadWrite();
	}

	@SuppressWarnings({ "unchecked", "static-access" })
	@Test
	public void testbody() {
		try {
			Object[][] analysis = excelReadWrite.getTestData("Analysis");
			testDetail=new TestDetail();

			for (int i = 0; i < analysis.length; i++) {
				
				testDetail.setGrainType((String) analysis[i][0]);
				testDetail.setQuantity((Float) analysis[i][1]);
				testDetail.setImageType((String) analysis[i][3]);
				testDetail.setImageData((String) analysis[i][16]);
				testDetail.setUnit((String) analysis[i][4]);
				testDetail.setSupplierName((String) analysis[i][5]);
				testDetail.setSupplierCity((String) analysis[i][6]);
				testDetail.setSupplierRegion((String) analysis[i][7]);
				testDetail.setSupplierCountry((String) analysis[i][8]);
				testDetail.setSupplierZipCode((Integer) analysis[i][9]);
				testDetail.setBuyerName((String) analysis[i][10]);
				testDetail.setBuyerCity((String) analysis[i][11]);
				testDetail.setBuyerRegion((String) analysis[i][12]);
				testDetail.setBuyerCountry((String) analysis[i][13]);
				testDetail.setBuyerZipCode((Integer) analysis[i][14]);
				testDetail.setNotes((String) analysis[i][15]);

				// Creating JSON Object
				JSONObject requestParams = new JSONObject();
				JSONObject supplier = new JSONObject();
				JSONObject buyer = new JSONObject();

				JSONObject image1 = new JSONObject();
				// Creating JSON Array
				JSONArray image = new JSONArray();

				requestParams.put("GrainType", testDetail.getGrainType());
				requestParams.put("Quantity", testDetail.getQuantity());

				InputStream iSteamReader = new FileInputStream(testDetail.getImageData());
				byte[] imageBytes = IOUtils.toByteArray(iSteamReader);
				String imageString = Base64.encodeBase64String(imageBytes);

				image1.put("ImageData", imageString);
				image1.put("ImageType", testDetail.getImageType());

				image.add(image1);

				requestParams.put("ImageList", image);
				requestParams.put("Unit", testDetail.getUnit());

				supplier.put("Name", testDetail.getSupplierName());
				supplier.put("Country", testDetail.getSupplierCountry());
				supplier.put("Region", testDetail.getSupplierRegion());
				supplier.put("City", testDetail.getSupplierCity());
				supplier.put("ZipCode", testDetail.getSupplierZipCode());
				requestParams.put("SupplierDetails", supplier);

				buyer.put("Name", testDetail.getBuyerName());
				buyer.put("Country", testDetail.getBuyerCountry());
				buyer.put("Region", testDetail.getBuyerRegion());
				buyer.put("City", testDetail.getBuyerCity());
				buyer.put("ZipCode", testDetail.getBuyerZipCode());
				requestParams.put("BuyerDetails", buyer);

				requestParams.put("Notes", testDetail.getNotes());

				// Specify a default request specification that will be sent with each request
				RequestSpecification request = RestAssured.given();

				// Passing the Headers to that Request
				request.header("Content-Type", "application/json");

				// Passing the Body to that Request
				request.body(requestParams.toJSONString());

				// System.out.println(requestParams.toJSONString());

				// Getting the Response of that Request
				Response response = request.post("/GrainAnalysis/NewTest");
				System.out.println("Response is :" + response.toString());

				int statusCode = response.getStatusCode();
				Assert.assertEquals(statusCode, 200);

				if (statusCode == 200) {
					excelReadWrite.writeData("Analysis", i, 16, "Pass");
				}
			}

		} catch (Exception ex) {
			System.out.println("Fail");
		}

	}

}
