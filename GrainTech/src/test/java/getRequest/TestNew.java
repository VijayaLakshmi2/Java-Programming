package getRequest;


import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

import javax.imageio.ImageIO;

import org.apache.commons.codec.binary.Base64;
import org.apache.poi.util.IOUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestNew {
	
	String grainType;
	float quantity;
	String unit;
	String supplierName;
	String supplierCountry;
	String supplierRegion;
	String supplierCity;
	int supplierZipCode;
	String buyerName;
	String buyerCountry;
	String buyerRegion;
	String buyerCity;
	int buyerZipCode;
	String Notes;
	
	TestUtil testUtil=null;
	
	/*@SuppressWarnings({ "unchecked", "static-access" })
	@Test(priority=2,description="GrainTest")
	public void testbody(){
		try {
		testUtil=new TestUtil();
			Object[][] analysis=testUtil.getTestData("Analysis");
		
			for(int i=0;i<analysis.length;i++) {
				
				JSONObject requestParams = new JSONObject();
				JSONObject supplier = new JSONObject();
				JSONObject buyer = new JSONObject();
				
				
				JSONObject image1 = new JSONObject();
				JSONObject image2 = new JSONObject();
				JSONObject image3 = new JSONObject();
				JSONObject image4 = new JSONObject();
				JSONArray image = new JSONArray();
				
 				requestParams.put("GrainType", analysis[i][0]);
				requestParams.put("Quantity",analysis[i][1]);
				
				File f = new File("C:\\Users\\Vijay.Lakshmi\\Downloads\\test_images\\IMG_20180725_103708.jpg");		//change path of image according to you
				FileInputStream fis = new FileInputStream(f);
				System.out.println(f.);
				byte byteArray[] = new byte[(int)f.length()];
				fis.read(byteArray);
				String imageString = Base64.encodeBase64String(byteArray);
				
				InputStream iSteamReader = new FileInputStream("C:\\Users\\Vijay.Lakshmi\\Downloads\\test_images\\IMG_20180725_103708.jpg");
		        byte[] imageBytes = IOUtils.toByteArray(iSteamReader);
		        String imageString = Base64.encodeBase64String(imageBytes);
				
				image1.put("ImageData",imageString);
				image1.put("ImageType",analysis[i][3]);
				image2.put("ImageData",bytes2);
				image2.put("ImageType","uyty");
				image3.put("ImageData",bytes3);
				image3.put("ImageType","8967987");
				image4.put("ImageData",bytes4);
				image4.put("ImageType","ng5765");
				
				image.add(image1);
				image.add(image2);
				image.add(image3);
				image.add(image4);
				
				requestParams.put("ImageList", image);
				requestParams.put("Unit",analysis[i][4]);
				
				supplier.put("Name",analysis[i][5]);
				supplier.put("Country",analysis[i][6]);
				supplier.put("Region",analysis[i][7]);
				supplier.put("City",analysis[i][8]);
				supplier.put("ZipCode",analysis[i][9]);
				requestParams.put("SupplierDetails", supplier);
				
				buyer.put("Name",analysis[i][10]);
				buyer.put("Country",analysis[i][11]);
				buyer.put("Region",analysis[i][12]);
				buyer.put("City",analysis[i][13]);
				buyer.put("ZipCode",analysis[i][14]);
				requestParams.put("BuyerDetails", buyer);
				
				requestParams.put("Notes",analysis[i][15]);
				
				RestAssured.baseURI ="http://172.30.15.16:3000";
				RequestSpecification request = RestAssured.given();
				request.header("Content-Type", "application/json");
				 
				request.body(requestParams.toJSONString());
				 System.out.println(requestParams.toJSONString());
				// Post the request and check the response
				Response response = request.post("/GrainAnalysis/NewTest");
				System.out.println("Response is :"+response.toString());
			
				int statusCode = response.getStatusCode();
				System.out.println(response.asInputStream());
				Assert.assertEquals(statusCode, 200);
				System.out.println(statusCode);
				if(statusCode==200) {
					testUtil.writeData("Analysis", i, 16, "Pass");
				}
				System.out.println(statusCode);
				}
			
		}
		catch(Exception ex) {
			System.out.println("Fail");
		}
		
	}*/
	
	@Test(priority=1)
	public void GetData() throws ParseException {
		RestAssured.baseURI ="http://172.30.15.16:3000";
		RequestSpecification request1 = RestAssured.given();
		request1.header("Content-Type", "application/json");
		String input="5b5ecef26895be1224d66b43";
		
		Response response = request1.get("/GrainAnalysis/GetTestDetailsByID/{Id}",input);
		String data=response.asString();
	
		JSONObject obj = (JSONObject) new JSONParser().parse(data);
		//long time=get("http://172.30.15.16:3000/Analysis/5b4c6dde7ee1723f0c8d14e3").getTime();  
		
		String supplier = obj.get("SupplierDetails").toString();
		JSONObject supplierDetails=(JSONObject) new JSONParser().parse(supplier);
		String supplierName=supplierDetails.get("Name").toString();
		String supplierCountry=supplierDetails.get("Country").toString();
		String supplierRegion=supplierDetails.get("Region").toString();
		String supplierCity=supplierDetails.get("City").toString();
		String supplierZipCode=supplierDetails.get("ZipCode").toString();
		
		System.out.println(obj);
		System.out.println(supplierName);
		System.out.println(supplierCountry);
		System.out.println(supplierRegion);
		System.out.println(supplierCity);
		System.out.println(supplierZipCode);
		
	}
}


