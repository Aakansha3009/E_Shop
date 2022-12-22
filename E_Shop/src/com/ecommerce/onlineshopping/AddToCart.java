package com.ecommerce.onlineshopping;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class AddToCart
{
	PreparedStatement ps=null;
	Connection connection=null;
	Compare compare=new Compare();
	Product p=new Product();
	BuyProduct b=new BuyProduct();
	
	
	void addCart() throws Exception
	{
		JdbcConnection connectionobj =new  JdbcConnection();
		Connection connection =connectionobj.getConnectionDetails();
		p.displayProductList();
		Scanner scn= new Scanner(System.in);
		System.out.println("Enter your registered mobile number:- ");
		long mob=scn.nextLong(); 
		
		System.out.println("Enter Sr. Number to add products into cart:- ");
		int no=scn.nextInt();
		
		switch(no)
		{
		   case 1:
			System.out.println("Number Of Quantities:- ");
			int qnt= scn.nextInt();
			int max_quantity=1000;
			if(max_quantity>=qnt)
			{
                ArrayList<Long> al= new ArrayList<Long>();
				
				String sql="select mobile_number from User";
				Statement ps=connection.createStatement();
				ResultSet rs = ps.executeQuery(sql);
				while(rs.next())
				{
					al.add(rs.getLong(1));
					
				}
				if(al.contains(mob))
				{
				
				int amt=60000;
				int total_amt=amt*qnt;
				int main_qty=0;
				System.out.println("Your total Amount= " +total_amt);
				
				PreparedStatement ps2= connection.prepareStatement("insert into add_to_cart(mobile_number,product_name,product_quantity,total_amount) values(?,?,?,?)");
				ps2.setLong(1, mob);
				ps2.setString(2, "AC");
				ps2.setInt(3, qnt);
				ps2.setInt(4, total_amt);
				ps2.executeUpdate();
				System.out.println("Product added to cart successfully");
				
				
				try {
	                  PreparedStatement ps1 =connection.prepareStatement("insert into purchaseList( mobile_number,AC) values(?,?)");
					
					ps1.setLong(1, mob);
					ps1.setInt(2,qnt);

		            
		            PreparedStatement ps3 = connection.prepareStatement("update purchaseList set AC=? where mobile_number=?");
		            ps3.setInt(1, qnt);
		            ps3.setLong(2, mob);
					if( compare.compare(mob)) {
						ps3.execute();
						ps3.close();
						
					}
					else 
					{
						ps1.execute();
						ps1.close();
					}
						
				    PreparedStatement ps4 =connection.prepareStatement("select quantity from Products where product_id=1");
					ResultSet rs1=ps4.executeQuery();
					while(rs1.next()) 
					{
						 main_qty=rs1.getInt(1);
					}
					
	                int updated_Qty= main_qty-qnt;
					
					PreparedStatement ps5 =connection.prepareStatement("update Products set quantity=? where product_id=1");
					ps5.setInt(1,updated_Qty );
					ps5.execute();
			        System.out.println("Done");
					//connection.close();
				} catch (Exception e) 
				{
					
					System.out.println(e);
				}
				}
				
				else
				{
					System.out.println("Please enter only registered mobile number");
					System.exit(0);
				}
				
				System.out.println("----------------------------------------------------------------------------------");
				System.out.println("Enter 1:- Buy Now");
				System.out.println("Enter 2:- Add more to cart");
				System.out.println("Enter 3:- See Your cart");
				int ch=scn.nextInt();
				switch(ch)
				{
				case 1:
					b.buy();
					
					break;
					
				case 2:
					addCart();
					break;
					
				case 3:
					seeYourCart();
					break;
				
				}
				
				
			}
			else
			{
				System.out.println(" AC is Out Of Stock");
			
			}
			
		   break;
	/*************************************************************************************************************/	   
		   case 2:
				System.out.println("Number Of Quantities:- ");
				int qnt1= scn.nextInt();
				int max_quantity1=1000;
				if(max_quantity1>=qnt1)
				{
	                ArrayList<Long> al= new ArrayList<Long>();
					
					String sql="select mobile_number from User";
					Statement ps=connection.createStatement();
					ResultSet rs = ps.executeQuery(sql);
					while(rs.next())
					{
						al.add(rs.getLong(1));
						
					}
					if(al.contains(mob))
					{
					
					int amt=45000;
					int total_amt=amt*qnt1;
					int main_qty=0;
					System.out.println("Your total Amount= " +total_amt);
					
					PreparedStatement ps2= connection.prepareStatement("insert into add_to_cart(mobile_number,product_name,product_quantity,total_amount) values(?,?,?,?)");
					ps2.setLong(1, mob);
					ps2.setString(2, "Camera");
					ps2.setInt(3, qnt1);
					ps2.setInt(4, total_amt);
					ps2.executeUpdate();
					System.out.println("Camera is added to cart successfully");
					
					
					try {
		                  PreparedStatement ps1 =connection.prepareStatement("insert into purchaseList( mobile_number,Camera) values(?,?)");
						
						ps1.setLong(1, mob);
						ps1.setInt(2,qnt1);

			            
			            PreparedStatement ps3 = connection.prepareStatement("update purchaseList set Camera=? where mobile_number=?");
			            ps3.setInt(1, qnt1);
			            ps3.setLong(2, mob);
						if( compare.compare(mob)) {
							ps3.execute();
							ps3.close();
							
						}
						else {
							ps1.execute();
							ps1.close();
						}
			            
					    PreparedStatement ps4 =connection.prepareStatement("select quantity from Products where product_id=2");
						ResultSet rs1=ps4.executeQuery();
						while(rs1.next()) {
							 main_qty=rs1.getInt(1);
						}
						
		                int updated_Qty= main_qty-qnt1;
						
						PreparedStatement ps5 =connection.prepareStatement("update Products set quantity=? where product_id=2");
						ps5.setInt(1,updated_Qty );
						ps5.execute();
				       System.out.println("Done");
						//connection.close();
					}
						
					catch (Exception e)
					{
						
						System.out.println(e);
					}
					}
					
					else
					{
						System.out.println("Please enter only registered mobile number");
						System.exit(0);
					}
					
					System.out.println("----------------------------------------------------------------------------------");
					System.out.println("Enter 1:- Buy Now");
					System.out.println("Enter 2:- Add more to cart");
					System.out.println("Enter 3:- See Your cart");
					int ch=scn.nextInt();
					switch(ch)
					{
					case 1:
						b.buy();
						
						break;
						
					case 2:
						addCart();
						break;
						
					case 3:
						seeYourCart();
						break;
					
					}
					
					
				}
				else
				{
					System.out.println(" Camera is Out Of Stock");
				
				}
			   
			   
		    break;
		/******************************************************************************************************************/	
		   case 3:
			   System.out.println("Number Of Quantities:- ");
				int qnt2= scn.nextInt();
				int max_quantity2=1000;
				if(max_quantity2>=qnt2)
				{
	                ArrayList<Long> al= new ArrayList<Long>();
					
					String sql="select mobile_number from User";
					Statement ps=connection.createStatement();
					ResultSet rs = ps.executeQuery(sql);
					while(rs.next())
					{
						al.add(rs.getLong(1));
						
					}
					if(al.contains(mob))
					{
					
					int amt=4000;
					int total_amt=amt*qnt2;
					int main_qty=0;
					System.out.println("Your total Amount= " +total_amt);
					
					PreparedStatement ps2= connection.prepareStatement("insert into add_to_cart(mobile_number,product_name,product_quantity,total_amount) values(?,?,?,?)");
					ps2.setLong(1, mob);
					ps2.setString(2, "Celling_Fan");
					ps2.setInt(3, qnt2);
					ps2.setInt(4, total_amt);
					ps2.executeUpdate();
					System.out.println("Celling_Fan is added to cart successfully");
					
					
					try {
		                  PreparedStatement ps1 =connection.prepareStatement("insert into purchaseList( mobile_number,Celling_Fan) values(?,?)");
						
						ps1.setLong(1, mob);
						ps1.setInt(2,qnt2);

			            
			            PreparedStatement ps3 = connection.prepareStatement("update purchaseList set Celling_Fan=? where mobile_number=?");
			            ps3.setInt(1, qnt2);
			            ps3.setLong(2, mob);
						if( compare.compare(mob)) {
							ps3.execute();
							ps3.close();
							
						}
						else {
							ps1.execute();
							ps1.close();
						}
						
			            
					   PreparedStatement ps4 =connection.prepareStatement("select quantity from Products where product_id=3");
						ResultSet rs1=ps4.executeQuery();
						while(rs1.next()) {
							 main_qty=rs1.getInt(1);
						}
						
		                int updated_Qty= main_qty-qnt2;
						
						PreparedStatement ps5 =connection.prepareStatement("update Products set quantity=? where product_id=3");
						ps5.setInt(1,updated_Qty );
						ps5.execute();
				       System.out.println("Done");
						//connection.close();
						
					} catch (Exception e) {
						
						System.out.println(e);
					}
					}
					
					else
					{
						System.out.println("Please enter only registered mobile number");
						System.exit(0);
					}
					
					System.out.println("----------------------------------------------------------------------------------");
					System.out.println("Enter 1:- Buy Now");
					System.out.println("Enter 2:- Add more to cart");
					System.out.println("Enter 3:- See Your cart");
					int ch=scn.nextInt();
					switch(ch)
					{
					case 1:
						b.buy();
						
						break;
						
					case 2:
						addCart();
						break;
						
					case 3:
						seeYourCart();
						break;
					
					}
					
					
				}
				else
				{
					System.out.println(" Ceiling_Fan is Out Of Stock");
				
				}
			   
		   break;
		 /*******************************************************************************************************************/
		   
		   case 4:
			   System.out.println("Number Of Quantities:- ");
				int qnt3= scn.nextInt();
				int max_quantity3=1000;
				if(max_quantity3>=qnt3)
				{
	                ArrayList<Long> al= new ArrayList<Long>();
					
					String sql="select mobile_number from User";
					Statement ps=connection.createStatement();
					ResultSet rs = ps.executeQuery(sql);
					while(rs.next())
					{
						al.add(rs.getLong(1));
						
					}
					if(al.contains(mob))
					{
					
					int amt=25000;
					int total_amt=amt*qnt3;
					int main_qty=0;
					System.out.println("Your total Amount= " +total_amt);
					
					PreparedStatement ps2= connection.prepareStatement("insert into add_to_cart(mobile_number,product_name,product_quantity,total_amount) values(?,?,?,?)");
					ps2.setLong(1, mob);
					ps2.setString(2, "Cooler");
					ps2.setInt(3, qnt3);
					ps2.setInt(4, total_amt);
					ps2.executeUpdate();
					System.out.println("Cooler is added to cart successfully");
					
					
					try {
		                  PreparedStatement ps1 =connection.prepareStatement("insert into purchaseList( mobile_number,Cooler) values(?,?)");
						
						ps1.setLong(1, mob);
						ps1.setInt(2,qnt3);

			            
			            PreparedStatement ps3 = connection.prepareStatement("update purchaseList set Cooler=? where mobile_number=?");
			            ps3.setInt(1, qnt3);
			            ps3.setLong(2, mob);
						if( compare.compare(mob)) {
							ps3.execute();
							ps3.close();
							
						}
						else {
							ps1.execute();
							ps1.close();
						}
							
						
			            
					    PreparedStatement ps4 =connection.prepareStatement("select quantity from Products where product_id=4");
						ResultSet rs1=ps4.executeQuery();
						while(rs1.next()) {
							 main_qty=rs1.getInt(1);
						}
						
		                int updated_Qty= main_qty-qnt3;
						
						PreparedStatement ps5 =connection.prepareStatement("update Products set quantity=? where product_id=4");
						ps5.setInt(1,updated_Qty );
						ps5.execute();
				       System.out.println("Done");
						//connection.close();
						
					} catch (Exception e) {
						
						System.out.println(e);
					}
					}
					
					else
					{
						System.out.println("Please enter only registered mobile number");
						System.exit(0);
					}
					
					System.out.println("----------------------------------------------------------------------------------");
					System.out.println("Enter 1:- Buy Now");
					System.out.println("Enter 2:- Add more to cart");
					System.out.println("Enter 3:- See Your cart");
					int ch=scn.nextInt();
					switch(ch)
					{
					case 1:
						b.buy();
						
						break;
						
					case 2:
						addCart();
						break;
						
					case 3:
						seeYourCart();
						break;
					
					}
					
					
				}
				else
				{
					System.out.println(" Cooler is Out Of Stock");
				
				}
			   
			break;
		/*********************************************************************************************************************/
		   case 5:
			   System.out.println("Number Of Quantities:- ");
				int qnt4= scn.nextInt();
				int max_quantity4=1000;
				if(max_quantity4>=qnt4)
				{
	                ArrayList<Long> al= new ArrayList<Long>();
					
					String sql="select mobile_number from User";
					Statement ps=connection.createStatement();
					ResultSet rs = ps.executeQuery(sql);
					while(rs.next())
					{
						al.add(rs.getLong(1));
						
					}
					if(al.contains(mob))
					{
					
					int amt=65000;
					int total_amt=amt*qnt4;
					int main_qty=0;
					System.out.println("Your total Amount= " +total_amt);
					
					PreparedStatement ps2= connection.prepareStatement("insert into add_to_cart(mobile_number,product_name,product_quantity,total_amount) values(?,?,?,?)");
					ps2.setLong(1, mob);
					ps2.setString(2, "Laptop");
					ps2.setInt(3, qnt4);
					ps2.setInt(4, total_amt);
					ps2.executeUpdate();
					System.out.println("Laptop is added to cart successfully");
					
					
					try {
		                  PreparedStatement ps1 =connection.prepareStatement("insert into purchaseList( mobile_number,Laptop) values(?,?)");
						
						ps1.setLong(1, mob);
						ps1.setInt(2,qnt4);

			            
			            PreparedStatement ps3 = connection.prepareStatement("update purchaseList set Laptop=? where mobile_number=?");
			            ps3.setInt(1, qnt4);
			            ps3.setLong(2, mob);
						if( compare.compare(mob)) {
							ps3.execute();
							ps3.close();
							
						}
						else {
							ps1.execute();
							ps1.close();
							}
						
						
					 
					    PreparedStatement ps4 =connection.prepareStatement("select quantity from Products where product_id=5");
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
						
					} catch (Exception e) {
						
						System.out.println(e);
					}
					}
					
					else
					{
						System.out.println("Please enter only registered mobile number");
						System.exit(0);
					}
					
					System.out.println("----------------------------------------------------------------------------------");
					System.out.println("Enter 1:- Buy Now");
					System.out.println("Enter 2:- Add more to cart");
					System.out.println("Enter 3:- See Your cart");
					int ch=scn.nextInt();
					switch(ch)
					{
					case 1:
						b.buy();
						
						break;
						
					case 2:
						addCart();
						break;
						
					case 3:
						seeYourCart();
						break;
					
					}
					
					
				}
				else
				{
					System.out.println(" Laptop is Out Of Stock");
				
				}
			   
		   break;
		/*********************************************************************************************************************/
		
		   case 6:
			   
			   System.out.println("Number Of Quantities:- ");
				int qnt5= scn.nextInt();
				int max_quantity5=1000;
				if(max_quantity5>=qnt5)
				{
	                ArrayList<Long> al= new ArrayList<Long>();
					
					String sql="select mobile_number from User";
					Statement ps=connection.createStatement();
					ResultSet rs = ps.executeQuery(sql);
					while(rs.next())
					{
						al.add(rs.getLong(1));
						
					}
					if(al.contains(mob))
					{
					
					int amt=50000;
					int total_amt=amt*qnt5;
					int main_qty=0;
					System.out.println("Your total Amount= " +total_amt);
					
					PreparedStatement ps2= connection.prepareStatement("insert into add_to_cart(mobile_number,product_name,product_quantity,total_amount) values(?,?,?,?)");
					ps2.setLong(1, mob);
					ps2.setString(2, "LED_TV");
					ps2.setInt(3, qnt5);
					ps2.setInt(4, total_amt);
					ps2.executeUpdate();
					System.out.println("LED TV is added to cart successfully");
					
					
					try {
		                  PreparedStatement ps1 =connection.prepareStatement("insert into purchaseList(mobile_number,LED_TV) values(?,?)");
						
						ps1.setLong(1, mob);
						ps1.setInt(2,qnt5);

			            
			            PreparedStatement ps3 = connection.prepareStatement("update purchaseList set LED_TV=? where mobile_number=?");
			            ps3.setInt(1, qnt5);
			            ps3.setLong(2, mob);
						if( compare.compare(mob)) {
							ps3.execute();
							ps3.close();
							
						}
						else {
							ps1.execute();
							ps1.close();
							}
						 PreparedStatement ps4 =connection.prepareStatement("select quantity from Products where product_id=6");
							ResultSet rs1=ps4.executeQuery();
							while(rs1.next()) {
								 main_qty=rs1.getInt(1);
							}
							
			                int updated_Qty= main_qty-qnt5;
							
							PreparedStatement ps5 =connection.prepareStatement("update Products set quantity=? where product_id=6");
							ps5.setInt(1,updated_Qty );
							ps5.execute();
					       System.out.println("Done");
							//connection.close();
						
						}
                         catch (Exception e) {
						
						System.out.println(e);
					}
					}
					
					else
					{
						System.out.println("Please enter only registered mobile number");
						System.exit(0);
					}
					
					System.out.println("----------------------------------------------------------------------------------");
					System.out.println("Enter 1:- Buy Now");
					System.out.println("Enter 2:- Add more to cart");
					System.out.println("Enter 3:- See Your cart");
					int ch=scn.nextInt();
					switch(ch)
					{
					case 1:
						b.buy();
						
						break;
						
					case 2:
						addCart();
						break;
						
					case 3:
						seeYourCart();
						break;
					
					}
					
					
				}
				else
				{
					System.out.println(" LED_TV is Out Of Stock");
				
				}
			   
		    break;
	    /*********************************************************************************************************************/
		   case 7:
			   
			   System.out.println("Number Of Quantities:- ");
				int qnt6= scn.nextInt();
				int max_quantity6=1000;
				if(max_quantity6>=qnt6)
				{
	                ArrayList<Long> al= new ArrayList<Long>();
					
					String sql="select mobile_number from User";
					Statement ps=connection.createStatement();
					ResultSet rs = ps.executeQuery(sql);
					while(rs.next())
					{
						al.add(rs.getLong(1));
						
					}
					if(al.contains(mob))
					{
					
					int amt=15000;
					int total_amt=amt*qnt6;
					int main_qty=0;
					System.out.println("Your total Amount= " +total_amt);
					
					PreparedStatement ps2= connection.prepareStatement("insert into add_to_cart(mobile_number,product_name,product_quantity,total_amount) values(?,?,?,?)");
					ps2.setLong(1, mob);
					ps2.setString(2, "Mobile");
					ps2.setInt(3, qnt6);
					ps2.setInt(4, total_amt);
					ps2.executeUpdate();
					System.out.println("LED_TV is added to cart successfully");
					
					
					try {
		                  PreparedStatement ps1 =connection.prepareStatement("insert into purchaseList( mobile_number,Mobile) values(?,?)");
						
						ps1.setLong(1, mob);
						ps1.setInt(2,qnt6);

			            
			            PreparedStatement ps3 = connection.prepareStatement("update purchaseList set Mobile=? where mobile_number=?");
			            ps3.setInt(1, qnt6);
			            ps3.setLong(2, mob);
						if( compare.compare(mob)) {
							ps3.execute();
							ps3.close();
							
						}
						else {
							ps1.execute();
							ps1.close();
							}
						
						 PreparedStatement ps4 =connection.prepareStatement("select quantity from Products where product_id=7");
							ResultSet rs1=ps4.executeQuery();
							while(rs1.next()) {
								 main_qty=rs1.getInt(1);
							}
							
			                int updated_Qty= main_qty-qnt6;
							
							PreparedStatement ps5 =connection.prepareStatement("update Products set quantity=? where product_id=7");
							ps5.setInt(1,updated_Qty );
							ps5.execute();
					       System.out.println("Done");
							//connection.close();
							
						}
                        catch (Exception e) {
						
						System.out.println(e);
					}
					}
					
					else
					{
						System.out.println("Please enter only registered mobile number");
						System.exit(0);
					}
					
					System.out.println("----------------------------------------------------------------------------------");
					System.out.println("Enter 1:- Buy Now");
					System.out.println("Enter 2:- Add more to cart");
					System.out.println("Enter 3:- See Your cart");
					int ch=scn.nextInt();
					switch(ch)
					{
					case 1:
						b.buy();
						
						break;
						
					case 2:
						addCart();
						break;
						
					case 3:
						seeYourCart();
						break;
					
					}
					
					
				}
				else
				{
					System.out.println(" Mobile is Out Of Stock");
				
				}
			   
		   break;
	    /*********************************************************************************************************************/
		   case 8:
			   
			   System.out.println("Number Of Quantities:- ");
				int qnt7= scn.nextInt();
				int max_quantity7=1000;
				if(max_quantity7>=qnt7)
				{
	                ArrayList<Long> al= new ArrayList<Long>();
					
					String sql="select mobile_number from User";
					Statement ps=connection.createStatement();
					ResultSet rs = ps.executeQuery(sql);
					while(rs.next())
					{
						al.add(rs.getLong(1));
						
					}
					if(al.contains(mob))
					{
					
					int amt=18000;
					int total_amt=amt*qnt7;
					int main_qty=0;
					System.out.println("Your total Amount= " +total_amt);
					
					PreparedStatement ps2= connection.prepareStatement("insert into add_to_cart(mobile_number,product_name,product_quantity,total_amount) values(?,?,?,?)");
					ps2.setLong(1, mob);
					ps2.setString(2, "Oven");
					ps2.setInt(3, qnt7);
					ps2.setInt(4, total_amt);
					ps2.executeUpdate();
					System.out.println("Oven is added to cart successfully");
					
					
					try {
		                  PreparedStatement ps1 =connection.prepareStatement("insert into purchaseList( mobile_number,Oven) values(?,?)");
						
						ps1.setLong(1, mob);
						ps1.setInt(2,qnt7);

			            
			            PreparedStatement ps3 = connection.prepareStatement("update purchaseList set Oven=? where mobile_number=?");
			            ps3.setInt(1, qnt7);
			            ps3.setLong(2, mob);
						if( compare.compare(mob)) {
							ps3.execute();
							ps3.close();
							
						}
						else {
							ps1.execute();
							ps1.close();
							}
						
						 PreparedStatement ps4 =connection.prepareStatement("select quantity from Products where product_id=8");
							ResultSet rs1=ps4.executeQuery();
							while(rs1.next()) {
								 main_qty=rs1.getInt(1);
							}
							
			                int updated_Qty= main_qty-qnt7;
							
							PreparedStatement ps5 =connection.prepareStatement("update Products set quantity=? where product_id=8");
							ps5.setInt(1,updated_Qty );
							ps5.execute();
					       System.out.println("Done");
							//connection.close();
							
						}
                       catch (Exception e) {
						
						System.out.println(e);
					}
					}
					
					else
					{
						System.out.println("Please enter only registered mobile number");
						System.exit(0);
					}
					
					System.out.println("----------------------------------------------------------------------------------");
					System.out.println("Enter 1:- Buy Now");
					System.out.println("Enter 2:- Add more to cart");
					System.out.println("Enter 3:- See Your cart");
					int ch=scn.nextInt();
					switch(ch)
					{
					case 1:
						b.buy();
						
						break;
						
					case 2:
						addCart();
						break;
						
					case 3:
						seeYourCart();
						break;
					
					}
					
					
				}
				else
				{
					System.out.println(" Oven is Out Of Stock");
				
				}
			   
		   break;
	    /*********************************************************************************************************************/
		   case 9:
			   
			   System.out.println("Number Of Quantities:- ");
				int qnt8= scn.nextInt();
				int max_quantity8=1000;
				if(max_quantity8>=qnt8)
				{
	                ArrayList<Long> al= new ArrayList<Long>();
					
					String sql="select mobile_number from User";
					Statement ps=connection.createStatement();
					ResultSet rs = ps.executeQuery(sql);
					while(rs.next())
					{
						al.add(rs.getLong(1));
						
					}
					if(al.contains(mob))
					{
					
					int amt=35000;
					int total_amt=amt*qnt8;
					int main_qty=0;
					System.out.println("Your total Amount= " +total_amt);
					
					PreparedStatement ps2= connection.prepareStatement("insert into add_to_cart(mobile_number,product_name,product_quantity,total_amount) values(?,?,?,?)");
					ps2.setLong(1, mob);
					ps2.setString(2, "Refrigerator");
					ps2.setInt(3, qnt8);
					ps2.setInt(4, total_amt);
					ps2.executeUpdate();
					System.out.println("Refrigerator is added to cart successfully");
					
					
					try {
		                  PreparedStatement ps1 =connection.prepareStatement("insert into purchaseList( mobile_number,Refrigerator) values(?,?)");
						
						ps1.setLong(1, mob);
						ps1.setInt(2,qnt8);

			            
			            PreparedStatement ps3 = connection.prepareStatement("update purchaseList set Refrigerator=? where mobile_number=?");
			            ps3.setInt(1, qnt8);
			            ps3.setLong(2, mob);
						if( compare.compare(mob)) {
							ps3.execute();
							ps3.close();
							
						}
						else {
							ps1.execute();
							ps1.close();
							}
						
						 PreparedStatement ps4 =connection.prepareStatement("select quantity from Products where product_id=9");
							ResultSet rs1=ps4.executeQuery();
							while(rs1.next()) {
								 main_qty=rs1.getInt(1);
							}
							
			                int updated_Qty= main_qty-qnt8;
							
							PreparedStatement ps5 =connection.prepareStatement("update Products set quantity=? where product_id=9");
							ps5.setInt(1,updated_Qty );
							ps5.execute();
					       System.out.println("Done");
							//connection.close();
							
						}
                      catch (Exception e) {
						
						System.out.println(e);
					}
					}
					
					else
					{
						System.out.println("Please enter only registered mobile number");
						System.exit(0);
					}
					
					System.out.println("----------------------------------------------------------------------------------");
					System.out.println("Enter 1:- Buy Now");
					System.out.println("Enter 2:- Add more to cart");
					System.out.println("Enter 3:- See Your cart");
					int ch=scn.nextInt();
					switch(ch)
					{
					case 1:
						b.buy();
						
						break;
						
					case 2:
						addCart();
						break;
						
					case 3:
						seeYourCart();
						break;
					
					}
					
					
				}
				else
				{
					System.out.println(" Refrigerator is Out Of Stock");
				
				}
			   
		   break;
		/*********************************************************************************************************************/
		   case 10:
			   
			   System.out.println("Number Of Quantities:- ");
				int qnt9= scn.nextInt();
				int max_quantity9=1000;
				if(max_quantity9>=qnt9)
				{
	                ArrayList<Long> al= new ArrayList<Long>();
					
					String sql="select mobile_number from User";
					Statement ps=connection.createStatement();
					ResultSet rs = ps.executeQuery(sql);
					while(rs.next())
					{
						al.add(rs.getLong(1));
						
					}
					if(al.contains(mob))
					{
					
					int amt=38000;
					int total_amt=amt*qnt9;
					int main_qty=0;
					System.out.println("Your total Amount= " +total_amt);
					
					PreparedStatement ps2= connection.prepareStatement("insert into add_to_cart(mobile_number,product_name,product_quantity,total_amount) values(?,?,?,?)");
					ps2.setLong(1, mob);
					ps2.setString(2,"Washing_Machine");
					ps2.setInt(3, qnt9);
					ps2.setInt(4, total_amt);
					ps2.executeUpdate();
					System.out.println("Washing Machine is added to cart successfully");
					
					
					try {
		                  PreparedStatement ps1 =connection.prepareStatement("insert into purchaseList( mobile_number,Washing_Machine) values(?,?)");
						
						ps1.setLong(1, mob);
						ps1.setInt(2,qnt9);

			            
			            PreparedStatement ps3 = connection.prepareStatement("update purchaseList set Washing_Machine=? where mobile_number=?");
			            ps3.setInt(1, qnt9);
			            ps3.setLong(2, mob);
						if( compare.compare(mob)) {
							ps3.execute();
							ps3.close();
							
						}
						else {
							ps1.execute();
							ps1.close();
							}
						
						 PreparedStatement ps4 =connection.prepareStatement("select quantity from Products where product_id=10");
							ResultSet rs1=ps4.executeQuery();
							while(rs1.next()) {
								 main_qty=rs1.getInt(1);
							}
							
			                int updated_Qty= main_qty-qnt9;
							
							PreparedStatement ps5 =connection.prepareStatement("update Products set quantity=? where product_id=10");
							ps5.setInt(1,updated_Qty );
							ps5.execute();
					       System.out.println("Done");
							//connection.close();
							
						}
                     catch (Exception e) {
						
						System.out.println(e);
					}
					}
					
					else
					{
						System.out.println("Please enter only registered mobile number");
						System.exit(0);
					}
					
					System.out.println("----------------------------------------------------------------------------------");
					System.out.println("Enter 1:- Buy Now");
					System.out.println("Enter 2:- Add more to cart");
					System.out.println("Enter 3:- See Your cart");
					int ch=scn.nextInt();
					switch(ch)
					{
					case 1:
						b.buy();
						
						break;
						
					case 2:
						addCart();
						break;
						
					case 3:
						seeYourCart();
						break;
					
					}
					
					
				}
				else
				{
					System.out.println(" Washing Machine is Out Of Stock");
				
				}
			   
		    break;
		/*********************************************************************************************************************/

		
		
		default: 
			System.out.println("Please enter valid Input");
			break;
		
		
		
		}
		
		
	}
/***************************************************************************************************************************/	
	
	void seeYourCart() throws Exception
	{
		//BuyProduct bp=new BuyProduct();
		Scanner scanner=new Scanner(System.in);
		JdbcConnection connectionobj =new  JdbcConnection();
		Connection connection =connectionobj.getConnectionDetails();
		
		System.out.println("Enter your registered mobile number:- ");
		long no=scanner.nextLong();
		
		ArrayList<Long> al1=new ArrayList<Long>();
		String qr="select mobile_number from add_to_cart";
		Statement ps2=connection.createStatement();
		ResultSet rs1=ps2.executeQuery(qr);
		while(rs1.next())
		{
			//long num=rs1.getLong(1);
			al1.add(rs1.getLong(1));
		}
		if(al1.contains(no))
		{
			//ArrayList al2=new ArrayList();
		try
		{
			//Statement ps3=connection.createStatement();
			PreparedStatement ps5=connection.prepareStatement("select * from add_to_cart where mobile_number = ?");
			ps5.setLong(1, no);
			ResultSet rs2=ps5.executeQuery();
			
		
			while(rs2.next())
			{
				
			System.out.print("Product Name:- "+rs2.getString(2));	
			System.out.print("   Quantity:- "+	rs2.getInt(3));
		    System.out.println("  Total Amount:- "+rs2.getLong(4));
			}
			System.out.println("---------------------------------------------------------------");
			System.out.println("Press 1 to buy the products:-");
			Scanner scnn=new Scanner(System.in);
			int ch=scnn.nextInt();
			switch(ch)
			{
			case 1:
				b.buy();
				break;
				default:
					System.out.println("Enter valid Input");
					break;
			
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
			
		}
		

	}
}
