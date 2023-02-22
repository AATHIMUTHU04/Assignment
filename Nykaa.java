package Assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Nykaa {

	public static void main(String[] args) {
		ChromeDriver driver=new ChromeDriver();
	       driver.get("https://www.nykaa.com/");
	       driver.manage().window().maximize();
	       driver.findElement(By.name("search-suggestions-nykaa")).sendKeys("L'Oreal Paris",Keys.ENTER);
	       driver.findElement(By.className("sort-name")).click();
	       driver.findElement(By.xpath("//span[text()='customer top rated']")).click();
	       driver.findElement(By.xpath("//span[text()='Category']")).click();
	       driver.findElement(By.xpath("//span[text()='Hair']")).click();
	       driver.findElement(By.xpath("//span[text()='Hair Care']")).click();
	       driver.findElement(By.xpath("//span[text()='Shampoo']")).click();
	       driver.findElement(By.xpath("//span[text()='Concern']")).click();
	       driver.findElement(By.xpath("//span[text()='Color Protection']")).click();
	       //driver.findElement(By.xpath("//div[@class='css-xrzmfa']/..")).click();
	       Set<String> windowHandle = driver.getWindowHandles();
	       List<String> newWindow=new ArrayList<String>(windowHandle);
	       driver.switchTo().window(newWindow.get(1));
	       driver.findElement(By.xpath("//span[text()='180ml']")).click();
	       WebElement findElement3 = driver.findElement(By.xpath("(//span[text()='MRP:']/following-sibling::span)[1]"));
	       String text2 = findElement3.getText();
	       System.out.println(text2);
	       driver.findElement(By.xpath("(//span[text()='Add to Bag'])[1]")).click();
	       driver.findElement(By.xpath("(//*[name()=\"svg\" and @width=\"24\"])[6]")).click();
	       WebElement findElement4 = driver.findElement(By.xpath("//iframe[@class='css-acpm4k']"));
	       driver.switchTo().frame(findElement4);
	       //Thread.sleep(3000);
	       driver.findElement(By.xpath("//span[@class=' css-1l4d0ex e171rb9k3']")).click();	       
	       WebElement findElement5 = driver.findElement(By.xpath("//p[@class='css-1e59vjt eka6zu20']"));
	       String text3 = findElement5.getText();
	       System.out.println(text3);
	       if(text2.equals(text3)){
	    	   System.out.println("Both are same");
	       }
	       else {
	    	   System.out.println("Both are not same");
	       }
	       
	       driver.findElement(By.xpath("//button[text()='Continue as guest']")).click();
	       driver.close();
	

	}

}
