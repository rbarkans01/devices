package com.devices.homework.core.exception;

public class InvalidStateException extends Throwable
{
	public InvalidStateException(final String id, final String state, final String message)
	{
		super(" Invalid state: Cannot change " + state + " for device number [" + id.toString() + "] " + message);
	}
}
