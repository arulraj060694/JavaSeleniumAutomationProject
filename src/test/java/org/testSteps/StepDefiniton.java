package org.testSteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefiniton {

	@Given("User should launch the application")
	public void user_should_launch_the_application() {
		System.out.println("Test1");
	}

	@When("User should enter the login credentials")
	public void user_should_enter_the_login_credentials() {
		System.out.println("Test2");
	}

	@When("User should verify and click the login function")
	public void user_should_verify_and_click_the_login_function() {
		System.out.println("Test3");
	}

	@Then("User should verfiy the succesfull login")
	public void user_should_verfiy_the_succesfull_login() {
		System.out.println("Test4");
	}

}
