package commanFunctionLibrary;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ERP_Functions 
{
	WebDriver driver;
	String results="";
	
	public String lauchApp(String url)
	{
		
		System.setProperty("webdriver.chrome.driver", "C:\\ch\\MyProjectsChandu\\StockAccounting_DDF\\Drivers\\chromedriver.exe");
		 driver=new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		if(driver.findElement(By.id("btnsubmit")).isDisplayed())
		{
			results="pass";
		}else
		{
			results="fail";
		}
		return results;
		}
	
	
	
	   public void logine(String usernamename,String possword)
	   {   
		   driver.findElement(By.id("username")).clear();
		   driver.findElement(By.id("username")).sendKeys(usernamename);
		   driver.findElement(By.id("password")).clear();
		   driver.findElement(By.id("password")).sendKeys(possword);
		   driver.findElement(By.id("btnsubmit")).click();
		   
		   if(driver.findElement(By.id("logout")).isDisplayed())
		   {
			   results="pass";
		   }else
		   {
			   results="fail";
		   }
		   
		   
	   }
	   
	   
	   
	   
	   
	   public String supplier(String sname,String address,String city,
			   String country,String cperson,String pnumber,String mail,String mnumber
                ,String note ) throws InterruptedException
	   {
		   driver.findElement(By.linkText("Suppliers")).click();
		   Thread.sleep(5000);
		   driver.findElement(By.xpath("//*[@id='ewContentColumn']/div[3]/div[1]/div[1]/div[1]/div/a")).click();
		   Thread.sleep(5000);
		   String ex_val=  driver.findElement(By.id("x_Supplier_Number")).getAttribute("value");
		   
		   driver.findElement(By.id("x_Supplier_Name")).sendKeys(sname);
		   driver.findElement(By.id("x_Address")).sendKeys(address);
		   driver.findElement(By.id("x_City")).sendKeys(city);
		   driver.findElement(By.id("x_Country")).sendKeys(country);
		   driver.findElement(By.id("x_Contact_Person")).sendKeys(cperson);
		   driver.findElement(By.id("x_Phone_Number")).sendKeys(pnumber);
		   driver.findElement(By.id("x__Email")).sendKeys(mail);
		   driver.findElement(By.id("x_Mobile_Number")).sendKeys(mnumber);
		   driver.findElement(By.id("x_Notes")).sendKeys(note);
		   
		   
		   
		   

			driver.findElement(By.id("btnAction")).sendKeys(Keys.ENTER);
			Thread.sleep(5000);
			driver.findElement(By.xpath("//button[text()='OK!']")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("(//button[text()='OK'])[6]")).click();
			Thread.sleep(5000);
			if(driver.findElement(By.id("psearch")).isDisplayed()){
				driver.findElement(By.id("psearch")).sendKeys(ex_val);
				driver.findElement(By.id("btnsubmit")).click();
			}else{
				driver.findElement(By.xpath("//*[@id='ewContentColumn']/div[2]/div[2]/div/button")).click();
				driver.findElement(By.id("psearch")).sendKeys(ex_val);
				driver.findElement(By.id("btnsubmit")).click();
			}
			
			String act_data=driver.findElement(By.xpath("//*[@id='el1_a_suppliers_Supplier_Number']/span")).getText();
			

			if(ex_val.equalsIgnoreCase(act_data)){
				results="Pass";
			}else{
				results="Fail";
			}
			
			return results;
			
		}
		
		public String logout() throws Exception {
			driver.findElement(By.linkText("Logout")).click();
			driver.findElement(By.xpath("//button[text()='OK!']")).click();
			
			Thread.sleep(5000);
			
			if(driver.findElement(By.id("btnsubmit")).isDisplayed()){
				results="Pass";
			}else{
				results="Fail";
			}
			
			return results;
			
		}
		
		public void closebrw()
		{
			driver.close();
		}
	
	
	
	
	
	
}
