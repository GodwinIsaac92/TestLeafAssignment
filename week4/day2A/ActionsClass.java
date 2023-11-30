package week4.day2A;



import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class ActionsClass {

	public static void main(String[] args) throws InterruptedException, IOException {


		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));	
		
		Actions actions = new Actions(driver);
		WebElement mensFashion = driver.findElement(By.xpath("//span[@class='catText']"));
		actions.moveToElement(mensFashion).perform();
		driver.findElement(By.xpath("//span[text()='Sports Shoes']")).click();
		WebElement countSportsShoes = driver.findElement(By.xpath("//span[@class='category-name category-count']"));
		String count = countSportsShoes.getText();
		System.out.println("Sprots Shoes Count : " + count);
		driver.findElement(By.xpath("//div[text() = 'Training Shoes']")).click();
		driver.findElement(By.xpath("//div[@class='sort-selected']")).click();
		driver.findElement(By.xpath("//li[@data-sorttype='plth']")).click();
		Thread.sleep(3000);
		List<WebElement> price = new ArrayList<WebElement>();
		price = driver.findElements(By.xpath("//span[@class='lfloat product-price']"));
		List<String> amt = new ArrayList<String>();
		int size = price.size();
		for (int i = 0; i < size; i++) 
		{
			WebElement price1 = price.get(i);
			String price2 = price1.getText();
			amt.add(price2);
		}
		Collections.sort(amt);
		System.out.println("Avabile amount in display : " + amt);
		driver.findElement(By.xpath("//input[@name = 'fromVal']")).clear();
		driver.findElement(By.xpath("//input[@name = 'fromVal']")).sendKeys("500");
		driver.findElement(By.xpath("//input[@name = 'toVal']")).clear();
		driver.findElement(By.xpath("//input[@name = 'toVal']")).sendKeys("900");
		driver.findElement(By.xpath("//div[@class ='price-go-arrow btn btn-line btn-theme-secondary']")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='sdCheckbox filters-list ']")).click();
		Thread.sleep(2000);
		WebElement colorFilter = driver.findElement(By.xpath("//div[@class='filters']"));
		String filter = colorFilter.getText();
		System.out.println(filter);
		WebElement blackShoes = driver.findElement(By.xpath("//div[@class='product-tuple-image ']"));
		actions.moveToElement(blackShoes).perform();
		driver.findElement(By.xpath("//div[@class='center quick-view-bar  btn btn-theme-secondary  ']")).click();
		WebElement ele5 = driver.findElement(By.xpath("//div[@class='tag-title']/following::div[3]"));
		Thread.sleep(2000);
		String priceAmt = ele5.getText();
		System.out.println("The Price and Discount are : " + priceAmt);
		Thread.sleep(3000);
		File screenShot3 = driver.getScreenshotAs(OutputType.FILE);
		File location3 = new File("./snap/beforeclick1.png");
		FileUtils.copyFile(screenShot3, location3);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='close close1 marR10']")).click();
		driver.close();

	}

}
