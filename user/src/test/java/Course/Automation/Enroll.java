package Course.Automation;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageobject.LoginPage;
import pageobject.StudentHomePage;
import resource.Base;

public class Enroll extends Base {
	public static StudentHomePage stdHome;

	 public static WebDriver driver = null;

	@BeforeTest
	public  void testLogin() {
		driver = initializeDriver();
	}


	@Test(priority = 1)
	public void checkLogin() {
		driver.manage().window().maximize();
		driver.get("https://test.qualicoach.org/");

		// login page
		LoginPage login = new LoginPage(driver);
		login.getUserName().sendKeys("user99");
		login.getPassword().sendKeys("User@3902");
		login.getLoginButton().click();
	}

	@Test(priority = 2)
	public void enroll() throws InterruptedException {

		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1500)");
		
		enrolltocourse();
		

	}
	
	public static void enrolltocourse() throws InterruptedException {
		stdHome = new StudentHomePage(driver);
		stdHome.findCourse().click();
		Thread.sleep(0);
		Actions a = new Actions(driver);
		a.moveToElement(stdHome.selectCourse()).build().perform();
		Thread.sleep(3000);
		stdHome.selectHoveredCourseStudent().click();
		stdHome.enrollCourseButton().click();
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}

}


