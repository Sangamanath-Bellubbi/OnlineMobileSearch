package onec;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub


			// TODO Auto-generated method stub
			WebDriver driver=new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
			
				//static WebDriver driver;

					// TODO Auto-generated method stub

					driver=new ChromeDriver();

					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
                    driver.get("https://be.cognizant.com");

					driver.manage().window().maximize();

					driver.findElement(By.cssSelector("div[title=\"OneCognizant\"]")).click();


					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

					//driver.findElement(By.xpath("//*[@id=\"DesktopPlatformBar\"]/div[3]/div/div[2]")).click();



					Set<String> windows =driver.getWindowHandles();

					for(String w:windows)

					{

						String title = driver.switchTo().window(w).getTitle();

						if(title.equals("OneCognizant"))

						{

							driver.switchTo().window(w);

						}

					}

					Thread.sleep(3000);

					driver.findElement(By.xpath("//input[@id='oneC_searchAutoComplete']")).click();

					Thread.sleep(3000);

					driver.findElement(By.xpath("//input[@id='oneC_searchAutoComplete']")).sendKeys("TruTime");

					List<WebElement> ls=driver.findElements(By.xpath("//div[@class='appsSearchResult']"));

					ls.get(0).click();

					 Thread.sleep(6000);


					//WebElement e= driver.findElement(By.xpath("//td[@class='notFadedDays ng-class:items.MonthName ng-scope March highlight bordrLeftBlue myClass']"));

					 //System.out.println(e.getText());

					// String s1=driver.getWindowHandle();

					// System.out.println(s1);

					//List<WebElement> l1=driver.findElements(By.xpath("//div[@class='dayHeadr ng-binding ng-scope']"));

    				 //List<WebElement> l1=driver.findElements(By.xpath("//*[contains(@class,'dayHeadr')]"));
                     //driver.findElement(By.xpath("//*[contains(@class,'dayHeadr active')]").getText();
 					//System.out.println(l1.getText());\
					// driver.switchTo().frame(0)
					// driver.findElement(By.xpath("//*[@id=\"mCSB_2_container\"]/div[1]/div[2]/div[3]/div[5]/div")).click();
					 //driver.findElement(By.xpath("//*[@id=\"mCSB_2_container\"]/div[2]/div[2]/div")).click();
					 driver.getWindowHandle();


			}
	}
