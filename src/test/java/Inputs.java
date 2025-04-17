import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Inputs {

    @Test
    public void numberInputTest() {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/inputs");
        WebElement inputField = driver.findElement(By.tagName("input"));
        inputField.sendKeys("123");
        Assert.assertEquals(inputField.getAttribute("value"), "123", "Неверное значение");
        inputField.clear();
        inputField.sendKeys("abc");
        Assert.assertEquals(inputField.getAttribute("value"), "", "Нечисловое значение должно быть отклонено");
        inputField.clear();
        inputField.sendKeys("10");
        inputField.sendKeys(Keys.ARROW_UP);
        Assert.assertEquals(inputField.getAttribute("value"), "11", "Стрелка вверх не работает");
        inputField.sendKeys(Keys.ARROW_DOWN);
        Assert.assertEquals(inputField.getAttribute("value"), "10", "Стрелка вниз не работает");
        driver.quit();
    }
}
