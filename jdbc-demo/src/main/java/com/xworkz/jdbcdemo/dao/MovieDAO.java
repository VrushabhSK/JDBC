package com.xworkz.jdbcdemo.dao;

import java.awt.Cursor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.xworkz.jdbcdemo.Runner;

public class MovieDAO implements Runner {

	Scanner sc = new Scanner(System.in);

	@Override
	public void insertMovie() {

		System.out.println("enter a id");
		int id = sc.nextInt();

		System.out.println("enter a movie name");
		String name = sc.next();

		System.out.println("enter a rating");
		double rate = sc.nextDouble();

		System.out.println("enter a laanguage");
		String lang = sc.next();

		System.out.println("enter a budget");
		long budget = sc.nextLong();

		Connection connection = null;
		Statement statement1 = null;
		try {
			// Step 1
			// Load and Register the driver
    //		Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("class loaded");

			// step 2
			// create connection (Establish connection with MySQL Server)
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jan06", "root", "root");

			System.out.println("connection created");

			// step 3
			// create platform / environment to execute the queries
			statement1 = connection.createStatement();
			System.out.println("statement created");

			// Step 4
			// excute the query
			statement1.execute("INSERT INTO movie(id,name,rating,language,budget) VALUES (" + id + ",'" + name + "',"
					+ rate + ",'" + lang + "'," + budget + ")");
			System.out.println("successfully inserted");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// step 6
			// close the costly resources
			try {
				if (statement1 != null)
					statement1.close();
				if (connection != null)
					connection.close();

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	@Override
	public void getMovieNameByMovieId() {
		String query = "SELECT mv.name FROM movie mv WHERE id=(" + 2 + ")";

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jan06", "root", "root");

			statement = connection.createStatement();

			// Step 5
			// Processing the result set
			resultSet = statement.executeQuery(query); /*
											 * resultSet has data which is not directly from database but which data
											 * came from the Cursor. cursor is temporary memory in Mysql
											 */

			while (resultSet.next()) {
				// String Name = resultSet.getString("name");
				String Name = resultSet.getString(1);
				System.out.println("Movie Name: " + Name);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// Step 6
			// Close the costly resources
			try {
				if (resultSet != null)
					resultSet.close();
				if (statement != null)
					statement.close();
				if (connection != null)
					connection.close();

				System.out.println("Closed Quastly Resources");
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}

		}

	}

	@Override
	public void getAll() {
		String query = "SELECT * FROM movie ";

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jan06", "root", "root");

			statement = connection.createStatement();

			// Step 5
			// Processing the result set
			resultSet = statement.executeQuery(query); /*
											 * resultSet has data which is not directly from database but which data
											 * came from the Cursor. cursor is temporary memory in Mysql
											 */

			while (resultSet.next()) {
				// String Name = resultSet.getString("name");
				// System.out.println("Movie Name: " + Name);
				System.out.println("id:" + resultSet.getInt("id"));
				System.out.println("name:" + resultSet.getString("name"));
				System.out.println("rating:" + resultSet.getDouble("rating"));
				System.out.println("langauge:" + resultSet.getString("language"));
				System.out.println("budget:" + resultSet.getLong("budget"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// Step 6
			// Close the costly resources
			try {
				if (resultSet != null)
					resultSet.close();
				if (statement != null)
					statement.close();
				if (connection != null)
					connection.close();

				System.out.println("Closed Quastly Resources");
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}

		}

	}

	@Override
	public void getLanguageAndBudgetByMovieName(String movieName) {

		String query = "SELECT language,budget FROM movie where name=('" + movieName + "')";

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jan06", "root", "root");

			statement = connection.createStatement();

			// Step 5
			// Processing the result set
			resultSet = statement
					.executeQuery(query); /*
											 * resultSet has data which is not directly from database but which data
											 * came from the Cursor. cursor is temporary memory in Mysql
											 */

			while (resultSet.next()) {

				System.out.println("langauge:" + resultSet.getString("language"));
				System.out.println("budget:" + resultSet.getLong("budget"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// Step 6
			// Close the costly resources
			try {
				if (resultSet != null)
					resultSet.close();
				if (statement != null)
					statement.close();
				if (connection != null)
					connection.close();

				System.out.println("Closed Quastly Resources");
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}

		}

	}

	public void updateMovie() {
		Scanner sc1 = new Scanner(System.in);

		System.out.println("enter movie name to update ");
		String name = sc1.next();

		System.out.println("enter a rating to update ");
		double rating = sc1.nextDouble();

		System.out.println("enter a language to update");
		String language = sc1.next();

		System.out.println("enter a budget to uodate");
		long budget = sc1.nextLong();

		System.out.println("enter a id to update all the the deatils");
		int id = sc1.nextInt();

		Connection connection = null;
		Statement statement = null;
		try {
			// Step 1
			// Load and Register the Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Class Loaded");

			// Step2
			// Create Connection (Establish connection with MySQL Server)
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jan06", "root", "root");
			System.out.println("Connection Created");

			statement.execute("UPDATE movie SET name=('" + name + "'),rating=(" + rating + "),language=('" + language
					+ "'),budget=(" + budget + ") where id=(" + id + ")");
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("successfully updated");

	}

	public void deleteMovie() {
		Scanner sc = new Scanner(System.in);

		System.out.println("enter id to delete all the details");
		int id = sc.nextInt();

		Connection connection = null;
		Statement statement = null;
		try {
			// Step 1
			// Load and Register the Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Class Loaded");

			// Step2
			// Create Connection (Establish connection with MySQL Server)
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jan06", "root", "root");
			System.out.println("Connection Created");
			
			statement= connection.createStatement();
			System.out.println("Statement is created");

			statement.execute("DELETE FROM movie where id=(" + id + ")");
			System.out.println("successfully deleted");

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			// Step 6
			// Close the costly resources
			try {
				if (statement != null)
					statement.close();
				if (connection != null)
					connection.close();

				System.out.println("Closed Quastly Resources");
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}

		}
	}

}
