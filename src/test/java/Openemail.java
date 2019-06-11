import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Openemail {

    public static void main (String[] args)
    {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Gopi Jayabalan\\Downloads\\chromedriver.exe" );
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://accounts.google.com/signin/v2/identifier?service=mail&passive=true&rm=false&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");

        driver.findElement(By.id("identifierId")).click();
        driver.findElement(By.id("identifierId")).sendKeys("gopisajana6@gmail.com");
        driver.findElement(By.cssSelector("#identifierNext > span")).click();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);


        driver.findElement(By.name("password")).sendKeys("govindasamy");
        driver.findElement(By.cssSelector("#passwordNext > span > span")).click();

        File Src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(Src,new File("F:\\GmailLogin.jpeg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<WebElement> emails=driver.findElements(By.xpath("//tr[@jscontroller='ZdOxDb']"));

        int count=driver.findElements(By.xpath("//tr[@jscontroller='ZdOxDb']")).size();

        for (int i=0; i<count ; i++)
        {
            String text=driver.findElements(By.xpath("//tr[@jscontroller='ZdOxDb']")).get(i).getText();
            if (i==2)
            {
                driver.findElements(By.xpath("//tr[@jscontroller='ZdOxDb']")).get(i).click();
                break;
            }

        }


    }
}
