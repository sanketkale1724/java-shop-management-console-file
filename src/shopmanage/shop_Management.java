package shopmanage;


import java.io.IOException;
import java.util.Scanner;

import usermanage.usermanagement;
import productmanage.productmanagement;

public class shop_Management {
	
public static void main(String[] args) throws IOException {
	Scanner sc=new Scanner(System.in);
	boolean programrun=true;
	
		System.out.println("*****Welcome to Shop Management*****");
		System.out.println("\n");
		System.out.println("Login name:");
		String name=sc.nextLine();
		System.out.println("Password:");
		String pass=sc.nextLine();
		if(!usermanagement.validdatauserandpassword(name, pass)) {
			System.out.println("login failed..");
			return;
		}
		while(programrun) {
		System.out.println("Welcome to shop management");	
		System.out.println("1.User management");
		System.out.println("2.product Management");
		System.out.println("3.Quit");
		int choise=sc.nextInt();
		if(choise==2) {
			productmanagement.productproject();
			
		}
		else if(choise==1) {
			usermanagement.mainusermanagement();
		}
		else if(choise==3) {
			programrun=false;
			System.out.println("Program has been closed");
		}
		
	}
}
}
