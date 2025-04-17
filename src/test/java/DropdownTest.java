import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class DropdownTest {

    @Test
    public void dropdownTest() {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        Select select = new Select(dropdown);
        List<WebElement> options = select.getOptions();
        Assert.assertEquals(options.size(), 3, "Должно быть 3 опции");
        select.selectByIndex(1);
        Assert.assertEquals(select.getFirstSelectedOption().getText(), "Option 1", "Не та опция");
        select.selectByIndex(2);
        Assert.assertEquals(select.getFirstSelectedOption().getText(), "Option 2", "Не та опция");
        driver.quit();
    }
}
