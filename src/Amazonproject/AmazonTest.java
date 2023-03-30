package Amazonproject;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonTest {

	public static void main(String[] args) throws InterruptedException,IOException{
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		
		WebElement search = driver.findElement(By.xpath("//input[@placeholder='Search Amazon.in']"));
		search.sendKeys("samsung mobile");
		
		WebElement searchbutton = driver.findElement(By.id("nav-search-submit-button"));
		
		
        WebElement element1 = driver.findElement(By.id("nav-search-submit-button"));
		JavascriptExecutor object = (JavascriptExecutor) driver;		
		object.executeScript("arguments[0].scrollIntoView();",element1);
		searchbutton.click();
		
		TakesScreenshot tsObj = (TakesScreenshot) driver;
		File fileObj = tsObj.getScreenshotAs(OutputType.FILE);
		File screenshotObj = new File("image.png");
		
		FileUtils.copyFile(fileObj,screenshotObj);
		
		List<WebElement> samsungproductnames = driver.findElements(By.xpath("//div[@class='a-section']//h2//span"));	
		List<WebElement> samsungproductprice = driver.findElements(By.xpath("//div[@class='sg-row']//span[@class='a-price-whole']"));
		List<WebElement> currency = driver.findElements(By.xpath("//div[@class='sg-row']//span[@class='a-price-symbol']"));
		
		for(int i=0;i<samsungproductnames.size();i++)
			
		{
			System.out.println(" the products are " + samsungproductnames.get(i).getText());
			
			System.out.println(" the product Price are "+currency.get(i).getText() + " " +samsungproductprice.get(i).getText());
			
			
		}
	}

}
