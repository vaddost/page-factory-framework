package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasePage {
    private final WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void waitUntilPageIsLoaded(long timeout){
        new WebDriverWait(driver, timeout).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState")
                        .equals("complete"));
    }

    public void waitUntilElementIsClickable(WebElement element, long timeout){
        new WebDriverWait(driver, timeout). until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitUntilElementIsVisible(WebElement element, long timeout){
        new WebDriverWait(driver, timeout). until(ExpectedConditions.visibilityOf(element));
    }

    public void waitUntilAllElementsAreVisible(List<WebElement> elements, long timeout){
        new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    public void waitUntilGridIsRefreshed(List<WebElement> elements, long timeout){
        new WebDriverWait(driver, timeout).until(ExpectedConditions.refreshed(
                ExpectedConditions.visibilityOfAllElements(elements)));
    }

    public void refreshPage(){
        driver.navigate().refresh();
        waitUntilPageIsLoaded(30);
    }
    public JavascriptExecutor getJavaScriptExecutor(){
        return (JavascriptExecutor) driver;
    }
}
