package seleniumWebdriver;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GetHelpPage {
  WebDriver driver;
  @FindBy(xpath = "//a[@role='button' and @class='wscrOk']")
  WebElement cookiesAcceptAllButton;
  @FindBy(xpath = "//section[@class='content-card card card--margin-bottom']/h2[@class='medium-h4']")
  WebElement latestNewsHeader;
  @FindBy(xpath = "//span[@class='fakeArticle']//a[@data-wtparams='DCSext.rtfID=Article_New features in Nordea Netbank and Nordea Mobile']")
  WebElement link1LatestNews;
  @FindBy(xpath = "//span[@class='fakeArticle']//a[@data-wtparams='DCSext.rtfID=Article_Payment blocks for gambling services will enter into force at the beginning of 2023']")
  WebElement link2LatestNews;
  @FindBy(xpath = "//span[@class='fakeArticle']/ul/li//a")
  List<WebElement> linksLatestNews;
  final public static String WebUrl = "https://www.nordea.fi/en/personal/get-help/";
  final public static String LINK1_TEXT = "New features in Nordea Netbank and Nordea Mobile";
  final public static String LINK2_PAGE_TITLE = "News update | Nordea";

  public String getWebUrl(){
    return WebUrl;
  }

  public GetHelpPage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }
  public void cookiesAcceptAll() {
    cookiesAcceptAllButton.click();
  }
  public String getlatestNewsHeader() {
    return latestNewsHeader.getText();
  }
  public List<WebElement> getlinksLatestNews() {
    List<WebElement> linksList = linksLatestNews;
    return linksList;
  }
  public void clikLink2LatestNews() {
    link2LatestNews.click();
  }
  public String getHreflink2LatestNews() {
    return link2LatestNews.getAttribute("href");
  }
  public String getTextlink1LatestNews() {
    return link1LatestNews.getText();
  }

}
