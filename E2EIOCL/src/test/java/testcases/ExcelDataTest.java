package testcases;

import java.util.Map;

import org.testng.annotations.Test;

import dataprovider.DataProviders;

public class ExcelDataTest {
	
	@Test(dataProvider="customerData", dataProviderClass=DataProviders.class)
	public void test1(Map<String,String>map) {
		
		System.out.println(map.get("PAN"));
			
				
		
		
	}

}
