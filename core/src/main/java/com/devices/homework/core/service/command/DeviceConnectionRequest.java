package com.devices.homework.core.service.command;

import com.devices.homework.core.data.Device;


public class DeviceConnectionRequest extends AbstractRequest
{

	private String type;
	private Device device;
	private Device parentDevice;

	public DeviceConnectionRequest(final String macAddress)
	{
		super(macAddress);
	}

	public void setType(final String type)
	{
		this.type = type;
	}

	public String getType()
	{
		return this.type;
	}

	public Device getDevice()
	{
		return device;
	}

	public void setDevice(final Device device)
	{
		this.device = device;
	}

	public Device getParentDevice()
	{
		return parentDevice;
	}

	public void setParentDevice(final Device parentDevice)
	{
		this.parentDevice = parentDevice;
	}
}
