import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Typos {

    @Test
    public void typoCheckTest() {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/typos");
        List<WebElement> paragraphs = driver.findElements(By.tagName("p"));
        for (WebElement paragraph : paragraphs) {
            String text = paragraph.getText();
            Assert.assertFalse(text.contains("won,t"), "Обнаружена ошибка: запятая вместо апострофа");
            Assert.assertFalse(text.contains("  "), "Обнаружены лишние пробелы");
            Assert.assertFalse(text.contains(", "), "Обнаружена лишняя запятая");
        }
        driver.quit();
    }
}
