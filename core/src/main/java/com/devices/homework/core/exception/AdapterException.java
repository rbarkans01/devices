package com.devices.homework.core.exception;

public class AdapterException extends RuntimeException
{
	private Exception baseException;

	public AdapterException()
	{
	}

	public AdapterException(String message, Throwable exception)
	{
		super(message, exception);
	}

	public AdapterException(String message)
	{
		super(message);
	}

	public AdapterException(Throwable exception)
	{
		super(exception);
	}

	public void setBaseException(Exception baseException)
	{
		this.baseException = baseException;
	}

	public Exception getBaseException()
	{
		return this.baseException;
	}
}
