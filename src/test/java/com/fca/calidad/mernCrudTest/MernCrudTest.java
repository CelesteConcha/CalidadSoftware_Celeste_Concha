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

public class MernCrudTest {
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
  public void testMernCrudCrear() throws Exception {
	  driver.get("https://mern-crud.herokuapp.com/");
    driver.findElement(By.xpath("//div[@id='root']/div/div[2]/button")).click();
    pause(3000);
    driver.findElement(By.name("name")).click();
    driver.findElement(By.name("name")).clear();
    driver.findElement(By.name("name")).sendKeys("prueba123");
    driver.findElement(By.name("email")).click();
    driver.findElement(By.name("email")).clear();
    driver.findElement(By.name("email")).sendKeys("prueba123@est.com");
    driver.findElement(By.name("age")).click();
    driver.findElement(By.name("age")).clear();
    driver.findElement(By.name("age")).sendKeys("23");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Gender'])[2]/following::div[1]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Male'])[2]/following::span[1]")).click();
    pause(3000);
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Woah!'])[1]/following::button[1]")).click();
    driver.findElement(By.xpath("//i")).click();
    String mensaje = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/form/div[4]/div/p")).getText();
   assertThat(mensaje,is("Successfully added!"));
    //driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Do Not Disclose'])[1]/following::div[1]")).click();
   assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*pruebaagregarPrueba123[\\s\\S]*$"));
   System.out.println("El usuario se agregó");
  }
  
  @Test
  public void testMernCrudEditar() throws Exception {
    driver.get("https://mern-crud.herokuapp.com/");
    driver.findElement(By.xpath("//div[@id='root']/div/div[2]/table/tbody/tr/td[5]/button")).click();
    driver.findElement(By.name("name")).click();
    driver.findElement(By.name("name")).clear();
    driver.findElement(By.name("name")).sendKeys("Prueba1234");
    driver.findElement(By.name("email")).click();
    driver.findElement(By.name("email")).click();
    driver.findElement(By.name("email")).click();
    driver.findElement(By.name("email")).clear();
    driver.findElement(By.name("email")).sendKeys("prueba1234@es.com");
    driver.findElement(By.name("age")).click();
    driver.findElement(By.name("age")).clear();
    driver.findElement(By.name("age")).sendKeys("26");
    pause(3000);
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Woah!'])[1]/following::button[1]")).click();
    pause(3000);
    driver.findElement(By.xpath("//i")).click();
    pause(3000);
    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*se cambió el usuario prueba123 a prueba1234[\\s\\S]*$"));
    System.out.println("El usuario se cambió exitosamente");
  }
  @Test
  public void testMernCrudEliminar() throws Exception {
    driver.get("https://mern-crud.herokuapp.com/");
    pause(3000);
    driver.findElement(By.xpath("//div[@id='root']/div/div[2]/table/tbody/tr/td[5]/button[2]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Prueba1234'])[2]/following::button[1]")).click();
    pause(3000);
    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*El usuario prueba1234 se eliminó correctamente[\\s\\S]*$"));
    System.out.println("El usuario prueba1234 se eliminó");
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

	

	
