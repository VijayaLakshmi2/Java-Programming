package getRequest;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.codec.binary.Base64;
import org.apache.poi.util.IOUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
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

	TestUtil testUtil = null;

	@BeforeMethod
	public void setup() {

		// Defining the BaseURL
		RestAssured.baseURI = "http://172.30.15.16:3000";
		testUtil = new TestUtil();
	}

	@SuppressWarnings({ "unchecked", "static-access" })
	@Test(priority = 2, description = "GrainTest")
	public void testbody() {
		try {
			Object[][] analysis = testUtil.getTestData("Analysis");

			for (int i = 0; i < analysis.length; i++) {

				// Creating JSON Object
				JSONObject requestParams = new JSONObject();
				JSONObject supplier = new JSONObject();
				JSONObject buyer = new JSONObject();

				JSONObject image1 = new JSONObject();
				// Creating JSON Array
				JSONArray image = new JSONArray();

				requestParams.put("GrainType", analysis[i][0]);
				requestParams.put("Quantity", analysis[i][1]);

				/*
				 * File f = new File(
				 * "C:\\Users\\Vijay.Lakshmi\\Downloads\\test_images\\IMG_20180725_103708.jpg");
				 * //change path of image according to you FileInputStream fis = new
				 * FileInputStream(f); byte byteArray[] = new byte[(int)f.length()];
				 * fis.read(byteArray); String imageString =
				 * Base64.encodeBase64String(byteArray);
				 */
				//
				InputStream iSteamReader = new FileInputStream((String) analysis[i][16]);
				byte[] imageBytes = IOUtils.toByteArray(iSteamReader);
				String imageString = Base64.encodeBase64String(imageBytes);

				image1.put("ImageData", imageString);
				image1.put("ImageType", analysis[i][3]);

				image.add(image1);

				requestParams.put("ImageList", image);
				requestParams.put("Unit", analysis[i][4]);

				supplier.put("Name", analysis[i][5]);
				supplier.put("Country", analysis[i][6]);
				supplier.put("Region", analysis[i][7]);
				supplier.put("City", analysis[i][8]);
				supplier.put("ZipCode", analysis[i][9]);
				requestParams.put("SupplierDetails", supplier);

				buyer.put("Name", analysis[i][10]);
				buyer.put("Country", analysis[i][11]);
				buyer.put("Region", analysis[i][12]);
				buyer.put("City", analysis[i][13]);
				buyer.put("ZipCode", analysis[i][14]);
				requestParams.put("BuyerDetails", buyer);

				requestParams.put("Notes", analysis[i][15]);

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
					testUtil.writeData("Analysis", i, 16, "Pass");
				}
			}

		} catch (Exception ex) {
			System.out.println("Fail");
		}

	}

	@SuppressWarnings({ "static-access", "unused" })
	@Test(priority = 1)
	public void GetData() throws ParseException {

		try {
			Object[][] getData = testUtil.getTestData("GetTestDetailsByID");
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
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
