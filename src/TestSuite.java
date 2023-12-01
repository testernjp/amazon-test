import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

public class TestSuite extends Utility {
    //1.1 open URL
    String baseURl = "https://www.amazon.co.uk/";

    @Before
    public void setUp() {
        openBrowser(baseURl);
    }

    @Test
    public void searchAndPrintProductName() throws InterruptedException {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //1.2 Type "Dell Laptop" in the search box and press enter or click on Search Box
        Thread.sleep(7000);
        clickOnElement(By.id("sp-cc-accept"));

        mouseHoverAndClick(By.xpath("//input[@id='twotabsearchtextbox']"));
        sendTextToElement(By.id("twotabsearchtextbox"), "Dell Laptop");
        //driver.findElement(By.id("twotabsearchtextbox")).sendKeys(Keys.ENTER);
        clickOnElement(By.xpath("//input[@value='Go']"));

        //1.3 Click on the checkbox brand Dell on the left side.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Thread.sleep(2000);
        clickOnElement(By.xpath("//li[@aria-label='Dell']//i[@class='a-icon a-icon-checkbox']"));

        // 1.4 Verify that the  30(Maybe different) products are displayed on the page.

        List<WebElement> productCount = driver.findElements(By.className("sg-col-inner"));
        System.out.println("total number of items:" + productCount.size());

        //1.5 . Print all product names in the console.
        List<WebElement> linksElements = driver.findElements(By.className("sg-col-inner"));
        System.out.println("Total number of links : " + linksElements.size());
        for (WebElement link : linksElements) {
            System.out.println("The links: " + link.getText());
            System.out.println("The value of attributes : " + link.getAttribute("class"));
        }


        //1.6 Click on the product name 'Dell XPS 15 9530 15.6" OLED 3.5K 400-Nit Touchscreen Laptop, 13th Gen Intel EVO i7-13700H Processor, 16GB RAM, 1TB SSD, NV...
        //Dell XPS 15 9530 15.6" OLED 3.5K 400-Nit Touchscreen Laptop, 13th Gen Intel EVO i7-13700H Processor, 16GB RAM, 1TB SSD, NVIDIA RTX 4060, Windows 11, Silver'
        clickOnElement(By.xpath("//div[@class='s-widget-container s-spacing-small s-widget-container-height-small celwidget slot=MAIN template=SEARCH_RESULTS widgetId=search-results_24']//span[@class='a-price-whole']"));


        //1.7 Verify the Product name 'Dell XPS 15 9530 15.6" OLED 3.5K 400-Nit Touchscreen Laptop, 13th Gen Intel EVO i7-13700H Processor, 16GB RAM, 1TB SSD, NV...
        // Dell XPS 15 9530 15.6" OLED 3.5K 400-Nit Touchscreen Laptop, 13th Gen Intel EVO i7-13700H Processor, 16GB RAM, 1TB SSD, NVIDIA RTX 4060, Windows 11, Silver'

        getTextFromElement(By.id("productTitle"));

    }


    @After
    public void tearDown() {
        //closeBrowser();
    }
}
