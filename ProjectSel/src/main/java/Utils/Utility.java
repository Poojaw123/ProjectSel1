package Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Utility
{
	public static String getDataFromExcel() throws EncryptedDocumentException, IOException
	{
		String data = null;
		String path="C:\\Users\\Pooja Amrutkar\\OneDrive\\Desktop\\user.xlsx";
		FileInputStream file=new FileInputStream(path);
		Workbook book=WorkbookFactory.create(file);
		Sheet s=book.getSheet("Sheet1");
		
		
		for(int i=0;i<=1;i++)
		{
			String data1=s.getRow(i).getCell(0).getStringCellValue();
		}
		
		
		return data;
	}

	
	}
