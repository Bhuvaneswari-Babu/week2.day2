package week2.day2;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {
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
// 	Click Find leads
			driver.findElement(By.linkText("Find Leads")).click();
//Enter first name
			driver.findElement(By.xpath("(//label[text()='First name:'])[3]/following::input")).sendKeys("Bhuvana");
			//Click Find leads button
			driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
			//Click on first resulting lead  
			Thread.sleep(3000);
			driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a)[1]")).click();			
			// Verify title of the page
			 String title = driver.getTitle();
			 if(title.equals("View Lead | opentaps CRM")) {
			 System.out.println("view lead page is verified");	
			 }
			 else {
				 System.out.println("view lead page is not  verified");
			 }
		//  Click Edit
			 driver.findElement(By.linkText("Edit")).click();
			// Change the company name
			 driver.findElement(By.id("updateLeadForm_companyName")).clear();
			 driver.findElement(By.id("updateLeadForm_companyName")).sendKeys("Tesla");
			// Click Update
			 driver.findElement(By.xpath("//input[@class='smallSubmit']")).click();
		// Confirm the changed name appears
			 String companyName = driver.findElement(By.id("viewLead_companyName_sp")).getText();
			 if (companyName.equals("Tesla (10945)")) {
				System.out.println("Company name is updated");
			 }
			 else {
				 System.out.println("Company name is not updtaed");
			 }
			// Close the browser (Do not log out)
			 driver.quit();
			}
			 
			
}

