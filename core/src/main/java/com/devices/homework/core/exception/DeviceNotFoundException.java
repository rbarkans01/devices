package com.devices.homework.core.exception;

public class DeviceNotFoundException extends Throwable
{
	public DeviceNotFoundException(String macAddress)
	{
		super("Cannot find mac address [" + macAddress + "]");
	}
}
