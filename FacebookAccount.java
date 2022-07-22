package week2.day2;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FacebookAccount {
	public static void main(String[] args){			
		
// Step 1: Download and set the path
		WebDriverManager.chromedriver().setup();
// Step 2: Launch the chromebrowser
		ChromeDriver driver=new ChromeDriver();
// Step 3: Load the URL https://en-gb.facebook.com/
		driver.get("https://en-gb.facebook.com/");
// Step 4: Maximise the window
		driver.manage().window().maximize();
// Step 5: Add implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
// Step 6: Click on Create New Account button
		driver.findElement(By.linkText("Create New Account")).click();
// Step 7: Enter first name
		driver.findElement(By.xpath("(//input[@class='inputtext _58mg _5dba _2ph-'])[1]")).sendKeys("Bhuvana");
// Step 8: Enter the last name						
		driver.findElement(By.xpath("(//input[@class='inputtext _58mg _5dba _2ph-'])[2]")).sendKeys("Babu");
// Step 9: Enter the mobile number
		driver.findElement(By.xpath("(//input[@class='inputtext _58mg _5dba _2ph-'])[3]")).sendKeys("9445819480");
//Step 10: Enterthe password
		driver.findElement(By.id("password_step_input")).sendKeys("Welcome&123");
// Step 11: Handle all the three drop downs
		WebElement day = driver.findElement(By.id("day"));
		Select dayDropdown=new Select(day);
		dayDropdown.selectByVisibleText("5");
		WebElement month = driver.findElement(By.id("month"));
		Select monthDropdown=new Select(month);
		monthDropdown.selectByVisibleText("Nov");
		WebElement year = driver.findElement(By.id("year"));
		Select yearDropdown=new Select(year);
		yearDropdown.selectByVisibleText("1999");
// Step 12: Select the radio button "Female" 
		driver.findElement(By.xpath("//label[text()='Female']")).click();
	}

}
