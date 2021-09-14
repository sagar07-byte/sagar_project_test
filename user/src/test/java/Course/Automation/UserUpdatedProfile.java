package Course.Automation;



import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageobject.DashBoardPage;
import pageobject.EditProfile;
import pageobject.LoginPage;
import pageobject.UserProfile;
import resource.Base;



public class UserUpdatedProfile extends Base {
	WebDriver driver = null;

	@BeforeTest
	public void testLogin() {
		driver = initializeDriver();
	}

	
		// TODO Auto-generated method stub
	
	

	@Test
	public void LoginTest() {
		driver.manage().window().maximize();
		driver.get("https://test.qualicoach.org/my/");

		// login page
		LoginPage login = new LoginPage(driver);
		login.getUserName().sendKeys("user99");
		login.getPassword().sendKeys("User@3902");
		login.getLoginButton().click();
		
		//click on user picture
	     DashBoardPage dashboard = new DashBoardPage(driver);
		 dashboard.getUserPhoto().click();
		 
		 //click on profile option
		  dashboard.getProfileOption().click();
		 
		//click on edit Profile
		   UserProfile userProf = new UserProfile(driver);
		   userProf.getEditProfile().click();
		   
		 //Edit the User Profile
			
			EditProfile editProfile = new EditProfile(driver);
			editProfile.getCityOrTown().sendKeys("Attibele");
			Select countryDropdown = new Select(editProfile.getcountryDropDown());
			countryDropdown.selectByValue("IN");
			
			//scroll down to update profile
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].scrollIntoView()",editProfile.getUpdateProfileButton());
			editProfile.getUpdateProfileButton().click();
		}
		
		@AfterTest
		public void tearDown() {
			driver.close();
		}
	
}



