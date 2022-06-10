package com.devices.homework.core.service.command;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;


@Service
public class DeviceCommandDispatcher extends CommandDispatcher
{
	private final Map<String, CommandExecutor> rawMap;

	public DeviceCommandDispatcher(Map<String, CommandExecutor> rawMap)
	{
		this.rawMap = rawMap;
	}

	@PostConstruct
	private void setUp()
	{
		if (rawMap != null && !rawMap.isEmpty())
		{
			for (CommandExecutor commandExecutor : rawMap.values())
			{
				final Type command = ((ParameterizedType) commandExecutor.getClass()
						.getGenericInterfaces()[0]).getActualTypeArguments()[0];
				preparedMap.put((Class) command, commandExecutor);
			}
		}
	}
}
