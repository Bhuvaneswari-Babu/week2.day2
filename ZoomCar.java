package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ZoomCar {
public static void main(String[] args) {
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver=new ChromeDriver();
	driver.get("https://www.zoomcar.com/in/bangalore/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	driver.findElement(By.className("country_list__wrapper--multiselect")).click();
	driver.findElement(By.xpath("//span[text()='India']")).click();
	driver.findElement(By.className("city_list__wrapper--multiselect")).click();
	driver.findElement(By.xpath("//span[text()='Bangalore']")).click();
	driver.findElement(By.xpath("//button[contains(text(),'Confirm')]")).click();	
	driver.findElement(By.xpath("//div[contains(text(),'Pick Up City, Airport, Address or Hotel')]")).click();	
	driver.findElement(By.xpath("//div[text()='Bangalore International Airport']")).click();
	driver.findElement(By.xpath("//div[@class='ride-time']")).click(); 
	driver.findElement(By.xpath("//td[contains(text(),'21')]")).click();
	driver.findElement(By.xpath("//td[contains(text(),'21')]")).click();
	driver.findElement(By.xpath("//button[contains(text(),'Continue')]")).click();
	driver.findElement(By.xpath("//button[contains(text(),'Find cars')]")).click();
	String price = driver.findElement(By.xpath("(//h3[text()='Maruti Swift Dzire']/following::div[@class='price-book-ctr']/div/div)[1]")).getText();
	System.out.println(price);
	
}
}
