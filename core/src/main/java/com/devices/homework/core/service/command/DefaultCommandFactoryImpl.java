package com.devices.homework.core.service.command;

import java.util.Map;

import com.devices.homework.core.exception.CommandNotSupportedException;


public class DefaultCommandFactoryImpl implements CommandFactory
{
	private Map<Class<Command>, Command> commands;
	private String deviceProvider;

	public DefaultCommandFactoryImpl()
	{
	}

	public <T extends Command> T createCommand(Class<T> commandInterface) throws CommandNotSupportedException
	{
		final Command command = this.commands.get(commandInterface);
		if (command == null)
		{
			throw new CommandNotSupportedException("Command not implemented: " + commandInterface.getCanonicalName());
		}
		else
		{
			return (T) command;
		}
	}

	@Override
	public String getDeviceProvider()
	{
		return deviceProvider;
	}

	public void setDeviceProvider(final String deviceProvider)
	{
		this.deviceProvider = deviceProvider;
	}

	public void setCommands(Map<Class<Command>, Command> commands)
	{
		this.commands = commands;
	}


}
