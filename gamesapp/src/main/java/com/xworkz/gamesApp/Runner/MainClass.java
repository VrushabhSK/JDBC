package com.xworkz.gamesApp.Runner;

import com.xworkz.gamesApp.DAO.GamesDAO;
import com.xworkz.gamesApp.dto.GamesDTO;

public class MainClass {
	
	public static void main(String[] args) {
		
	
	
	GamesDAO gamesDAO = new GamesDAO();
	
	GamesDTO gamesDTO = new GamesDTO(2, "Chess", 2 , "Indoor");
	
	boolean saveStatus = GamesDAO.saveGame(gamesDTO) ;
	
	if(saveStatus) {
		System.out.println("Save Successful");
	}else {
		System.out.println("Save Unsuccessful");
	}

}
}
