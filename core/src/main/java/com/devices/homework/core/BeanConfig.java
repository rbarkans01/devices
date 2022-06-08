package com.devices.homework.core;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.devices.homework.core.service.command.CommandFactory;
import com.devices.homework.core.service.command.DefaultCommandFactoryImpl;
import com.devices.homework.core.service.command.DefaultConnectionCommand;


@Configuration
public class BeanConfig
{
	@Bean(name = "accessPointCommandFactory")
	public CommandFactory getAccessPointCommandFactory()
	{
		final DefaultCommandFactoryImpl factory = new DefaultCommandFactoryImpl();
		factory.setDeviceProvider("AccessPoint");
		final Map commands = new HashMap<>();
		commands.put(DefaultConnectionCommand.class, getDefaultConnectionCommand());
		factory.setCommands(commands);
		return factory;
	}

	@Bean(name = "switchCommandFactory")
	public CommandFactory getSwitchCommandFactory()
	{
		final DefaultCommandFactoryImpl factory = new DefaultCommandFactoryImpl();
		factory.setDeviceProvider("Switch");
		final Map commands = new HashMap();
		commands.put(DefaultConnectionCommand.class, getDefaultConnectionCommand());
		factory.setCommands(commands);
		return factory;
	}

	@Bean(name = "gatewayCommandFactory")
	public CommandFactory getGatewayCommandFactory()
	{
		final DefaultCommandFactoryImpl factory = new DefaultCommandFactoryImpl();
		factory.setDeviceProvider("Gateway");
		final Map commands = new HashMap();
		commands.put(DefaultConnectionCommand.class, getDefaultConnectionCommand());
		factory.setCommands(commands);
		return factory;
	}

	@Bean
	public DefaultConnectionCommand getDefaultConnectionCommand()
	{
		return new DefaultConnectionCommand();
	}
}
