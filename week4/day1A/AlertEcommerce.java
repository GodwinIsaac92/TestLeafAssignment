package week4.day1A;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertEcommerce {

	public static void main(String[] args) throws InterruptedException {

		ChromeDriver driver = new ChromeDriver();
		driver.get("https://buythevalue.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//input[@class = 'input-group-field input__field-2']")).sendKeys("Hamdard Hing - 50GM");
		Thread.sleep(5000);
		//driver.findElement(By.xpath("//span[@class = 'input-group-btn']")).click();
		driver.findElement(By.xpath("//div[@class = 'item-search']")).click();
		driver.findElement(By.xpath("//input[@name = 'wk_zipcode']")).sendKeys("600 015");
		driver.findElement(By.xpath("//input[@class = 'btn']")).click();
		driver.findElement(By.xpath("//button[@id ='product-add-to-cart']")).click();
		//driver.findElement(By.xpath("//a[@class ='cartToggle']")).click();
		/*
		 * driver.findElement(By.xpath("//a[text() = 'View Cart']")).click(); Alert
		 * alert = driver.switchTo().alert(); alert.accept();
		 */
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@class = 'view-cart']")).click();
		driver.findElement(By.xpath("//input[@id ='checkout']")).click();
		Thread.sleep(5000);
		Alert alert = driver.switchTo().alert(); 
		alert.accept();
		

	}

}
