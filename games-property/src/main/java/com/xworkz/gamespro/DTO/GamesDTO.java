package com.xworkz.gamespro.DTO;

public class GamesDTO {
	
	private int gameId;
	private String gameName;
	private int noOfPlayes;
	private String gameType;
	
	public GamesDTO() {

	}

	public GamesDTO(int gameId, String gameName, int noOfPlayes, String gameType) {
		super();
		this.gameId = gameId;
		this.gameName = gameName;
		this.noOfPlayes = noOfPlayes;
		this.gameType = gameType;
	}

	public int getGameId() {
		return gameId;
	}

	public void setGameId(int gameId) {
		this.gameId = gameId;
	}

	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	public int getNoOfPlayes() {
		return noOfPlayes;
	}

	public void setNoOfPlayes(int noOfPlayes) {
		this.noOfPlayes = noOfPlayes;
	}

	public String getGameType() {
		return gameType;
	}

	public void setGameType(String gameType) {
		this.gameType = gameType;
	}
       
	

}
