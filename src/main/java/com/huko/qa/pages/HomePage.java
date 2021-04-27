package com.huko.qa.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	private WebDriver driver;

	// Page Factory
	@FindBy(xpath = "//div[@id='top-header-menu']//child::div[@class='header item']")
	WebElement HomePage_Logo;

	@FindBy(xpath = "//div[@class='column']//div[@class='header']")
	WebElement Contacts_activity_stream;

	private By homeSection = By.xpath("//div[@class='column']//div[@class='header']");

	// Initialize page factory elements
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	// Actions

	public String validateCurrrentUrl() {
		return driver.getCurrentUrl();

	}

	public int validatehomepageitemscount() {
		return driver.findElements(homeSection).size();

	}

	public List<String> validatehomepageitems() throws InterruptedException {
		Thread.sleep(4000);

		List<WebElement> Elementitems = driver.findElements(homeSection);
		List<String> itemsList = new ArrayList<>();

		for (WebElement e : Elementitems) {
			String text = e.getText();
			System.out.println(text);
			itemsList.add(text);
		}

		return itemsList;

	}

	public boolean validateHomepage_Logo() {
		return HomePage_Logo.isDisplayed();
	}

}
