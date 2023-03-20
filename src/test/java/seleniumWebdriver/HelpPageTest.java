package seleniumWebdriver;

import static java.lang.Boolean.TRUE;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


@TestMethodOrder(OrderAnnotation.class)
public class HelpPageTest {
    GetHelpPage objGetHelpPage;
    WebDriver driver;
    final static String LINK1_TEXT = "Banking details are for your personal use only";
    final static String LINK2_PAGE_TITLE = "News update | Nordea";

    @BeforeEach
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:/Webdrivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to(GetHelpPage.getWebUrl());
    }


    @Order(2)
    @RepeatedTest(1)
    //@Test
    public void runTest1() {
        objGetHelpPage = new GetHelpPage(driver);
        objGetHelpPage.cookiesAcceptAll();
        System.out.println("Card header: " + objGetHelpPage.getLatestNewsHeader());
        List<WebElement> links = objGetHelpPage.getLinksLatestNews();
        System.out.println("Count of card links: " + links.size());
        System.out.println("Link nr 2 href: " + objGetHelpPage.getHreflink2LatestNews());
        Assert.assertTrue(objGetHelpPage.link2LatestNewsIsEnabled());
        assumeTrue(TRUE);
        Assert.assertEquals(LINK1_TEXT, objGetHelpPage.getTextlink1LatestNews());
        System.out.println("Link nr 1 text: " + objGetHelpPage.getTextlink1LatestNews());

        //redirect to link2 Latest news card
        objGetHelpPage.clikLink2LatestNews();
        Assert.assertEquals(LINK2_PAGE_TITLE, driver.getTitle());
    }


    @Order(1)
    @ParameterizedTest
    @MethodSource("womanNames")
    public void parameterizedTest(String name) {
        System.out.println("Input test :" + name);
        Assert.assertTrue(name.contains("Ola"));
    }
    @AfterEach
    public void tearDown() {
        driver.quit();
    }


    private static Stream<String> womanNames(){

        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("Ala");
        arrayList.add("Ola");
        arrayList.add("Halina");


        arrayList.stream().filter(g -> g.contains("la")).filter(g->g.equals("Ola"))
                .forEach(System.out::println);
        return arrayList.stream().filter(g -> g.contains("la"));

    }

}
