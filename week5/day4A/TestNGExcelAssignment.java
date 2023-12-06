package week5.day4A;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGExcelAssignment extends ExcelProjectSpfMthd {

	@Test(dataProvider = "fetchData")
	public void automatedRegistration(String cname, String pass, String email, String phno) {
		
		driver.findElement(By.xpath("//button[@id = 'rh-registration-link']")).click();
		driver.findElement(By.id("truste-consent-button")).click();
		driver.findElement(By.id("username")).sendKeys(cname);
		driver.findElement(By.name("password")).sendKeys(pass);
		driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.id("user.attributes.phoneNumber")).sendKeys(phno);
		driver.findElement(By.xpath("//button[@id = 'regform-submit']")).click();
		
	}
	
	@BeforeTest
	public void setDat() {
		excelFileName = "redhat";
	}

}
