package com.devices.homework.core.service.command;

import com.devices.homework.core.data.Device;


public class DeviceConnectionResult extends AbstractResult
{
	private Device device;
	private String message;

	public Device getDevice()
	{
		return device;
	}

	public void setDevice(final Device device)
	{
		this.device = device;
	}

	public String getMessage()
	{
		return message;
	}

	public void setMessage(final String message)
	{
		this.message = message;
	}
}
