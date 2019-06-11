import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class Alert {

    public static void main (String[] args) throws IOException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Gopi Jayabalan\\Downloads\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("http://demo.guru99.com/test/delete_customer.php");

        driver.manage().window().maximize();

        driver.findElement(By.name("cusid")).click();

        driver.findElement(By.name("cusid")).sendKeys("Gopi123");

        File Src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(Src,new File("F:\\Loginpage1.jpeg"));

        driver.findElement(By.name("submit")).click();

        String alertMessage= driver.switchTo().alert().getText();

        System.out.println(alertMessage);

        driver.switchTo().alert().accept();
    }
}
