package week4.day2A;

import java.time.Duration;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandling {

	public static void main(String[] args) throws InterruptedException {
		//launch the browser
				ChromeDriver driver = new ChromeDriver();
				driver.get("http://leaftaps.com/opentaps/");
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

				driver.findElement(By.className("inputLogin")).sendKeys("DemoCSR");
				Thread.sleep(2000);
				driver.findElement(By.name("PASSWORD")).sendKeys("crmsfa");
				driver.findElement(By.className("decorativeSubmit")).click();
				driver.findElement(By.linkText("CRM/SFA")).click();
				driver.findElement(By.xpath("//a[text() = 'Contacts']")).click();
				driver.findElement(By.xpath("//a[text() ='Merge Contacts']")).click();
				
				driver.findElement(By.xpath("//input[@id='partyIdFrom']/following::img")).click();
				System.out.println(driver);
				String parentWindow = driver.getWindowHandle();
				System.out.println("current window address : "+parentWindow);
				
				Set<String> windowHandleSet = driver.getWindowHandles();
				
				List<String> setIntoList = new LinkedList<String>(windowHandleSet);
				
				for (String windowAdd : setIntoList) {
					driver.switchTo().window(windowAdd);
					
					System.out.println(driver.getTitle());
				}
				
				driver.findElement(By.xpath("//table[@class='x-grid3-row-table']//td//a")).click();
				driver.switchTo().window(parentWindow);
				driver.findElement(By.xpath("//input[@id='partyIdTo']/following::img")).click();
				Thread.sleep(3000);
				
				Set<String> toContact = driver.getWindowHandles();
				
				List<String> toContactList = new LinkedList<String>(toContact);
				
				for (String windowAdd : toContactList) {
					driver.switchTo().window(windowAdd);
					
					System.out.println(driver.getTitle());
				}
				driver.findElement(By.xpath("//table[@class='x-grid3-row-table']//td//a")).click();
				driver.switchTo().window(parentWindow);
				driver.findElement(By.linkText("Merge")).click();
				Alert alert = driver.switchTo().alert();
				alert.accept();
				String title = driver.getTitle();
				System.out.println(title);

	}

}
