package com.fca.calidad.GoogleTest;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.time.Duration;

public class GoogleTest {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  JavascriptExecutor js;
  
  @Before
  public void setUp() throws Exception {
  //  System.setProperty("webdriver.chrome.driver", "");
	  WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    baseUrl = "https://www.google.com/";
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
    js = (JavascriptExecutor) driver;
  }

  @Test
  public void testGoogleTitulo() throws Exception {
    driver.get("https://www.google.com/search?q=yucatan+i6+&ei=Wf97Y5uFO6qdwbkP6qmXyAI&ved=0ahUKEwjblerorMD7AhWqTjABHerUBSkQ4dUDCBA&uact=5&oq=yucatan+i6+&gs_lcp=Cgxnd3Mtd2l6LXNlcnAQAzIFCAAQgAQyBQgAEIAEMgUIABCABDIFCAAQgAQ6BAgAEEdKBAhBGABKBAhGGABQqBBYqBBglypoAHADeACAAaYHiAGmB5IBAzYtMZgBAKABAcgBCMABAQ&sclient=gws-wiz-serp");
    driver.findElement(By.xpath("//div[@id='rso']/div/div/div/div/div/div/div/div/a/h3")).click();
    driver.get("https://siies.yucatan.gob.mx/yucatani6/");
    assertEquals("Yucatáni6", driver.getTitle());
    System.out.println("¡¡¡El titulo es Yucatáni6!!!");
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
}
