package com.ecommerce.onlineshopping;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class BuyProduct
{
	PreparedStatement ps=null;
	Connection connection=null;
	
	void buy() throws Exception
	{
		JdbcConnection connectionobj =new  JdbcConnection();
		Connection connection =connectionobj.getConnectionDetails();
		Scanner sc=new Scanner(System.in);
		System.out.println("Please enter your registered mobile number to purchase product:- ");
		long mob=sc.nextLong();
		PreparedStatement ps=connection.prepareStatement("select sum(total_amount) from add_to_cart where mobile_number=?");
		ps.setLong(1, mob);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			long bill=rs.getLong(1);
			System.out.println("Your Total Bill Amount= "+bill);
		}
		System.out.println("Please select number for payment mode:- ");
		System.out.println("1:- Cash On Delivery");
		System.out.println("2:- Card Pyment");
		System.out.println("3:- UPI Payment");
		int ch=sc.nextInt();
		switch(ch)
		{
		case 1:
			
			System.out.println("Thank You For Purchase");
			System.out.println("Visit Again");
			break;
		case 2:
			System.out.println("Payment Successful");
			System.out.println("Thank You For Purchase");
			System.out.println("Visit Again");
			break;
		case 3:
			System.out.println("Payment Successful");
			System.out.println("Thank You For Purchase");
			System.out.println("Visit Again");
			break;
			default:
				System.out.println("Enter valid number");
				break;
		}
		/*    PreparedStatement ps4 =connection.prepareStatement("select quantity from Products where product_id=5");
		ResultSet rs1=ps4.executeQuery();
		while(rs1.next()) {
			 main_qty=rs1.getInt(1);
		}
		
        int updated_Qty= main_qty-qnt4;
		
		PreparedStatement ps5 =connection.prepareStatement("update Products set quantity=? where product_id=5");
		ps5.setInt(1,updated_Qty );
		ps5.execute();
       System.out.println("Done");
		//connection.close();
		
	}*/
		PreparedStatement ps7=connection.prepareStatement("delete  from add_to_cart where mobile_number=?");
		ps7.setLong(1, mob);
		ps7.executeUpdate();
		System.out.println("Your Cart is Empty Now");
		
	}

}
