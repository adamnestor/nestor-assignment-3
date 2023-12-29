package com.coderscampus;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class UserService {

	public User[] getUsers(String fileName) throws IOException {
		// reading the file
		BufferedReader reader = new BufferedReader(new FileReader(fileName));

		// counting the number of lines in file
		String line;
		int count = 0;
		while (reader.readLine() != null) {
			count++;
		}
		reader.close();

		// adding lines from file to an array of users
		User[] users = new User[count];
		reader = new BufferedReader(new FileReader(fileName));

		int index = 0;

		while ((line = reader.readLine()) != null) {
			String[] data = line.split(",");
			users[index++] = new User(data[0], data[1], data[2]);
		}
		reader.close();

		return users;

	}

	// validate username and password
	public User validateUser(User[] users, String inputUsername, String inputPassword) {
		for (User user : users) {
			if (user.getUsername().equalsIgnoreCase(inputUsername) && user.getPassword().equals(inputPassword)) {
				return user;
			}
		}
		return null;
	}

}