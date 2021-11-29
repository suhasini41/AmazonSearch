package test_data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestDataReader
{
	public static Object[][] read(String filePath, String SheetName)
	{
		FileInputStream in = null;
		XSSFWorkbook workbook = null;
		try {
			in = new FileInputStream(filePath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			workbook = new XSSFWorkbook(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		XSSFSheet sheet = workbook.getSheet(SheetName);
		int rows = sheet.getPhysicalNumberOfRows()-1;
		Object[][] data = new Object[rows][1];
		DataFormatter form = new DataFormatter();
		for(int i=0;i<rows;i++)
		{
			Map<String,String> map = new HashMap<>();
			String key = form.formatCellValue(sheet.getRow(0).getCell(0));
			String value = form.formatCellValue(sheet.getRow(i+1).getCell(0));
			map.put(key, value);
			data[i][0] = map;
		}
		return data;
	}

}
