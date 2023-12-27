package com.coderscampus;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class UserLoginApplication {

	public static void main(String[] args) throws IOException {

		// Reading the data.txt file using a while loop to return all 4 entries.
		BufferedReader fileReader = null;
		try {
			fileReader = new BufferedReader(new FileReader("data.txt"));

			String line;
			while ((line = fileReader.readLine()) != null) {
				System.out.println(line);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			fileReader.close();
		}
		// End of file reading code
		
		
	}

}
