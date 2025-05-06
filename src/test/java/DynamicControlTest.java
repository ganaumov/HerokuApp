package tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class DynamicControlTest {

    @Test
    public void ContextMenu() {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/context_menu");
        WebElement element = driver.findElement(By.id("hot-spot"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).contextClick().perform();
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String text = alert.getText();
        Assert.assertEquals(text,
                "You selected a context menu",
                "Текст не найден");
        alert.accept();
        driver.quit();
    }

    @Test
    public void DynamicControls() {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        driver.findElement(By.xpath("//*[text()='Remove']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("checkbox")));
        driver.findElement(By.cssSelector("input[type='text'][disabled]"));
        WebElement input = driver.findElement(By.cssSelector("input[type='text'][disabled]"));
        boolean disabled = !input.isEnabled();
        driver.findElement(By.xpath("//button[text()='Enable']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='message']")));
        String message = driver.findElement(By.xpath("//*[@id='message']")).getText();
        Assert.assertEquals(message,
                "It's enabled!",
                "Input не включился");
        driver.quit();
    }

    @Test
    public void FileUpload() {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/upload");
        WebElement upload = driver.findElement(By.id("file-upload"));
        Actions actions = new Actions(driver);
        driver.findElement(By.id("file-upload")).
                sendKeys("C:\\Users\\user\\IdeaProjects\\SauceDemo\\A915940.docx");
        driver.findElement(By.id("file-submit")).click();
        String message1 = driver.findElement(By.xpath("//*[@id='uploaded-files']")).getText();
        Assert.assertEquals(message1,
                "A915940.docx",
                "Загружен неверный файл!");
        driver.quit();
    }

    @Test
    public void iFrameTest(){
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/iframe");
        // Не получается закрыть окно уведомление.
    }
}