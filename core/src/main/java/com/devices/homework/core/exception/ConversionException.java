package com.devices.homework.core.exception;

public class ConversionException extends RuntimeException
{
	public ConversionException(String msg, Throwable cause)
	{
		super(msg, cause);
	}

	public ConversionException(String msg)
	{
		super(msg);
	}
}
