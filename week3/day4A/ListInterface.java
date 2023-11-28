package week3.day4A;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ListInterface {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.ajio.com/");
		driver.findElement(By.xpath("//input[@class='react-autosuggest__input react-autosuggest__input--open']")).sendKeys("bags");
		driver.findElement(By.xpath("//span[@class='ic-search']")).click();
		driver.findElement(By.xpath("//label[@class='facet-linkname facet-linkname-genderfilter facet-linkname-Men']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//label[@class ='facet-linkname facet-linkname-l1l3nestedcategory facet-linkname-Men - Fashion Bags']")).click();
		
		// find the list
		List<WebElement> countElement = driver.findElements(By.xpath("//div[@id = 'main-content']"));
		
		for (int i = 0; i < countElement.size(); i++) {
			WebElement webElement = countElement.get(i);
			System.out.println(webElement.getText());
		}
		
		// find the list of Brand
		List<WebElement> listBrand = driver.findElements(By.xpath("//div[@class = 'brand']"));
		
		for (int i = 0; i < listBrand.size(); i++) {
			WebElement webElement = listBrand.get(i);
			System.out.println(webElement.getText());
		}
		
		// find the list of price
		List<WebElement> listPrice = driver.findElements(By.xpath("//span[@class = 'price  ']"));
		
		for (int i = 0; i < listPrice.size(); i++) {
			WebElement webElement = listPrice.get(i);
			System.out.println(webElement.getText());
		}
		
		

	}

}
