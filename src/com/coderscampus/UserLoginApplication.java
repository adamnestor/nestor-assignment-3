package com.coderscampus;

import java.io.IOException;
import java.util.Scanner;

public class UserLoginApplication {

	public static void main(String[] args) {

		// create an instance of UserService to allow use of its methods

		UserService userService = new UserService();

		// declares an array of users that belong to the User class
		User[] users;

		// this will read the file and assign created users to the users array, or it
		// will tell us if an exception occurred
		try {
			users = userService.getUsers("data.txt");
		} catch (IOException e) {
			System.out.println("IOException: " + e.getMessage());
			return;
		}

		// allow user to input a username and password
		// validate the inputed username and password by checking if they are equal to
		// existing user data

		// set the number of attempts to 5
		int maxAttempts = 5;

		// create a scanner to allow for the input
		Scanner keyboard = new Scanner(System.in);

		// allow user to enter their data
		int attempts = 0;
		while (attempts < maxAttempts) {
			System.out.println("Enter username: ");
			String inputUsername = keyboard.nextLine();
			System.out.println("Enter password: ");
			String inputPassword = keyboard.nextLine();

			// uses the method validateUser from userService class in order to compare the
			// input and the stored data
			User confirmUser = userService.validateUser(users, inputUsername, inputPassword);
			if (confirmUser != null) {
				System.out.println("Welcome " + confirmUser.getName());
				return;
			} else {
				attempts++;
				System.out.println("Invalid login, please try again.");
			}

		}
		System.out.println("Too many failed login attempts, you are now locked out.");

	}

}
