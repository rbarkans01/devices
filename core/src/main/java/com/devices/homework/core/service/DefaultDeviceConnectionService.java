package com.devices.homework.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devices.homework.core.entity.ConnectionRequest;
import com.devices.homework.core.entity.Device;
import com.devices.homework.core.entity.LanDevice;
import com.devices.homework.core.service.command.ConnectDeviceCommand;
import com.devices.homework.core.service.command.DeviceCommandDispatcher;
import com.devices.homework.core.service.command.DeviceConnectionResult;


@Service
public class DefaultDeviceConnectionService implements DeviceConnectionHandler
{

	@Autowired
	private DeviceCommandDispatcher commandDispatcher;

	@Override
	public DeviceConnectionResult connectDevice(final ConnectionRequest connectionRequest)
	{
		final LanDevice device = connectionRequest.getDevice();
		final Device parent = connectionRequest.getParent();
		return commandDispatcher.dispatch(new ConnectDeviceCommand(device, parent));

	}
}
