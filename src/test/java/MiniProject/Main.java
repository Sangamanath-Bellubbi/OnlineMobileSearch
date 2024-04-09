package MiniProject;
 
 
import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;
 
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
 
public class Main {      
 
	public static void main(String[] args) {
 
		boolean bol = true;
		System.out.println("Enter the browser to Automate (Chrome/Edge)");
		while(bol) {
			Scanner sc = new Scanner(System.in);
			String Browser = sc.next();
			if(Browser.equalsIgnoreCase("Chrome") || (Browser.equalsIgnoreCase("Edge"))){
				SearchMobile.getWebDriver(Browser);
				bol =false;
				sc.close();
			}else {
				System.out.println("Enter Valid Browser name(Chrome/Edge)");	
			}	
		}
		try {
			File excelFile = new File("C:\\workspace\\java\\OnlineMobileSearch\\src\\test\\resources\\data\\Details.xlsx");
 
			FileInputStream fis = new FileInputStream(excelFile);
 
			XSSFWorkbook workBook = new XSSFWorkbook(fis);
 
			XSSFSheet sheet= workBook.getSheet("Sheet1");
 
			XSSFRow r1 =sheet.getRow(1);
 
			XSSFCell c1 = r1.getCell(0);
			XSSFCell c2 = r1.getCell(1);
			XSSFCell c3 =r1.getCell(2);
			workBook.close();
			
			// Get from Excel
			//Website link , toSearch 
			String link = c1.toString();
			String toSearch = c2.toString();
			String toSelect = c3.toString();
 
 
			SearchMobile.LaunchUrl(link);
 
			SearchMobile.MaximizeWindow();
			
			SearchMobile.toSearch(toSearch);
 
			SearchMobile.Validation(toSearch);
 
			SearchMobile.dropSelect(toSelect);
			
			SearchMobile.screenShot();
 
			SearchMobile.closeBrowser();
		}
		catch(Exception e )
		{
			System.out.println(e.getLocalizedMessage());
			e.getStackTrace();
		}

	}
}
