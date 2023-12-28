package com.coderscampus;

import java.io.IOException;

public class UserLoginApplication {

	public static void main(String[] args) {
		
		UserService userService = new UserService();
		User[] users;
        try {
            users = userService.getUsers("data.txt");
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return;
        }

        // Printing the returned users
        System.out.println("List of Users:");
        for (User user : users) {
            System.out.println(user.getUsername() + " " + user.getPassword() + " " + user.getName());
        }

	}

}
