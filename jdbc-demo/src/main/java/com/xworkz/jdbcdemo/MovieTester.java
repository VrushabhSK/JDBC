package com.xworkz.jdbcdemo;

import java.util.Scanner;

import com.xworkz.jdbcdemo.dao.MovieDAO;

public class MovieTester {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		MovieDAO dao=new MovieDAO();
		String text=null;
		do {
			System.out.println("Enter 1 to insert movie");
			System.out.println("Enter 2 to update movie datils");
			System.out.println("Enter 3 to delete movie");
			System.out.println("Enter 4 to get all movies ");
			System.out.println("Enter 5 to get Language And Budget By MovieName ");
			System.out.println("Enter 6 to get movie name by movie id");
			int choice=sc.nextInt();
			switch (choice) {
			case 1:
				dao.insertMovie();
				break;
				
			case 2:
				dao.updateMovie();
				break;
				
			case 3:
				dao.deleteMovie();
				break;

			case 4:
				dao.getAll();
			    break;
			
			case 5:
				System.out.println("enter movie name to get language and budget");
				dao.getLanguageAndBudgetByMovieName(sc.next());
			    break;
			
			case 6:
				dao.getMovieNameByMovieId();
			    break;
				
			default:System.out.println("enter correct choice");
				break;
			}
			System.out.println("do you want to continue yes / no");
			text=sc.next();
		}while(text.equalsIgnoreCase("yes"));
		
	}


}
