package DataDrivenTesting0307;
import excel.Xls_Reader;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import java.time.Duration;
public class DatadrivenTesting {
    @Test
    public void DDTest() {
        Xls_Reader reader = new Xls_Reader("D:\\Trainings\\GitHub projects\\DataDrivenTesting2025\\src\\test\\java\\TestData\\Data.xlsx");
        String url = reader.getCellData("Testdata", "URL", 2);
        String productname = reader.getCellData("Testdata", "ProductName", 2);
        System.out.println(url + " " + productname);
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.findElement(By.xpath("//*[@id=\"gnav20-search-icon\"]")).click();
        driver.findElement(By.id("search_box_gnav_input")).sendKeys(productname);
        driver.findElement(By.id("search_box_gnav_input")).sendKeys(Keys.ENTER);

    }
}
