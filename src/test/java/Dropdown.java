import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Dropdown {

public static void main (String[] args) {
    System.setProperty("webdriver.chrome.driver", "C:\\Users\\Gopi Jayabalan\\Downloads\\chromedriver.exe");

    WebDriver driver = new ChromeDriver();

    driver.manage().window().maximize();

    driver.get("https://www.spicejet.com/");

    driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();

    driver.findElement(By.xpath("//a[@value='MAA']")).click();

    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    driver.findElement(By.xpath("(//a[@value='BLR'])[2]")).click();


    String month= "November 2019";

    while(true)
    {

        String text = driver.findElement(By.xpath("//div[@class='ui-datepicker-header ui-widget-header ui-helper-clearfix ui-corner-left']//div[@class='ui-datepicker-title']")).getText();
      //  System.out.println(text);x

        if(text.equals(month))
        {
            break;
        }

        else
        {
            driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();

        }
    }

        List<WebElement> dates=driver.findElements(By.className("ui-state-default"));

        int count= driver.findElements(By.className("ui-state-default")).size();

        for(int i=0;i<count;i++)
        {
            String text = driver.findElements(By.className("ui-state-default")).get(i).getText();
            if(text.equalsIgnoreCase("29"))
            {
                driver.findElements(By.className("ui-state-default")).get(i).click();
                break;


            }
        }

    File Src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

    try {
        FileUtils.copyFile(Src,new File("F:\\Login.jpeg"));
    } catch (IOException e) {
        e.printStackTrace();
    }

    driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();


        }


    }


