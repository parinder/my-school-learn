package com.gms.helpers;

import com.github.javafaker.Faker;

public class RandomDataHelper {

	public Faker faker;

	public RandomDataHelper() {
		this.faker = new Faker();
	}

	public String getRandomTestIdNumber(){
		return  this.faker.numerify("#####");
	}

	public String getRandomFirstName() {
		return this.faker.firstName();
	}

	public String getRandomLastName() {
		return this.faker.lastName();
	}

	public String getEmailAddress(String username) {
		String email = username + "@example.com";
		return email.toLowerCase();
	}

	public String getRandomEmailAddress(String firstName, String lastName) {
		String username = this.getRandomUsername(firstName, lastName);
		String email = this.getEmailAddress(username);
		return email;
	}

	public String getRandomUsername(String firstName, String lastName) {
		String username = firstName + "." + lastName + "." + this.getRandomTestIdNumber();
		return username.toLowerCase();
	}
}