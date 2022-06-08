package com.devices.homework.controller;

import java.io.Serializable;


public class DeviceErrorResponseEntity implements Serializable
{
	private static final long serialVersionUID = 1L;
	private String result;
	private String message;

	public DeviceErrorResponseEntity()
	{
		// default constructor
	}

	public void setResult(final String result)
	{
		this.result = result;
	}

	public String getResult()
	{
		return result;
	}

	public void setMessage(final String message)
	{
		this.message = message;
	}

	public String getMessage()
	{
		return message;
	}

}
