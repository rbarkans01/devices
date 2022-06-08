package com.devices.homework.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devices.homework.core.data.ConnectionRequest;
import com.devices.homework.core.data.Device;
import com.devices.homework.core.exception.AdapterException;
import com.devices.homework.core.exception.CommandNotSupportedException;
import com.devices.homework.core.service.command.CommandFactoryRegistry;
import com.devices.homework.core.service.command.DefaultConnectionCommand;
import com.devices.homework.core.service.command.DeviceConnectionRequest;
import com.devices.homework.core.service.command.DeviceConnectionResult;


@Service
public class DefaultDeviceConnectionService implements DeviceConnectionHandler
{
	@Autowired
	private CommandFactoryRegistry commandFactoryRegistry;

	@Autowired
	private DeviceCreateRequestStrategy deviceCreateRequestStrategy;

	@Override
	public DeviceConnectionResult connectDevice(final ConnectionRequest connectionRequest)
	{
		try
		{
			final Device device = connectionRequest.getDevice();
			final Device parent = connectionRequest.getParent();
			final DeviceConnectionRequest request = deviceCreateRequestStrategy.createConnectionSetupRequest(device, parent);

			final DefaultConnectionCommand command = commandFactoryRegistry.getFactory(
					connectionRequest.getDevice().getDeviceType()).createCommand(DefaultConnectionCommand.class);
			return command.perform(request);
		}
		catch (final CommandNotSupportedException e)
		{
			throw new AdapterException("Connect command not supported", e);
		}
	}
}
