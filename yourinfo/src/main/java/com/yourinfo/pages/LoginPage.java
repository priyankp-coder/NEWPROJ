package com.yourinfo.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.youinfo.base.TestBase;

public class LoginPage extends TestBase {

	@FindBy(xpath = "//select[@ng-model='loginCtrl.selectedRole']")
	WebElement RoleClick;

	@FindBy(xpath = "//option[@label='PL']")
	WebElement RoleTypeSelect;

	@FindBy(xpath = "//input[@type='text']")
	WebElement UserName;

	@FindBy(xpath = "//input[@name='userPassword']")
	WebElement Password;

	@FindBy(xpath = "//button[@class='signIn btn btn-primary ng-binding']")
	WebElement LoginBtn;

	public LoginPage() throws IOException {
		super();

		PageFactory.initElements(driver, this );

	}

	public String validatePageTitle() {
		return driver.getTitle();	
	}
	public HomePage Login(String UN, String PSW) throws IOException {
		RoleClick.click();
		RoleTypeSelect.click();
		UserName.sendKeys(UN);
		Password.sendKeys(PSW);
		LoginBtn.click();
		
		return new HomePage();
		
		
	}
}



