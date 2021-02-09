package com.yourinfo.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.youinfo.base.TestBase;

public class AdvanceSearchByOwnerPage extends TestBase{

	@FindBy(xpath="//input[@name='propertyOwnerLand.OWNER']")
	WebElement ClickonOwnerTextbox;
	@FindBy(xpath="//input[@ng-show='inputCompCtrl.showFilter' and "
			+ "@class='form-control ng-valid ng-valid-maxlength ng-touched ng-dirty ng-valid-parse "
			+ "ng-empty ng-hide']")
	WebElement EnterOwnername;
	
	public AdvanceSearchByOwnerPage() throws IOException 
	{
		super();
	}

}
