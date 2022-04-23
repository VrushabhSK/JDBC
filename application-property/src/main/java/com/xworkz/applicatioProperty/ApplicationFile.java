package com.xworkz.applicatioProperty;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ApplicationFile {

	public static void main(String[] args) throws Exception {

		try {
			File file = new File("D:\\Xworkz Java\\JDBC\\ApplicationNames.txt");

			Scanner myReader = new Scanner(file);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				System.out.println(data);
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error Occured");
			e.printStackTrace();
		}
	}

	public void saveData() {

		Connection con = null;
		PreparedStatement prep = null;

		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/application", "root", "root");
			System.out.println("Connection Succussful.");
			prep = con.prepareStatement("INSERT INTO application(applicationNames) VALUES(?)");

			prep.setString(1, "name");

			FileReader reader = new FileReader("D:\\Xworkz Java\\JDBC\\ApplicationNames.txt");

			prep.setCharacterStream(1, reader);
			prep.execute();

			System.out.println("Data Succussfully Save in DataBase");
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				if (prep != null)
					prep.close();
				if (con != null)
					con.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
