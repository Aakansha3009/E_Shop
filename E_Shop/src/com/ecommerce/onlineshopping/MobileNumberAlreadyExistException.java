package com.ecommerce.onlineshopping;

public class MobileNumberAlreadyExistException extends RuntimeException 
{
	public MobileNumberAlreadyExistException(String msg) 
	{
		super(msg);
	}

}