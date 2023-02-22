package Assignment;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.logging.FileHandler;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Amazon {


	public static void main(String[] args) {
		ChromeDriver driver=new ChromeDriver();
	       driver.get("https://www.amazon.in/");
	       driver.manage().window().maximize();
	       driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro ",Keys.ENTER);
	       //String price = driver.findElement(By.xpath("//span[@class='a-price-whole'][1]")).getText().replaceAll("[^\\d]","");
	       //int mobilePrice=Integer.parseInt(price);
	       //System.out.println("The first product price is: "+price);
	       //WebElement rating = driver.findElement(By.xpath("//i[@class='a-icon a-icon-star-small a-star-small-3 aok-align-bottom'][1]"));
	       //System.out.println("The first product ratings is"+rating);
           WebElement mobileprice = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]"));
           String price = mobileprice.getText().replaceAll("[^0-9]", "");
           System.out.println(price);
           WebElement rating= driver.findElement(By.xpath("(//div[@class='a-section a-spacing-none a-spacing-top-micro'])[1]"));
           String ratingtext = rating.getText();
           System.out.println(ratingtext);
           driver.findElement(By.xpath("(//img[@class='s-image'])[1]")).click();
           Set<String> handles = driver.getWindowHandles();
           List<String> hand =new ArrayList<String>(handles);
           driver.switchTo().window(hand.get(1));
           File screenshotAs = driver.getScreenshotAs(OutputType.FILE);
           File snap =new File("./snap/img.png");
           FileHandler.copy(screenshotAs, snap);
           driver.findElement(By.id("add-to-cart-button")).click();
           String text = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]")).getText();
           String price1 = text.replaceAll("[^0-9]", "");
           if(price.equals(price1))
           {
        	   System.out.println("correct price");
           }
          else
          {
        	   System.out.println("not correct price");
          }
	}

}
