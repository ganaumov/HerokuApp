import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class AddElementsTest {

    @Test
    public void addElementTest() {
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        webDriver.manage().window().maximize();
        webDriver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        webDriver.findElement(By.xpath("//button[text()='Add Element']")).click();
        webDriver.findElement(By.xpath("//button[text()='Add Element']")).click();
        List<WebElement> delete = webDriver.findElements(By.xpath("//button[text()='Delete']"));
        Assert.assertEquals(delete.size(), 2);
        webDriver.findElement(By.xpath("//button[text()='Delete']")).click();
        List<WebElement> delete1 = webDriver.findElements(By.xpath("//button[text()='Delete']"));
        Assert.assertEquals(delete.size(), 1);
        webDriver.quit();
    }
}