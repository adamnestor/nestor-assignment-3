package com.coderscampus;

import java.io.IOException;
import java.util.Scanner;

public class UserLoginApplication {

	public static void main(String[] args) {

		// create an instance of UserService to allow use of its methods
		UserService userService = new UserService();

		// this will read the file and assign created users to a users array, or it
		// will tell us if an exception occurred
		User[] users;
		try {
			users = userService.getUsers("data.txt");
		} catch (IOException e) {
			System.out.println("IOException: " + e.getMessage());
			return;
		}

		// set the number of attempts to 5 and open a scanner to allow for those
		// attempts
		int maxAttempts = 5;
		Scanner keyboard = new Scanner(System.in);

		int attempts = 0;
		while (attempts < maxAttempts) {
			System.out.println("Enter username: ");
			String inputUsername = keyboard.nextLine();
			System.out.println("Enter password: ");
			String inputPassword = keyboard.nextLine();

			// uses the method validateUser from userService class
			User confirmUser = userService.validateUser(users, inputUsername, inputPassword);
			if (confirmUser != null) {
				System.out.println("Welcome " + confirmUser.getName());
				keyboard.close();
				return;
			} else {
				attempts++;
				System.out.println("Invalid login, please try again.");
			}
		}

		System.out.println("Too many failed login attempts, you are now locked out.");
		keyboard.close();
	}

}
