package com.devices.homework.core.exception;

public class CommandNotSupportedException extends Exception
{
	public CommandNotSupportedException()
	{
	}

	public CommandNotSupportedException(String message, Throwable exception)
	{
		super(message, exception);
	}

	public CommandNotSupportedException(String message)
	{
		super(message);
	}

	public CommandNotSupportedException(Throwable exception)
	{
		super(exception);
	}
}
