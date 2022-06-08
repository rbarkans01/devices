package com.devices.homework.core.service.command;

import com.devices.homework.core.exception.CommandNotSupportedException;


public interface CommandFactory
{
	<T extends Command> T createCommand(Class<T> var1) throws CommandNotSupportedException;

	String getDeviceProvider();
}
