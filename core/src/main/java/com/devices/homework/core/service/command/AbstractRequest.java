package com.devices.homework.core.service.command;

public abstract class AbstractRequest
{
	private final String macAddress;

	protected AbstractRequest(String macAddress)
	{
		this.macAddress = macAddress;
	}
}
