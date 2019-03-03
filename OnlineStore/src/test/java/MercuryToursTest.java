package test.java;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class MercuryToursTest {
    WebDriver driver;

    @BeforeTest
    public void main() {
    	//if you didn't update the Path system variable to add the full directory path to the executable as above mentioned then doing this directly through code
    	System.setProperty("webdriver.gecko.driver", "C:\\Users\\rahul\\Downloads\\geckodriver-v0.24.0-win64\\geckodriver.exe");

    	FirefoxOptions options = new FirefoxOptions();
    	options.setCapability("marionette", true);
    	driver = new FirefoxDriver(options);
    	
    	// TODO Auto-generated method stub
        System.out.println("Driver is running");
        System.out.println(driver.toString());
        System.out.println("Driver is running");
        driver.manage().window().maximize();
    }

    @org.testng.annotations.Test
    public void open() throws InterruptedException{
        String url,homePage = "http://newtours.demoaut.com";
        HttpURLConnection huc;
		int respCode;
    	driver.get(homePage);
        Thread.sleep(10000);
        //Register User
        driver.findElement(By.linkText("REGISTER")).click();
        driver.findElement(By.name("firstName")).sendKeys("Test");
        driver.findElement(By.name("lastName")).sendKeys("User1");
        driver.findElement(By.name("phone")).sendKeys("9999999999");
        driver.findElement(By.name("userName")).sendKeys("User1");
        driver.findElement(By.name("address1")).sendKeys("Dummy Address");
        driver.findElement(By.name("city")).sendKeys("Dummy City");
        driver.findElement(By.name("state")).sendKeys("Dummy State");
        driver.findElement(By.name("postalCode")).sendKeys("45454");
        driver.findElement(By.name("email")).sendKeys("dummy@yahoo.com");
        driver.findElement(By.name("password")).sendKeys("password123");
        driver.findElement(By.name("confirmPassword")).sendKeys("password123");
        driver.findElement(By.name("register")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[2]/a"));
        Thread.sleep(5000);
        //Book Flights
        driver.findElement(By.linkText("Flights")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[2]/td[2]/b/font/input[2]")).click();
        driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[3]/td[2]/b/select/option[4]")).click();
        driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[6]/td[2]/select/option[5]")).click();
        driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[7]/td[2]/select[2]/option[4]")).click();
        driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[9]/td[2]/font/font/input[1]")).click();
        driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[10]/td[2]/select/option[3]")).click();
        driver.findElement(By.name("findFlights")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[1]/tbody/tr[7]/td[1]/input")).click();
        driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[2]/tbody/tr[5]/td[1]/input")).click();
        driver.findElement(By.name("reserveFlights")).click();
        Thread.sleep(5000);
        driver.findElement(By.name("passFirst0")).sendKeys("Dummy");
        driver.findElement(By.name("passLast0")).sendKeys("User");
        driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[4]/td/table/tbody/tr[2]/td[3]/select/option[6]")).click();
        driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[9]/td/table/tbody/tr[2]/td[1]/select/option[3]")).click();
        driver.findElement(By.name("creditnumber")).click();
        driver.findElement(By.name("buyFlights")).click();
        //Book Cruises
        driver.findElement(By.linkText("Cruises")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr[1]/td/p[3]/a/img")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[2]/td[2]/b/font/input[2]")).click();
        driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[3]/td[2]/b/select/option[4]")).click();
        driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[6]/td[2]/select/option[5]")).click();
        driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[7]/td[2]/select[2]/option[4]")).click();
        driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[9]/td[2]/font/font/input[1]")).click();
        driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[10]/td[2]/select/option[3]")).click();
        driver.findElement(By.name("findFlights")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[1]/tbody/tr[7]/td[1]/input")).click();
        driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[2]/tbody/tr[5]/td[1]/input")).click();
        driver.findElement(By.name("reserveFlights")).click();
        Thread.sleep(5000);
        driver.findElement(By.name("passFirst0")).sendKeys("Dummy");
        driver.findElement(By.name("passLast0")).sendKeys("User");
        driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[4]/td/table/tbody/tr[2]/td[3]/select/option[6]")).click();
        driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[9]/td/table/tbody/tr[2]/td[1]/select/option[3]")).click();
        driver.findElement(By.name("creditnumber")).click();
        driver.findElement(By.name("buyFlights")).click();
        
        //Find Broken Links
        List<WebElement> links = driver.findElements(By.tagName("a"));
        Iterator<WebElement> it = links.iterator();
        
        while(it.hasNext()){
            
            url = it.next().getAttribute("href");
            
            System.out.println(url);
        
            if(url == null || url.isEmpty()){
            	System.out.println("URL is either not configured for anchor tag or it is empty");
                continue;
            }
            
            if(!url.startsWith(homePage)){
                System.out.println("URL belongs to another domain, skipping it.");
                continue;
            }
            
            try {
                huc = (HttpURLConnection)(new URL(url).openConnection());
                
                huc.setRequestMethod("HEAD");
                
                huc.connect();
                
                respCode = huc.getResponseCode();
                
                if(respCode >= 400){
                    System.out.println(url+" is a broken link");
                }
                else{
                    System.out.println(url+" is a valid link");
                }
                    
            } catch (MalformedURLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
           }

    }
        
    @AfterTest
    public void close() throws InterruptedException{
    	//driver.close();
    }
}