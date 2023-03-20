package seleniumWebdriver;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GetHelpPage {
  private WebDriver driver;

  //@FindBy(xpath = "//a[@role='button' and @class='wscrOk']")
  @FindBy(css = "a[role='button'][class='wscrOk']")
  private WebElement cookiesAcceptAllButton;

  //@FindBy(xpath = "//section[@class='content-card card card--margin-bottom']/h2[@class='medium-h4']")
  @FindBy(css = "section[class='content-card card card--margin-bottom']>h2[class='medium-h4']")
  private WebElement latestNewsHeader;

  //@FindBy(xpath = "//span[@class='fakeArticle']//a[@data-wtparams='DCSext.rtfID=Article_New features in Nordea Netbank and Nordea Mobile']")
  @FindBy(css = "span[class='js-non-remove-links'] span[class='fakeArticle'] ul li:first-child a")
  private WebElement link1LatestNews;

  //@FindBy(xpath = "//span[@class='fakeArticle']//a[@data-wtparams='DCSext.rtfID=Article_Payment blocks for gambling services will enter into force at the beginning of 2023']")
  @FindBy(css = "span[class='js-non-remove-links'] span[class='fakeArticle'] ul li:nth-child(2) a")
  private WebElement link2LatestNews;

  //@FindBy(xpath = "//span[@class='fakeArticle']/ul/li//a")
  @FindBy(css = "span[class='js-non-remove-links'] span[class='fakeArticle'] ul a")
  private List<WebElement> linksLatestNews;
  private final static String WebUrl = "https://www.nordea.fi/en/personal/get-help/";

  public static String getWebUrl(){
    return WebUrl;
  }

  public GetHelpPage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }
  public void cookiesAcceptAll() {
    cookiesAcceptAllButton.click();
  }
  public String getLatestNewsHeader() {
    return latestNewsHeader.getText();
  }
  public List<WebElement> getLinksLatestNews() {
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
  public Boolean link2LatestNewsIsEnabled() {
    return link2LatestNews.isEnabled();
  }

}
