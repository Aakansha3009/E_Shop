package com.ecommerce.onlineshopping;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class User implements UserInterface 
{
	Scanner scanner=new Scanner(System.in);
	JdbcConnection connectionobj=new  JdbcConnection();
	Connection connection =connectionobj.getConnectionDetails();
	Product product=new Product();
	AddToCart a=new AddToCart();
	
	public void newRegistration() 
	{
	  Compare compareuser = new Compare();
			
	  System.out.println("Enter Your Mobile Number:");
	  long mobile_number= scanner.nextLong();
			
	  if(compareuser.compareUser(mobile_number)) 
	  {
		throw new MobileNumberAlreadyExistException("Your Mobile Number Already Exist!");	
	  }
				
	  System.out.println("Enter Your Name : ");
	  String name=scanner.next();
	  System.out.println("Enter Your Valid Email id : ");
	  String email_id=scanner.next();
	  System.out.println("Enter Your Current City : ");
	  String city = scanner.next();
	  
	  try 
	  {
		  PreparedStatement ps = connection.prepareStatement("insert into User(mobile_number,name,email_id,city) values(?,?,?,?)");
		  ps.setLong(1, mobile_number);
 		  ps.setString(2, name);
		  ps.setString(3, email_id);
		  ps.setString(4,city);
		  ps.execute();
				
		  System.out.println("You have Register Successefully!!!!");
		  System.out.println("Login for shopping");
		  System.out.println("Enter < 2 > User Login");
		  int input=scanner.nextInt();
		  switch(input) 
		  {
			case 2: checkRegistration();  
		  }
	   } 
	   catch(SQLException e) 
	   {
		   e.printStackTrace();
	   }

	}
	
	public void checkRegistration() 
	{
		System.out.println("Enter Your Register Mobile Number :");
		long enterMobileNumber= scanner.nextLong();
		try 
		{
			PreparedStatement ps = connection.prepareStatement("select * from User");
			ResultSet rs = ps.executeQuery();
			ArrayList numberList= new ArrayList();
			while(rs.next()) 
			{
				long mobile_number=rs.getLong(1);
				numberList.add(mobile_number);
			}
			if(numberList.contains(enterMobileNumber)) 
			{
				System.out.println("Login Successfully!!!");
				System.out.println("**************************    MyE-Store Products   ***********************");
			}
			else 
			{
				System.out.println("You have Not Registered!! /n For registration please enter < 3 >");
				int input = scanner.nextInt();
				switch(input) 
				{
					case 3: newRegistration(); 
				}
			}
		} 
		catch(SQLException e) 
		{
			e.printStackTrace();
		}
		
		try 
		{	
			a.addCart(); 
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		//product.displayProductList();
	}
}
