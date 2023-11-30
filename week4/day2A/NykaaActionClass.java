package week4.day2A;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class NykaaActionClass {

	public static void main(String[] args) throws InterruptedException {


		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.nykaa.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));	
		WebElement brandsElements = driver.findElement(By.xpath("//a[text() ='brands']"));
		
		Actions actions = new Actions(driver);
		actions.moveToElement(brandsElements).perform();
		Thread.sleep(5000);
		driver.findElement(By.id("brandSearchBox")).sendKeys("L'Oréal Paris");
		driver.findElement(By.xpath("//li[@class ='brand-logo menu-links'][5]")).click();
		driver.findElement(By.xpath("//button[@class=' css-1aucgde']")).click();
		driver.findElement(By.xpath("//span[text() ='customer top rated']")).click();
		driver.findElement(By.xpath("//span[text() = 'Category']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text() = 'Hair']")).click();
		driver.findElement(By.xpath("//span[text() = 'Hair Care']")).click();
		driver.findElement(By.xpath("//span[text() = 'Shampoo']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text() = 'Concern']")).click();
		driver.findElement(By.xpath("//span[text()='Colour Protection']")).click();
		
		WebElement filterValue = driver.findElement(By.xpath("//span[@class='filter-value']")); 
		String text = filterValue.getText(); System.out.println(text); 
		if(text.contains("Shampoo")) {
			System.out.println("applied Shampoo");
		 
		 }
		driver.findElement(By.xpath("//img[@alt=\"L'Oreal Paris Colour Protect Shampoo With UVA & UVB For Colour-Treated Hair\"]")).click();
		String parentWindow = driver.getWindowHandle();
		Set<String> allWindowHandles = driver.getWindowHandles(); 
		for (String s : allWindowHandles) 
		{
			driver.switchTo().window(s);
		}
		
		driver.findElement(By.xpath("//span[text() ='180ml']")).click();
		WebElement mrpPrice = driver.findElement(By.xpath("//div[@class='css-1d0jf8e']"));
		String text2 = mrpPrice.getText();
		System.out.println("Print MRP : " + text2);
		
		driver.findElement(By.xpath("//button[@class=' css-13zjqg6']")).click();
		driver.findElement(By.xpath("//button[@class='css-aesrxy']")).click();
		
		driver.switchTo().frame(0);
		WebElement grandTotal = driver.findElement(By.xpath("//div[@id='app']/div/div/div[3]/div/div/div/div[1]/div/div[1]/span"));
		String total = grandTotal.getText();
		System.out.println("The Grand Total is " + total);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Proceed']")).click();
		driver.findElement(By.xpath("//button[text()='Continue as guest']")).click();
		driver.findElement(By.xpath("//div[@data-testid='back_button']")).click();
		WebElement details = driver.findElement(By.xpath("//div[@id='app']/div/div/div/div/div[2]/div[2]/div[2]/div/div/div[2]/div/div[1]/div/p"));
		String price = details.getText();
		System.out.println("The price is " + price);
		if(total.equals(price))
		{
			System.out.println("The amounts are matching");
		}
		driver.close();
		driver.switchTo().window(parentWindow);
		driver.close();
		

	}

}
