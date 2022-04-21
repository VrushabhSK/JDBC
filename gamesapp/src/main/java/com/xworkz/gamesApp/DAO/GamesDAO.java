package com.xworkz.gamesApp.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static com.xworkz.gamesApp.Constants.DBConstants.*;

import com.xworkz.gamesApp.dto.GamesDTO;

public class GamesDAO {
	
	public static boolean saveGame(GamesDTO gamesDTO) {
		String insertQuery = "insert into games values (?, ?, ?, ?)";
		if(gamesDTO == null) {
			return false;
		} else {
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			
			{
				try {
					connection.setAutoCommit(false);
					connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				try {
					preparedStatement = connection.prepareStatement(insertQuery);
					preparedStatement.setInt(1, gamesDTO.getId());
					preparedStatement.setString(2, gamesDTO.getName());
					preparedStatement.setInt(3, gamesDTO.getNoOfPlayers());
					preparedStatement.setString(4, gamesDTO.getType());
					
					preparedStatement.execute();
					
					connection.commit();
					return true;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
		}
		return false;
	}

}
