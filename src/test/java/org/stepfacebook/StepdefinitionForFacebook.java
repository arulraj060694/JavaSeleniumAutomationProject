package org.stepfacebook;

import org.baseClass.BaseClass;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepdefinitionForFacebook extends BaseClass {

	@Given("User should open the facebook application")
	public void user_should_open_the_facebook_application() {
		BaseClass b = new BaseClass();
		b.getBrowser("chrome");
		b.winMax();
		b.launchURL("https://www.facebook.com/");
	}

	@When("User enters the username and password in the application")
	public void user_enters_the_username_and_password_in_the_application() {
		System.out.println("userName enterned");
		System.out.println("password enterned");
	}

	@And("User clicks the login button")
	public void user_clicks_the_login_button() {
		System.out.println("login button clicked");
	}

	@Then("User verifies the application moved to home page")
	public void user_verifies_the_application_moved_to_home_page() {
		System.out.println("Success");
	}

	@When("User enters the {string} and {string} in the application")
	public void user_enters_the_and_in_the_application(String string, String string2) {
		System.out.println(string);
		System.out.println(string2);
	}

}
