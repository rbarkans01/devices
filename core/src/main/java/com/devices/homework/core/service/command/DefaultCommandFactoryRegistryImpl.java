package com.devices.homework.core.service.command;

import java.util.Collection;
import java.util.Collections;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.devices.homework.core.exception.AdapterException;


@Component
public class DefaultCommandFactoryRegistryImpl implements CommandFactoryRegistry, InitializingBean
{
	private static final Logger LOG = LoggerFactory.getLogger(DefaultCommandFactoryRegistryImpl.class);
	@Autowired
	private ApplicationContext applicationContext;
	private Collection<CommandFactory> commandFactoryList;

	public CommandFactory getFactory(String deviceProvider)
	{
		return commandFactoryList.stream().filter(i -> i.getDeviceProvider().equals(deviceProvider)).findFirst()
				.orElseThrow(() -> new AdapterException("Device can not be served!"));
	}

	public void afterPropertiesSet()
	{
		this.commandFactoryList = this.applicationContext.getBeansOfType(CommandFactory.class).values();
		if (this.commandFactoryList == null || this.commandFactoryList.isEmpty())
		{
			LOG.warn(
					"Missing command factory! At least one command factory bean should be bound to the current spring application context");
			this.commandFactoryList = Collections.emptyList();
		}

	}

	public void setCommandFactoryList(Collection<CommandFactory> commandFactoryList)
	{
		this.commandFactoryList = commandFactoryList;
	}
}
