package com.xworkz.gamespro.DAO;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import com.xworkz.gamespro.DTO.GamesDTO;



public class GamesDAO {
	public static Properties loadPropertiesFile() throws Exception {

		Properties prop = new Properties();
		FileInputStream in = new FileInputStream("property.jdbc");
		prop.load(in);
		in.close();
		return prop;
	}
	

	public static boolean saveGame(GamesDAO dto) {
		System.out.println("create jdbc connection using properties file ");

		if (dto == null) {
			return false;
		} else {
			Connection connection = null;
			PreparedStatement preparedStatement = null;

			try {
				Properties prop = loadPropertiesFile();

				String driverClass = prop.getProperty("driver");
				String url = prop.getProperty("url");
				String username = prop.getProperty("username");
				String password = prop.getProperty("password");



				connection = DriverManager.getConnection(url, username, password);

				preparedStatement = connection.prepareStatement("INSERT INTO games VALUES(?,?,?,?)");

				preparedStatement.setInt(1, dto.getGameId());
				preparedStatement.setString(2, dto.getGameName());
				preparedStatement.setInt(3, dto.getNoOfPlayes());
				preparedStatement.setString(4, dto.getGameType());

				preparedStatement.execute();
				return true;

			} catch (Exception e) {
				e.printStackTrace();
			} finally {

				try {
					if (preparedStatement != null)
						preparedStatement.close();
					if (connection != null)
						connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

}
	}
}
