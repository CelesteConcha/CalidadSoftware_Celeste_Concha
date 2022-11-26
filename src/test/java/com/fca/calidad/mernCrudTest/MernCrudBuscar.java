package com.fca.calidad.mernCrudTest;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.apache.commons.io.FileUtils;
import java.io.File;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MernCrudBuscar {
	private WebDriver driver;
	  private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();
	  JavascriptExecutor js;

	  @Before
	  public void setUp() throws Exception {
	   // System.setProperty("webdriver.chrome.driver", "");
		  WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
	    baseUrl = "https://www.google.com/";
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	    js = (JavascriptExecutor) driver;
	  }
	  
	  @Test
	  public void testBuscar() throws Exception {
	    driver.get("https://mern-crud.herokuapp.com/");
	    driver.findElement(By.xpath("//div[@id='root']/div/div[2]/button")).click();
	    driver.findElement(By.name("name")).click();
	    driver.findElement(By.name("name")).clear();
	    driver.findElement(By.name("name")).sendKeys("Prueba12345");
	    driver.findElement(By.name("email")).click();
	    driver.findElement(By.name("email")).clear();
	    driver.findElement(By.name("email")).sendKeys("prueba12345@net.com");
	    driver.findElement(By.name("age")).click();
	    driver.findElement(By.name("age")).clear();
	    driver.findElement(By.name("age")).sendKeys("24");
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Gender'])[2]/following::div[2]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Male'])[2]/following::div[1]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Woah!'])[1]/following::button[1]")).click();
	    pause(5000);
	assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*prueba12345@net.com[\\s\\S]*$")); 
	    driver.findElement(By.xpath("//i")).click(); 
	    System.out.println("El usuario se encontró");
	     
	
	   
	  }
	  
	  @After
	  public void tearDown() throws Exception {
	    driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	  }

	  private boolean isElementPresent(By by) {
	    try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }

	  private boolean isAlertPresent() {
	    try {
	      driver.switchTo().alert();
	      return true;
	    } catch (NoAlertPresentException e) {
	      return false;
	    }
	  }

	  private String closeAlertAndGetItsText() {
	    try {
	      Alert alert = driver.switchTo().alert();
	      String alertText = alert.getText();
	      if (acceptNextAlert) {
	        alert.accept();
	      } else {
	        alert.dismiss();
	      }
	      return alertText;
	    } finally {
	      acceptNextAlert = true;
	    }
	  }



	private void pause(long mils) {
		  try {
			  Thread.sleep(mils);
		  } catch(Exception e){
			  e.printStackTrace();
		  }
	}
}

	

	
