package seleniumWebdriver;

import static seleniumWebdriver.GetHelpPage.*;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HelpPageTest {
    GetHelpPage objGetHelpPage;
    WebDriver driver;

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:/Webdrivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to(WebUrl);
    }

    @Test
    public void runTest1() {
        objGetHelpPage = new GetHelpPage(driver);
        objGetHelpPage.cookiesAcceptAll();
        System.out.println("Card header: " + objGetHelpPage.getlatestNewsHeader());
        List<WebElement> links = objGetHelpPage.getlinksLatestNews();
        System.out.println("Count of card links: " + links.size());
        System.out.println("Link nr 2 href: " + objGetHelpPage.getHreflink2LatestNews());
        Assert.assertTrue(objGetHelpPage.link2LatestNews.isEnabled());
        Assert.assertEquals(LINK1_TEXT, objGetHelpPage.getTextlink1LatestNews());

        //redirect to link2 Latest news card
        objGetHelpPage.clikLink2LatestNews();
        Assert.assertEquals(LINK2_PAGE_TITLE, driver.getTitle());
        driver.quit();
    }

}
