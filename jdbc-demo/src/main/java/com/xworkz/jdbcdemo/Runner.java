package com.xworkz.jdbcdemo;

public interface Runner {
	
	public void insertMovie();
	
	public void updateMovie();
	
	public void deleteMovie();
	
	public  void getAll();
	
	public  void getLanguageAndBudgetByMovieName(String movieName);
	
	public void getMovieNameByMovieId();

}
