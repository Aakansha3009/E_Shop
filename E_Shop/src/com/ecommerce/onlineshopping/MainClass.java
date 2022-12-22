package com.ecommerce.onlineshopping;
import java.util.Scanner;

public class MainClass 
{
	public static void main(String[] args)throws Exception
	{
		System.out.println("      --------------------------------------------------------------------------------------------");
		System.out.println("           ************************************ WELCOME E_SHOP *************************************         ");
		System.out.println("      ---------------------------------------------------------------------------------------------");
		System.out.println("");
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter < 1 >: ADMIN LOGIN");
		System.out.println("Enter < 2 >: USER LOGIN");
		System.out.println("Enter < 3 >: USER NEW REGISTRATION");
		System.out.println("Enter < 4 >: SEE CART");
		int input=scanner.nextInt();
		
		User user=new User();
		Admin admin = new Admin();
		AddToCart a=new AddToCart();
		
		switch(input) 
		{
			case 1:	admin.checkAdmin();
			break;
			
			case 2:	user.checkRegistration();
			break;
			
			case 3: user.newRegistration();
			break;
			
			case 4: a.seeYourCart();
			break;
		}
	}
}


