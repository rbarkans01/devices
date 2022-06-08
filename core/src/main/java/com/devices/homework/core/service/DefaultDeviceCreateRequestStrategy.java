package com.devices.homework.core.service;

import org.springframework.stereotype.Service;

import com.devices.homework.core.data.Device;
import com.devices.homework.core.service.command.DeviceConnectionRequest;


@Service
public class DefaultDeviceCreateRequestStrategy implements DeviceCreateRequestStrategy
{
	@Override
	public DeviceConnectionRequest createConnectionSetupRequest(final Device device, final Device parentDevice)
	{
		final DeviceConnectionRequest request = new DeviceConnectionRequest(device.getDeviceType());
		request.setType(device.getDeviceType());
		request.setDevice(device);
		request.setParentDevice(parentDevice);
		return request;
	}
}
