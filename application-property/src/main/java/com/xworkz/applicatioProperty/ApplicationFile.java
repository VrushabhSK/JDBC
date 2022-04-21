package com.xworkz.applicatioProperty;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ApplicationFile {
	
	public static void main(String[] args) {
		
		
			try {
			File file=new File("D:\\Xworkz Java\\JDBC\\ApplicationNames.txt");
			
				Scanner myReader = new Scanner(file);
				while(myReader.hasNextLine()) {
					String data= myReader.nextLine();
					System.out.println(data);	
			}	
			myReader.close();	
		}catch(FileNotFoundException e){
			System.out.println("An error Occured");
			e.printStackTrace();
		}
	}

}
