package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
@DataProvider(name="LoginData")
public String[][]getData() throws IOException
{
	String path=".\\testData\\OpenCart_LoginData.xlsx";//taking xl file from testdata
	ExcelUtility xlutil=new ExcelUtility(path);//creating an object for xlutility
    
	int totalrows=xlutil.getRowCount("Sheet1");
	System.out.println(totalrows);//5
	int totalcols=xlutil.getCellCount("Sheet1", 1);// 1 means row number
	System.out.println(totalcols);//3
	String logindata[][]=new String[totalrows][totalcols];//created for two dimesion array which can store
	for (int i = 1; i <= totalrows; i++) //1
	{
		  
		for (int j = 0; j < totalcols; j++) //0
		{
			logindata[i-1][j]=xlutil.getCellData("Sheet1", i, j);//1,0
			//i-1 means 0 array index is start from 0
		}
		
	}
	return logindata;//returning two dimension array
	
}
}
