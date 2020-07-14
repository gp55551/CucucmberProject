package stepDefinition;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FirstStepDefintion {
	public static WebDriver driver;


	@Given("^User is on Home Page$")
	 public void user_is_on_Home_Page() throws Throwable {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\ChromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	     driver.get("https://www.facebook.com/");
	     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 }
	 
	 @When("^User Navigate to LogIn Page$")
	 public void user_Navigate_to_LogIn_Page() throws Throwable {
	 System.out.println("already in fb");
	 }
	 
	 @When("^User enters \"(.*)\" and \"(.*)\"$")
	 public void user_enters_UserName_and_Password(String username, String password) throws Throwable {
	 driver.findElement(By.id("email")).sendKeys(username); 
	     driver.findElement(By.id("pass")).sendKeys(password);
	     driver.findElement(By.id("u_0_a")).click();
	 }
	 
	 @Then("^Message displayed Login Successfully$")
	 public void message_displayed_Login_Successfully() throws Throwable {
	 System.out.println("Login Successfully");
	 }
	 
	 @When("^User LogOut from the Application$")
	 public void user_LogOut_from_the_Application() throws Throwable {
		 System.out.println("Trying to logout");
	 }
	 
	 @Then("^Message displayed LogOut Successfully$")
	 public void message_displayed_LogOut_Successfully() throws Throwable {
	 System.out.println("LogOut Successfully");
	 driver.close();
	 }
	 
	@When("^User enters Credentials to LogIn$")
	public void user_enters_testuser__and_Test(DataTable usercredentials) throws Throwable {
		List<List<String>> data = usercredentials.raw();
		driver.findElement(By.id("email")).sendKeys(data.get(1).get(0));
		System.out.println(data.get(1).get(0));
		driver.findElement(By.id("pass")).sendKeys(data.get(1).get(1));
		System.out.println(data.get(1).get(1));

		driver.findElement(By.id("u_0_a")).click();
	}
	//using maps
	@When("^User enters Credentials to LogIn$")
	public void user_enters_testuser_and_Test(DataTable usercredentials) throws Throwable {

		//Write the code to handle Data Table
		List<Map<String,String>> data = usercredentials.asMaps(String.class,String.class);
		driver.findElement(By.id("email")).sendKeys(data.get(0).get("Username")); 
	    driver.findElement(By.id("pass")).sendKeys(data.get(0).get("Password"));
	    driver.findElement(By.id("login")).click();
	    driver.manage().window().fullscreen();
	    


           }
	
	@When("^User enters Credentials to LogIn1$")
	public void user_enters_testuser_and_Test_1(DataTable usercredentials) throws Throwable {

		//Write the code to handle Data Table
		for (Map<String, String> data : usercredentials.asMaps(String.class, String.class)) {
			driver.findElement(By.id("email")).sendKeys(data.get("Username")); 
		    driver.findElement(By.id("pass")).sendKeys(data.get("Password"));
		    driver.findElement(By.id("login")).click();
			}

	}
	

}
