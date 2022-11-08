import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

@TestInstance(Lifecycle.PER_CLASS)
public class NewPageTest {

  WebDriver webdriver;

  @BeforeAll
  public void setupAll(){
    System.setProperty("webdriver.chrome.driver",
        "src/test/resources/chromedriver_linux64/chromedriver.exe");
  }

  @BeforeEach
  public void setup(){
    webdriver = new ChromeDriver();
    webdriver.manage().window().maximize();
  }

  @AfterEach
  public void closeDriver(){
    webdriver.close();
  }

  @Test
  public void openNewPage(){
    webdriver.get("https://www.google.com/");
    Assertions.assertEquals("https://www.google.com/",
        webdriver.getCurrentUrl());
  }

  @Test
  public void openFacebookPage(){
    webdriver.get("https://fescfafic.edu.br/");
    WebElement botao = webdriver.findElement(
        By.xpath("//*[@id=\"wrap\"]/div/div/section[1]/div/div/div[2]/div/div/div[2]/div/div/span[1]/a/i"));
    botao.click();
  }

  @Test
  public void openPaginaFantastico (){
    webdriver.get("https://globo.com");

    WebElement search = webdriver.findElement(By.id("header-search-input"));

    search.sendKeys("fantastico");
    search.submit();
  }

  @Test
  public void abrirPaginaTest (){
    webdriver.get("https://globo.com");
    Actions actions = new Actions(webdriver);
    WebElement botao = webdriver.findElement(
        By.xpath("//*[@id=\"header-section\"]/div[1]/div[4]/div[2]/a[4]"));
    actions.moveToElement(botao).perform();
  }



}
