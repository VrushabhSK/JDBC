package com.xworkz.gamesApp.dto;

public class GamesDTO {

	private int id;
	private String name;
	private int noOfPlayers;
	private String type;
	
	public GamesDTO() {
		
	}
	


	public GamesDTO(int id, String name, int noOfPlayers, String type) {
		super();
		this.id = id;
		this.name = name;
		this.noOfPlayers = noOfPlayers;
		this.type = type;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNoOfPlayers() {
		return noOfPlayers;
	}

	public void setNoOfPlayers(int noOfPlayers) {
		this.noOfPlayers = noOfPlayers;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
