package MiniProject;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
 
public class SearchMobile {
	String link;
	
	public static WebDriver driver; 
	
	public static WebDriver getWebDriver(String driverStr) {
 
 
		if(driverStr.equalsIgnoreCase("chrome")) {
			System.out.println("Chrome Browser is selected");
			//System.setProperty("webdriver.chrome.driver", "./driverFiles/chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
		}else if(driverStr.equalsIgnoreCase("edge")){
			System.out.println("Edge Browser is selected");
			//System.setProperty("webdriver.edge.driver", "./driverFiles/msedgedriver.exe");
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		return driver;
 
	}
	public static void LaunchUrl(String link) {
		// Launch Amazon website
		driver.get(link);
		System.out.println("1)Website Link\n	"+driver.getCurrentUrl()+"\n");
 
	}
	public static void MaximizeWindow() {
 
		//maximize browser window
		driver.manage().window().maximize();
		System.out.println("2)Window Maximized\n");
	}
 
	public static void toSearch(String toSearch) {
 
		// wait till the browser loads
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//Search “mobile smartphones under 30000”
		WebElement ToSearch = driver.findElement(By.id("twotabsearchtextbox"));
		ToSearch.sendKeys(toSearch);
		//Search Button
		driver.findElement(By.id("nav-search-submit-button")).click();
		System.out.println("3)To Search\n	"+toSearch+"\n");
	}
 
	public static void Validation(String toSearch) {
 
		//Validation
		WebElement searchElement = driver.findElement(By.className("a-color-state"));
		//Get searchString
		String searchString = searchElement.getText();
 
		WebElement page_Items= driver.findElement(By.className("a-section"));
		String page_Items_text = page_Items.getText();
		System.out.println("4)Validation Display Message\n	"+  page_Items_text+"\n");
 
		//Check Validation message
		if(toSearch.equals(searchString.substring(1,searchString.length()-1))) {
 
			System.out.println("\ti)search string VALIDATION SUCCESSFUL\n\t\tExpected: "+ 
					searchString.substring(1,searchString.length()-1)+
					"\n\t\tActual: "+ toSearch+"\n");
		}else {
			System.out.println("\ti)search string VALIDATION UNSUCCESFUL/n\t\tExpected: "+
					searchString.substring(1,searchString.length()-1)+
					"\n\t\tActual: "+ toSearch+ "\n");
		}
		// Get Search Page & No_Of_Items
		String SearchPage_Items = driver.findElement(By.className("sg-col-inner")).getText();
 
		if(SearchPage_Items.startsWith("1-") && SearchPage_Items.contains("of over") && SearchPage_Items.contains("results for")) {
			System.out.println("\tii)no of pages and items 'VALIDATION SUCCESSFUL'");
		}else {
			System.out.println("\tii)no of pages and items 'VALIDATION UNSUCCESSFUL'");
 
		}
	}

 
	public static void dropSelect(String toSelect) {
 
			   driver.findElement(By.xpath("//*[@id='a-autoid-0-announce']")).click();
			   driver.findElement(By.xpath("//a[@id='s-result-sort-select_4']")).click();
				  System.out.println("5)sort by dropdown menu is clicked");
				  System.out.println();
				  System.out.println("6)counting the number of options available in sort by dropdown menu");
					List<WebElement> list=driver.findElements(By.xpath("//li[@tabindex=0]/a"));
					
					
					int count=0,exp_srtby=5;
					for(int i=0;i<list.size();i++)
					{
						count++;
					}
					if(count==exp_srtby)
					{
						System.out.println("The no of sort by options matches with the expected values i,e "+count);
						System.out.println();
					}
					else
						System.out.println("The no of sort by options does not matches with the expected values i,e "+count);
					   System.out.println();
			  }
		
	  
	
	public static void screenShot() throws IOException, InterruptedException {
		Thread.sleep(3000);
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File target= new File("C:\\workspace\\java\\OnlineMobileSearch\\src\\test\\resources\\snaps\\final.png");
		FileUtils.copyFile(source, target);
	}
 
	
	public static void closeBrowser() {
		System.out.println("Browser Closed");
		driver.quit();
	}
 
}
