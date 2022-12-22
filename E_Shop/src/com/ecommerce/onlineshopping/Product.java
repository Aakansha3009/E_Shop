package com.ecommerce.onlineshopping;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import com.mysql.cj.protocol.Resultset;

public class Product implements ProductInterface 
{
	Scanner scanner = new Scanner(System.in);
	JdbcConnection connectionobj =new  JdbcConnection();
	Connection connection =connectionobj.getConnectionDetails();
	
	public void displayProductList() 
	{
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.printf("%1s %10s %25s %20s","Sr.No","NAME","DESCRIPTION","PRICE\n");
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.printf("%1s %11s %30s %21s","1","AC","Dust_Filter_3*","60,000 Rs\n");
		System.out.printf("%1s %15s %25s %22s","2","Camera","1080p_Full_HD","45,000 Rs\n");
		System.out.printf("%1s %20s %25s %17s","3","Celling_Fan","High_speed_3_Blade","4,000 Rs\n");
		System.out.printf("%1s %15s %26s %21s","4","Cooler","34_Litre_White","25,000 Rs\n");
		System.out.printf("%1s %15s %28s %19s","5","Laptop","Core_i5_10th_gen","65,000 Rs\n");
		System.out.printf("%1s %15s %22s %25s","6","LED_TV","52_inch_4K","50,000 Rs\n");
		System.out.printf("%1s %15s %33s %14s","7","Mobile","6GB_Ram 128GB_Storage","15,000 Rs\n");
		System.out.printf("%1s %13s %32s %17s","8","Oven","1800w_Temp_Control","18,000 Rs\n");
		System.out.printf("%1s %21s %20s %21s","9","Refrigerator","Duble_Door_5*","35,000 Rs\n");
		System.out.printf("%1s %24s %16s %22s","10","Washing Machine","Front_Load_5*","38,000 Rs\n");
		System.out.print("----------------------------------------------------------------------------------------");
		System.out.println("");
        //buyProducts();
	}
}

/* 
	 public void buyProducts() 
	
	{
		Compare compare=new Compare();
		
		System.out.println("Enter Sr.No to buy respective product [Enter 0 for Exit!!!]: ");
		
		int serialNumber=scanner.nextInt();
		long mobileNumber;
		
		switch(serialNumber) 
		{	
			case 1:
			System.out.println("Led_Tv added to cart!");
			System.out.println("Number of Quantities Requried : ");
			int quantity=scanner.nextInt();
			int maxQty=1000;
			int updatedValue;
			if(maxQty>=quantity) 
			{
				System.out.print("Enter Your Registered Number For Purchasing : ");
				mobileNumber = scanner.nextLong();

				int Amount=50000;
				int totalAmount=Amount*quantity;
				int Updatedvalue=0;
				int main_qty=0;
		    
				System.out.print("Your Total Amount Is : "+totalAmount);
				System.out.println("Enter Your Mode Of Payment:\n1.Cash On Delivery\n2.Card Payment");
				int payment=scanner.nextInt();
				switch(payment) 
				{
					case 1:System.out.println("Thank You For Purchasing!!!");
					break;
		 
					case 2:System.out.println("Thank You for Purchasing!");   //Ask abt this why case 2 is here
					//break;
				}
				try 
				{
                  PreparedStatement ps =connection.prepareStatement("insert into purchaseList(mobile_number,LED_TV)values(?,?)");
				
                  ps.setLong(1, mobileNumber);
                  ps.setInt(2,quantity);

                  PreparedStatement ps3 = connection.prepareStatement("update purchaseList set LED_TV=?where mobile_number=?");
                  ps3.setInt(1, quantity);
                  ps3.setLong(2, mobileNumber);
                  if( compare.compare(mobileNumber)) 
                  {
					ps3.execute();
					ps3.close();
                  }
                  else 
                  {
					ps.execute();
					ps.close();
                  }  
                  PreparedStatement ps1 =connection.prepareStatement("select quantity from Products where product_id=1");
                  ResultSet rs=ps1.executeQuery();
                  while(rs.next()) 
                  {
					 main_qty=rs.getInt(1);
                  }
                  int updated_Qty= main_qty-quantity;
				
                  PreparedStatement ps2 =connection.prepareStatement("update Products set quantity=? where product_id=1");
                  ps2.setInt(1,updated_Qty );
                  ps2.execute();
                  System.out.println("Your payment mode has being selected successfully");
                  //connection.close();
			} 
			catch(SQLException e) 
			{
				System.out.println(e);
			}	
		}
		displayProductList();
		break;
			
			
		case 2:
			System.out.println("Refrigerator added to cart!");
			System.out.println("Number of Quantities Requried : ");
			int quantity2=scanner.nextInt();
			int maxQty2=5;
			int updatedValue2;
			if(maxQty2>=quantity2) 
			{
				System.out.print("Enter Your Registered Number For Purchasing : ");
				mobileNumber = scanner.nextLong();
				int Amount2=35000;
				int totalAmount2=Amount2*quantity2;
				int Updatedvalue2=0;
				int main_qty2=0;
				System.out.println("Your Total Amount Is : "+totalAmount2);
				System.out.println("Enter Your Mode Of Payment:\n1.Cash On Delivery\n2.Card Payment");
				int payment=scanner.nextInt();
				switch(payment) 
				{
				case 1:
					System.out.println("Thank You For Purchasing!!!");
					break;
		   
				case 2:
					System.out.println("Thank You for Purchasing!");
					//break;
			 }
		   try 
		   {
                PreparedStatement ps=connection.prepareStatement("insert into purchaseList(mobile_number,Refrigerator)values(?,?)");
				
				ps.setLong(1,mobileNumber);
				ps.setInt(2,quantity2);
     
	            PreparedStatement ps3=connection.prepareStatement("update purchaseList set Refrigerator=? where mobile_number=?");
	            ps3.setInt(1,quantity2);
	            ps3.setLong(2,mobileNumber);
				if(compare.compare(mobileNumber)) 
				{
					ps3.execute();
					ps3.close();	
				}
				else 
				{
					ps.execute();
					ps.close();	
				}
	            PreparedStatement ps1 =connection.prepareStatement("select quantity from Products where product_id=2");
				ResultSet rs=ps1.executeQuery();
				while(rs.next()) 
				{
					 main_qty2=rs.getInt(1);
				}
				
                int updated_Qty2= main_qty2-quantity2;
				
				PreparedStatement ps2=connection.prepareStatement("update Products set quantity=? where product_id=2");
				ps2.setInt(1,updated_Qty2 );
				ps2.execute();
		        System.out.println("Your payment mode has being selected successfully");
				//connection.close();	
			} 
		    catch(SQLException e) 
		    {	
				e.printStackTrace();
			}	
		}
		displayProductList();
		break;
				
		case 3:			
		System.out.println("Washing_Machine added to cart!");
		System.out.print("Number of Quantities Requried : ");
		int quantity3=scanner.nextInt();
		int maxQty3=10000;
		int updatedValue3;
    	if(maxQty3>=quantity3) 
    	{
    		System.out.print("Enter Your Registered Number For Purchasing : ");
    		mobileNumber = scanner.nextLong();
    		int Amount3=42000;
    		int totalAmount3=Amount3*quantity3;
    		int Updatedvalue3=0;
    		int main_qty3=0;
    		System.out.println("Your Total Amount Is="+totalAmount3);
    		System.out.println("Enter Your Mode Of Payment:\n1.Cash On Delivery\n2.Card Payment");
    		int payment=scanner.nextInt();
    		switch(payment) 
    		{
    			case 1: System.out.println("Thank You For Purchasing!!");
    			break;
    			case 2: System.out.println("Thank You for Purchasing!");
    			//break;
    		}
    		try 
    		{
    			PreparedStatement ps =connection.prepareStatement("insert into purchaseList(mobile_number,Washing_Machine)values(?,?)");
			
    			ps.setLong(1, mobileNumber);
    			ps.setInt(2,quantity3 );

    			PreparedStatement ps3 = connection.prepareStatement("update purchaseList set Washing_Machine=? where mobile_number=?");
    			ps3.setInt(1, quantity3);
    			ps3.setLong(2, mobileNumber);
    			if(compare.compare(mobileNumber)) 
    			{
    				ps3.execute();	
    			}
    			else 
    			{
    				ps.execute();
    				ps.close();	
    			}
    			PreparedStatement ps1 =connection.prepareStatement("select quantity from Products where product_id=3");
    			ResultSet rs=ps1.executeQuery();
    			while(rs.next()) 
    			{
    				main_qty3=rs.getInt(1);
    			}	
    			int updated_Qty3= main_qty3-quantity3;
			
    			PreparedStatement ps2 =connection.prepareStatement("update Products set quantity=? where product_id=3");
    			ps2.setInt(1,updated_Qty3 );
    			ps2.execute();
    			System.out.println("Your payment mode has being selected successfully");
    			//connection.close();
    		} 
    		catch(SQLException e) 
    		{	
    			e.printStackTrace();
    		}
    	}
    	displayProductList();
    	break;
			
		case 4:
			System.out.println("Laptop added to cart!");
			System.out.print("Number of Quantities Requried : ");
			int quantity4=scanner.nextInt();
			int maxQty4=10000;
			int updatedValue4;
			if(maxQty4>=quantity4) 
			{
				System.out.print("Enter Your Registered Number For Purchasing :");
				mobileNumber = scanner.nextLong();
				int Amount4=65000;
				int totalAmount4=Amount4*quantity4;
				int Updatedvalue4=0;
				int main_qty4=0;
				System.out.print("Your Total Amount Is : "+totalAmount4);
				System.out.println("Enter Your Mode Of Payment:\n1.Cash On Delivery\n2.Card Payment");
				int payment=scanner.nextInt();
				switch(payment) 
				{
					case 1:System.out.println("Thank You For Purchasing!!");
					break;
					
					case 2:System.out.println("Thank You for Purchasing!");
					//break;
				}
				try 
				{
					PreparedStatement ps =connection.prepareStatement("insert into purchaseList( mobile_number,Laptop) values(?,?)");
				
					ps.setLong(1,mobileNumber);
					ps.setInt(2,quantity4 );

					PreparedStatement ps3 = connection.prepareStatement("update purchaseList set Laptop=? where mobile_number=?");
					ps3.setInt(1, quantity4);
					ps3.setLong(2, mobileNumber);
					if(compare.compare(mobileNumber)) 
					{
						ps3.execute();
					}
					else 
					{
						ps.execute();
						ps.close();	
				}
	            
				PreparedStatement ps1 =connection.prepareStatement("select quantity from Products where product_id=4");
				ResultSet rs=ps1.executeQuery();
				while(rs.next()) 
				{
					 main_qty4=rs.getInt(1);
				}
				
                int updated_Qty4= main_qty4-quantity4;
				
				PreparedStatement ps2 =connection.prepareStatement("update Products set quantity=? where product_id=4");
				ps2.setInt(1,updated_Qty4 );
				ps2.execute();
				System.out.println("Your payment mode has being selected successfully");  //Check here 
				//connection.close();	
			} 
			catch(SQLException e) 
			{	
				e.printStackTrace();
			}
		}
		displayProductList();
		break ;
		
		case 5:
			System.out.println("Oven added to cart!");
			System.out.print("Number of Quantities Requried : ");
			int quantity5=scanner.nextInt();
			int maxQty5=10000;
			int updatedValue5;
			if(maxQty5>=quantity5) 
			{
			
				System.out.print("Enter Your Registered Number For Purchasing :");
				mobileNumber = scanner.nextLong();
				int Amount5=10000;
				int totalAmount5=Amount5*quantity5;
				int Updatedvalue5=0;
				int main_qty5=0;
				System.out.print("Your Total Amount Is="+totalAmount5);
				System.out.println("Enter Your Mode Of Payment:\n1.Cash On Delivery\n2.Card Payment");
				int payment=scanner.nextInt();
				switch(payment) 
				{
					case 1: System.out.println("Thank You For Purchasing!!");
					break;
					
					case 2: System.out.println("Thank You for Purchasing!");
					//break;
		        } 
			    try 
			    {
			    	PreparedStatement ps =connection.prepareStatement("insert into purchaseList( mobile_number,Oven) values(?,?)");
				
			    	ps.setLong(1, mobileNumber);
			    	ps.setInt(2,quantity5);

			    	PreparedStatement ps3 = connection.prepareStatement("update purchaseList set Oven=? where mobile_number=?");
			    	ps3.setInt(1, quantity5);
			    	ps3.setLong(2, mobileNumber);
			    	if(compare.compare(mobileNumber)) 
			    	{
			    		ps3.execute();
			    	}
			    	else 
			    	{
			    		ps.execute();
			    		ps.close();	
			    	}
	            
			    	PreparedStatement ps1 =connection.prepareStatement("select quantity from Products where product_id=5");
			    	ResultSet rs=ps1.executeQuery();
			    	while(rs.next()) 
			    	{
			    		main_qty5=rs.getInt(1);
			    	}
			    	int updated_Qty5= main_qty5-quantity5;
				
			    	PreparedStatement ps2 =connection.prepareStatement("update Products set quantity=? where product_id=5");
			    	ps2.setInt(1,updated_Qty5 );
			    	ps2.execute();
			    	System.out.println("Your payment mode has being selected successfully");
			    	//connection.close();
			} 
			catch(SQLException e) 
			{
				
				e.printStackTrace();
			}
		}
		displayProductList();
		break;
			
		case 6:
			System.out.println("Ac added to cart!");
			System.out.print("Number of Quantities Requried:");
			int quantity6=scanner.nextInt();
			int maxQty6=10000;
			int updatedValue6;
			if(maxQty6>=quantity6) 
			{
				System.out.print("Enter Your Registered Number For Purchasing :");
				mobileNumber = scanner.nextLong();
				int Amount6=30000;
				int totalAmount6=Amount6*quantity6;
				int Updatedvalue6=0;
				int main_qty6=0;
				System.out.print("Your Total Amount Is : "+totalAmount6);
				System.out.println("Enter Your Mode Of Payment:\n1.Cash On Delivery\n2.Card Payment");
				int payment=scanner.nextInt();
				switch(payment) 
				{
					case 1: System.out.println("Thank You For Purchasing!!");
			        break;
		   
					case 2: System.out.println("Thank You for Purchasing!");
					//break;
				}
				try 
				{
					PreparedStatement ps =connection.prepareStatement("insert into purchaseList( mobile_number,Ac) values(?,?)");
				
					ps.setLong(1, mobileNumber);
					ps.setInt(2,quantity6 );

					PreparedStatement ps3 = connection.prepareStatement("update purchaseList set Ac=? where mobile_number=?");
					ps3.setInt(1, quantity6);
					ps3.setLong(2, mobileNumber);
					if(compare.compare(mobileNumber)) 
					{
						ps3.execute();	
					}
				else 
				{
					ps.execute();
				    ps.close();
				}
				PreparedStatement ps1 =connection.prepareStatement("select quantity from Products where product_id=6");
				ResultSet rs=ps1.executeQuery();
				while(rs.next()) 
				{
					 main_qty6=rs.getInt(1);
				}
				
                int updated_Qty6= main_qty6-quantity6;
				
				PreparedStatement ps2 =connection.prepareStatement("update Products set quantity=? where product_id=6");
				ps2.setInt(1,updated_Qty6 );
				ps2.execute();
				System.out.println("Your payment mode has being selected successfully");
				connection.close();
			} 
			catch(SQLException e) 
			{	
				e.printStackTrace();
			}
		}
		displayProductList();	
		break;
	
		case 7:
			System.out.println("Mobile added to cart!");
			System.out.print("Number of Quantities Requried : ");
			int quantity7=scanner.nextInt();
			int maxQty7=10000;
			int updatedValue7;
			if(maxQty7>=quantity7) 
			{
				System.out.print("Enter Your Registered Number For Purchasing : ");
				mobileNumber = scanner.nextLong();
				int Amount7=15000;
				int totalAmount7=Amount7*quantity7;
				int Updatedvalue7=0;
				int main_qty7=0;
				System.out.print("Your Total Amount Is : "+totalAmount7);
				System.out.println("Enter Your Mode Of Payment : \n1.Cash On Delivery \n2.Card Payment");
				int payment=scanner.nextInt();
				switch(payment) 
				{
					case 1: System.out.println("Thank You For Purchasing!!");
					break;
		   
					case 2: System.out.println("Thank You for Purchasing!");
					//break;
				}
				try 
				{
					PreparedStatement ps =connection.prepareStatement("insert into purchaseList(mobile_number,Mobile) values(?,?)");
				
					ps.setLong(1, mobileNumber);
					ps.setInt(2,quantity7);

					PreparedStatement ps3 = connection.prepareStatement("update purchaseList set Mobile=? where mobile_number=?");
					ps3.setInt(1, quantity7);
					ps3.setLong(2, mobileNumber);
					if(compare.compare(mobileNumber)) 
					{
						ps3.execute();
					}
					else 
					{
						ps.execute();
						ps.close();
					}
					PreparedStatement ps1 =connection.prepareStatement("select quantity from Products where product_id=7");
					ResultSet rs=ps1.executeQuery();
					while(rs.next()) 
					{
						main_qty7=rs.getInt(1);
					}
					int updated_Qty7= main_qty7-quantity7;
				
					PreparedStatement ps2 =connection.prepareStatement("update Products set quantity=? where product_id=7");
					ps2.setInt(1,updated_Qty7 );
					ps2.execute();
					System.out.println("Your payment mode has being selected successfully");
					//connection.close();
			} 
			catch(SQLException e) 
			{	
				e.printStackTrace();
			}
		}
		displayProductList();
		break;
			
		case 8:
			System.out.println("Celling_Fan added to cart");
			System.out.print("Number of Quantities Requried : ");
			int quantity8=scanner.nextInt();
			int maxQty8=10000;
			int updatedValue8;
			if(maxQty8>=quantity8) 
			{
				System.out.print("Enter Your Registered Number For Purchasing : ");
				mobileNumber = scanner.nextLong();
				int Amount8=4000;
				int totalAmount8=Amount8*quantity8;
				int Updatedvalue8=0;
				int main_qty8=0;
				System.out.print("Your Total Amount Is : "+totalAmount8);
				System.out.println("Enter Your Mode Of Payment:\n1.Cash On Delivery\n2.Card Payment");
				int payment=scanner.nextInt();
				switch(payment) 
				{
					case 1: System.out.println("Thank You For Purchasing!!");
					break;
		   
					case 2: System.out.println("Thank You for Purchasing!");
					//break;
				}
				try 
				{
					PreparedStatement ps =connection.prepareStatement("insert into purchaseList( mobile_number,Celling_Fan) values(?,?)");
				
					ps.setLong(1, mobileNumber);
					ps.setInt(2,quantity8);

					PreparedStatement ps3 = connection.prepareStatement("update purchaseList set Celling_Fan=? where mobile_number=?");
					ps3.setInt(1, quantity8);
					ps3.setLong(2, mobileNumber);
					if(compare.compare(mobileNumber)) 
					{
						ps3.execute();
					}
					else 
					{
						ps.execute();
						ps.close();	
					}
			
					PreparedStatement ps1 =connection.prepareStatement("select quantity from Products where product_id=8");
					ResultSet rs=ps1.executeQuery();
					while(rs.next()) 
					{
					 main_qty8=rs.getInt(1);
					}
				
					int updated_Qty8= main_qty8-quantity8;
				
					PreparedStatement ps2 =connection.prepareStatement("update Products set quantity=? where product_id=8");
					ps2.setInt(1,updated_Qty8 );
					ps2.execute();
					System.out.println("Your payment mode has being selected successfully");
					//connection.close();
			} 
			catch (SQLException e) 
			{	
				e.printStackTrace();
			}	
		}
		displayProductList();
			
			break;
	
		
		case 9:
			System.out.println(" Cooler added to cart!");
			System.out.print("Number of Quantities Requried:");
			int quantity9=scanner.nextInt();
			int maxQty9=10000;
			int updatedValue9;
			if(maxQty9>=quantity9) 
			{
				System.out.print("Enter Your Registered Number For Purchasing : ");
				mobileNumber = scanner.nextLong();
				int Amount9=50000;
				int totalAmount9=Amount9*quantity9;
				int Updatedvalue9=0;
				int main_qty9=0;
				System.out.print("Your Total Amount Is : "+totalAmount9);
				System.out.println("Enter Your Mode Of Payment:\n1.Cash On Delivery\n2.Card Payment");
				int payment=scanner.nextInt();
				switch(payment) 
				{
					case 1:
						System.out.println("Thank You For Purchasing!!");
						break;
					case 2:
						System.out.println("Thank You for Purchasing!");
				}
				try 
				{
					PreparedStatement ps =connection.prepareStatement("insert into purchaseList( mobile_number,cooler) values(?,?)");
					ps.setLong(1, mobileNumber);
					ps.setInt(2,quantity9);

					PreparedStatement ps3 = connection.prepareStatement("update purchaseList set cooler=? where mobile_number=?");
					ps3.setInt(1, quantity9);
					ps3.setLong(2, mobileNumber);
					if( compare.compare(mobileNumber)) 
					{
						ps3.execute();
					}
					else 
					{
						ps.execute();
						ps.close();
					}
	          
				PreparedStatement ps1 =connection.prepareStatement("select quantity from Products where product_id=9");
				ResultSet rs=ps1.executeQuery();
				while(rs.next()) 
				{
					 main_qty9=rs.getInt(1);
				}
				
                int updated_Qty9= main_qty9-quantity9;
				
				PreparedStatement ps2 =connection.prepareStatement("update Products set quantity=? where product_id=9");
				ps2.setInt(1,updated_Qty9 );
				ps2.execute();
				System.out.println("Your payment mode has being selected successfully");
				//connection.close();	
			} 
			catch(SQLException e) 
			{	
				e.printStackTrace();
			}
		}
		displayProductList();
		break;
				
		case 10:
			System.out.println("Camera added to cart!");
			System.out.print("Number of Quantities Requried : ");
			int quantity10=scanner.nextInt();
			int maxQty10=10000;
			int updatedValue10;
			if(maxQty10>=quantity10) 
			{
				System.out.print("Enter Your Registered Number For Purchasing : ");
				mobileNumber = scanner.nextLong();
				int Amount10=50000;
				int totalAmount10=Amount10*quantity10;
				int Updatedvalue10=0;
				int main_qty10=0;
				System.out.print("Your Total Amount Is : "+totalAmount10);
				System.out.println("Enter Your Mode Of Payment:\n1.Cash On Delivery\n2.Card Payment");
				int payment=scanner.nextInt();
				switch(payment) 
				{
					case 1: System.out.println("Thank You For Purchasing!!");
					break;
		   
					case 2: System.out.println("Thank You for Purchasing!");
				}
				try 
				{
					PreparedStatement ps =connection.prepareStatement("insert into purchaseList(mobile_number,Camera)values(?,?)");
			
					ps.setLong(1, mobileNumber);
					ps.setInt(2,quantity10);

					PreparedStatement ps3 = connection.prepareStatement("update purchaseList set Camera=? where mobile_number=?");
					ps3.setInt(1, quantity10);
					ps3.setLong(2, mobileNumber);
					if(compare.compare(mobileNumber)) 
					{
						ps3.execute();
					}
				else 
				{
					ps.execute();
					ps.close();
				}
				PreparedStatement ps1 =connection.prepareStatement("select quantity from Products where product_id=10");
				ResultSet rs=ps1.executeQuery();
				while(rs.next()) 
				{
					 main_qty10=rs.getInt(1);
				}
                int updated_Qty10= main_qty10-quantity10;
				
				PreparedStatement ps2 =connection.prepareStatement("update Products set quantity=? where product_id=10");
				ps2.setInt(1,updated_Qty10 );
				ps2.execute();
		        System.out.println("Your payment mode has being selected successfully");
				//connection.close();
			} 
			catch(SQLException e) 
			{	
				e.printStackTrace();
			}
		}
		displayProductList();
		break;
			
		case 0	: System.out.println("******************************************************      Thank You!!!!       ******************************************");
				  System.out.println("******************************************************     Visit Again ('-')    ******************************************");
		break;
		
		default : throw new InvalidInputException("You have entered invalid input,please enter the valid input...");
		}
	 }
}*/
