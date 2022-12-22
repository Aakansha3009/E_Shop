package com.ecommerce.onlineshopping;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public  class Admin implements AdminInterface 
{
	static final int admin_password=1122;
	
	JdbcConnection connectionobj=new JdbcConnection();
	Connection connection=connectionobj.getConnectionDetails();
	Scanner scanner=new Scanner(System.in);
	
	public void checkAdmin() 
	{
		System.out.print("Please enter the password :");
		int enterPassward = scanner.nextInt();
		if(enterPassward==admin_password) 
		{
			System.out.println("Enter < 1 > To Get Quantity Status Of Products");
			System.out.println("Enter < 2 > To Get List Of Registered User List");
			System.out.println("Enter < 3 > To Get History Of Purchase Products");
			int adminInput =scanner.nextInt();
			
			switch(adminInput) 
			{
				case 1: getQuantityStatus();
				break;
			
				case 2: getRegisterUserList();
				break;
			
				case 3: getHistoryOfPurchaseProduct();
				break;	
			}		
		}
		else 
		{
			throw new InvalidInputException("You Have Entered Wrong Password!!! Please Enter Write Password...");
		}
	}
	
	// getRegisterUserList method
    public void getRegisterUserList() 
    {
    	try 
    	{
			PreparedStatement ps=connection.prepareStatement("select * from User");
			ResultSet rs=ps.executeQuery();
			System.out.println("------------------------");
			System.out.println("Name "+"            "+"City");
			System.out.println("------------------------");
			while(rs.next()) 
			{
				System.out.print(rs.getString(2)+"           "+rs.getString(4));
				System.out.println(" ");
			}
			System.out.println("------------------------");
			ps.close();
			rs.close();
		}
    	catch(SQLException e) 
		{
			e.printStackTrace();
		}
    	System.out.println("");
    	System.out.println("Enter < 1 > To Get Quantity Status Of Products");
    	System.out.println("Enter < 3 > To Get History Of Purchase Products");
    	int input=scanner.nextInt();
		switch(input) 
		{
			case 1: getQuantityStatus();
			break;
		
			case 3: getHistoryOfPurchaseProduct();
			break;
		}
    }
    
    //getQuantityStatus() method
    public void getQuantityStatus() 
    {
    	try 
    	{
    		System.out.println("Enter the product id to check the stock:");
    		int id=scanner.nextInt();
			PreparedStatement ps =connection.prepareStatement("select * from Products where product_id=?");  //Modify
			ps.setInt(1,id);
			ResultSet rs= ps.executeQuery();
			while(rs.next()) 
			{
				System.out.print(rs.getString(2));
				System.out.print(":");
				System.out.print("Quantity is :"+rs.getInt(5));
				System.out.println("");	
			}
			ps.close();
			rs.close();
		} 
		catch(SQLException e) 
		{
			e.printStackTrace();
		}
		System.out.println(" ");
		System.out.println("Enter < 2 > To Get List Of Registered User List");
		System.out.println("Enter < 3 > To Get History Of Purchase Products");
		int input=scanner.nextInt();
		switch(input) 
		{
			case 2: getRegisterUserList();
			break;
			
			case 3: getHistoryOfPurchaseProduct();
			break;
		}
    	System.exit(0);
	}
    
    //getHistoryOfPurchaseProduct() method
    public void getHistoryOfPurchaseProduct() 
    {	
    	int i=1;			
        try 
        {
        	String sql="select name ,LED_TV,Refrigerator,Washing_Machine,Laptop,Oven,Ac,Mobile,Celling_Fan,Cooler,Camera from purchaseList left join User on purchaseList.mobile_number=user.mobile_number";
    	
        	Statement stm =connection.createStatement();
        	ResultSet rs= stm.executeQuery(sql);
        	System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");
        	System.out.printf("%1s %8s %15s %16s %20s %10s %8s %6s %10s %15s %10s %11s","Sr.No","Name","LED_TV","Refrigerator","Washing Machine","Laptop","Oven","AC","Mobile","Celling Fan","Cooler","Camera\n");
        	System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");
        	while(rs.next()) 
        	{
			 System.out.printf("%1s %14s %10s %13s %19s %15s %9s %7s %8s %11s %13s %12s",i,rs.getString(1),rs.getInt(2),rs.getInt(3),rs.getInt(4),rs.getInt(5),rs.getInt(6),rs.getInt(7),rs.getInt(8),rs.getInt(9),rs.getInt(10),rs.getInt(11));
			 System.out.println("");
			 System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");
			 i++;
			 System.out.println("");
        	}
        }	 
        catch(SQLException e) 
    	{   		
			e.printStackTrace();
		}	
    }
}
