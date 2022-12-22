package com.ecommerce.onlineshopping;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Compare 
{		
		JdbcConnection connectionobj =new  JdbcConnection();
		Connection connection =connectionobj.getConnectionDetails();
		
		public boolean compare(long entermobile_number) 
		{
			ArrayList al =new ArrayList();
			try 
			{
				String sql="select * from  purchaseList";
				Statement ps=connection.createStatement();
				ResultSet rs = ps.executeQuery(sql);
				while(rs.next()) 
				{
					al.add(rs.getLong(1));
				}	
		} 
		catch(SQLException e) 
		{	
			e.printStackTrace();
		}
		return al.contains(entermobile_number);
		}
		
		public boolean compareUser(long entermobile_number) 
		{
			ArrayList al =new ArrayList();
			try 
			{
				String sql="select * from User";
				Statement ps=connection.createStatement();
				ResultSet rs = ps.executeQuery(sql);
				while(rs.next()) 
				{
					al.add(rs.getLong(1));	
				}	
			}	 
			catch(SQLException e) 
			{	
				e.printStackTrace();
			}
			return al.contains(entermobile_number);
		}
}

