package week2.day2;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {
	public static void main(String[] args) throws InterruptedException {		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
//Launch URL "http://leaftaps.com/opentaps/control/login"
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//Enter UserName and Password Using Id Locator
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");		
		driver.findElement(By.id("password")).sendKeys("crmsfa");
//Click on Login Button using Class Locator
		driver.findElement(By.className("decorativeSubmit")).click();	
//Click on CRM/SFA Link
			driver.findElement(By.linkText("CRM/SFA")).click();
//Click on Leads Button
			driver.findElement(By.linkText("Leads")).click();
//Click Find leads
			driver.findElement(By.linkText("Find Leads")).click();
//Click on Phone
			driver.findElement(By.xpath("//span[text()='Phone']")).click();
//Enter phone number
			driver.findElement(By.xpath("//input[@id='ext-gen262']")).clear();
			driver.findElement(By.xpath("//input[@id='ext-gen270']")).sendKeys("9445819480");
			//Click find leads button
			driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
//Capture name of First Resulting lead
					Thread.sleep(3000);
					String leadID = driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a)[1]")).getText();
					System.out.println("The first lead id is:"+leadID);
//Click First Resulting lead
					driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a)[1]")).click();	
//Click Delete
					driver.findElement(By.linkText("Delete")).click();
//Click Find leads
					driver.findElement(By.linkText("Find Leads")).click();
//Enter captured lead ID
					driver.findElement(By.xpath("(//label[text()='Lead ID:']/following::input)[1]")).sendKeys(leadID);
					//Click find leads button
					driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
					//	Verify message "No records to display" in the Lead List. This message confirms the successful deletion
					Thread.sleep(3000);
					String message = driver.findElement(By.xpath("//div[@class='x-paging-info']")).getText();
					if (message.equals("No records to display")) {
						System.out.println("The lead is deleted");	
					}
					else {
						System.out.println("The lead is not deleted");
					}	
					driver.quit();
	}
}
