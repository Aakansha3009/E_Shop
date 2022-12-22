package com.ecommerce.onlineshopping;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcConnection 
{
		public Connection getConnectionDetails()
		{
			Connection connection=null;
			try
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
				connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/e_store","root","@Akku3009@"); 
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			return connection;
		}
}