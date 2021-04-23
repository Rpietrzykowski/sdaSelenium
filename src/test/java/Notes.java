import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Notes {

    public WebDriver driver;

    public String websiteURL = "http://automationpractice.com/index.php";

    @Before
    public void setupTest() {
        String chromeKey = "webdriver.chrome.driver";
        String chromePath = "/Users/rpietrzykowski/IdeaProjects/sdaSelenium/src/drivers/chromedriver";
        System.setProperty(chromeKey, chromePath);

        driver = new ChromeDriver();

        driver.get(websiteURL);
    }

    @Test
    public void getWebsiteTitle() {
        String title = driver.getTitle();

        driver.findElement(By.id("newsletter_block_left"));

        driver.findElement(By.linkText("<TEKST ELEMENTU>"));

        driver.findElement(By.partialLinkText("<CZĘŚCIOWY TEKST ELEMENTU>"));

        driver.findElement(By.xpath("<XPATH>"));

        driver.findElement(By.cssSelector("<cssSelektor>"));

        System.out.println("Page Title: " + title);

        Assert.assertEquals(title, "Google");

        WebElement myElem = driver.findElement(By.id("NAZWA ELEMENTU"));
        Actions builder = new Actions(driver);
        Action mouseOverHome = builder
                .moveToElement(myElem)
                .build();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        // Launch the application
        driver.get("http://demo.guru99.com/test/guru99home/");

        //This will scroll the web page till end.
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");


        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        WebDriver driver = new ChromeDriver(); //navigates to the Browser
        driver.get("http://demo.guru99.com/test/guru99home/");
        // navigates to the page consisting an iframe

        driver.manage().window().maximize();
        driver.switchTo().frame("a077aa5e"); //switching the frame by ID

        System.out.println("********We are switch to the iframe*******");
        driver.findElement(By.xpath("html/body/a/img")).click();
        //Clicks the iframe

        System.out.println("*********We are done***************");

        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("login")));

        Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);


        String bananaString = driver.findElement(By.cssSelector("#fruits > option:nth-child(1)")).getText();


    }

    @Test
    public void checkIfNewsletterBarExists () {
        WebElement newsletterBar = driver.findElement(By.id("newsletter_block_left"));
        Assert.assertTrue(newsletterBar.isDisplayed());
    }

    @After
    public void cleanUp() {
        driver.quit();
    }
}
