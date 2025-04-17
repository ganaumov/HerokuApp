import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class CheckBoxes {

    @Test
    public void checkbox() {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        List<WebElement> checkboxes = driver.findElements(By.cssSelector("input[type='checkbox']"));
        Assert.assertFalse(checkboxes.get(0).isSelected(), "Ошибка! чекбокс 1 должен быть не отмечен");
        checkboxes.get(0).click();
        Assert.assertTrue(checkboxes.get(0).isSelected(), "Ошибка! чекбокс 1 должен быть не отмече");
        Assert.assertTrue(checkboxes.get(1).isSelected(), "Ошибка! чекбокс 2 должен быть не отмече");
        checkboxes.get(1).click();
        Assert.assertFalse(checkboxes.get(1).isSelected(), "Ошибка! чекбокс 2 должен быть не отмечен");
        driver.quit();
    }
}
