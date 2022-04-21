package com.xworkz.applicatioProperty;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class ApplicationDetails {


	private int id;
	private String name;

	public void readApplication() {

		File file = new File("D:\\Xworkz Java\\JDBC\\ReadApplication.txt");

		try {
			Scanner data = new Scanner(file);
			while (data.hasNextLine()) {
				name = "";
				String line = data.nextLine();
				while (data.hasNextInt()) {
					id = data.nextInt();
				}

				if (data.hasNextInt()) {
					name = " " + data.next();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void saveData() {

	

	Connection con = null;
	PreparedStatement prep  = null;

	try
	{
		con = DriverManager.getConnection("URL", "USERNAME", "PASSWORD");
		prep = con.prepareStatement("INSERT INTO application VALUES(?,?)");
		prep.setInt(1, id);
		prep.setString(2, name);
		prep.executeUpdate();
	}catch(Exception e)
	{
		e.printStackTrace();

	}
}}
