import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class Utility extends BaseTest {

    /**
     * This method will click on element
     */
    public void clickOnElement(By by) {

        driver.findElement(by).click();
    }

    public void mouseHoverAndClick(By by) {
        Actions actions = new Actions(driver);
        WebElement mouseHover = driver.findElement(by);
        actions.moveToElement(mouseHover).click().build().perform();
    }

    /**
     * This method will send text to element
     */
    public void sendTextToElement(By by, String text) {


        driver.findElement(by).sendKeys(text);
    }

    public void verifyElements(By by) {
        List<WebElement> elementList = driver.findElements(by);
        for (WebElement e : elementList) {
            if (e.getText().equalsIgnoreCase("")) ;
            e.click();
        }
    }

    public void verifyText(By by, String expectedText) {
        String actualText = getTextFromElement(by);
        Assert.assertEquals("Error", expectedText, actualText);
    }
    public String getTextFromElement(By by) {
        return driver.findElement(by).getText();
    }
}