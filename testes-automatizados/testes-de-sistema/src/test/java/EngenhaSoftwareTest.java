import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class EngenhaSoftwareTest {
    WebDriver webDriver;

    @BeforeAll
    public void setupAll(){
        System.setProperty("webdriver.chrome.driver",
                "src/test/resources/chromedriver_linux64/chromedriver.exe");
    }

    @BeforeEach
    public void setup(){
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
    }

    @AfterEach
    public void close(){
        webDriver.close();
    }

    @Test
    public void openGitHubGabiPage(){
        webDriver.get("https://github.com/gabrielle-1");
        Assertions.assertEquals("https://github.com/gabrielle-1",
                webDriver.getCurrentUrl());
    }

    @Test
    public void findBotaoContribuitonsTest(){
        webDriver.get("https://github.com/gabrielle-1");
        WebElement botaoRepositories = webDriver.findElement(
                By.id("year-link-2021"));
        botaoRepositories.click();
        Assertions.assertEquals("https://github.com/gabrielle-1?tab=overview&from=2021-12-01&to=2021-12-31",
                webDriver.getCurrentUrl());
    }

    @Test
    public void searchToDoListTest(){
        webDriver.get("https://github.com/gabrielle-1");
        WebElement search = webDriver.findElement(By.xpath("/html/body/div[1]/header/div/div[2]/div/div/div[1]/div/div/form/label/input[1]"));
        search.sendKeys("to-do-list");
        search.submit();
        Assertions.assertTrue(webDriver.getCurrentUrl().contains("to-do-list"));
    }

    @Test
    public void tooltipTitleTest(){
        webDriver.get("https://github.com/gabrielle-1");
        Actions actions = new Actions(webDriver);

        WebElement botaoGe = webDriver.findElement(By.xpath("/html/body/div[4]/main/div[1]/div/div/div[2]/div/nav/a[5]"));
        actions.moveToElement(botaoGe).perform();
        Assertions.assertEquals("esporte", botaoGe.getAttribute("title"));
    }
}
