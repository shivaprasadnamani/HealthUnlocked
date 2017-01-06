package com.hu.webdriver.pages.compose;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.hu.webdriver.pages.BasePage;

public class ComposePage extends BasePage {
	public ComposePage(WebDriver driver){
		super(driver);
		PageFactory.initElements(driver, this);
	}
}
