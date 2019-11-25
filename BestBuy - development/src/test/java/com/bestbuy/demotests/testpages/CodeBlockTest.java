package com.bestbuy.demotests.testpages;

import java.util.HashMap;
import java.util.Map;

import com.bestbuy.demo.utils.Excel;

public class CodeBlockTest {

	public static void main(String[] args) {
		
        Object[][] obj =
            (new Excel("./src/main/resources/TestData/TestData.xlsx")).readData("Sub Categories");

    System.out.println("LENGTH: "+obj.length);
    Map<String, String> map ;
    for(int i=0; i<obj.length; i++) {
       
        map = new HashMap<String, String>();
        map = (Map<String, String>) obj[i][0];
        System.out.println("MAP: "+map);
//        for (Map.Entry<String, String> entry : map.entrySet() ) {
//            System.out.println(entry.getKey()+" : "+entry.getValue());
//        }
    }
}

}
