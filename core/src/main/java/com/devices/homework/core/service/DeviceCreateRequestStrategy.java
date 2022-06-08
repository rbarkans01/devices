package com.devices.homework.core.service;

import com.devices.homework.core.data.Device;
import com.devices.homework.core.service.command.DeviceConnectionRequest;


public interface DeviceCreateRequestStrategy
{
	DeviceConnectionRequest createConnectionSetupRequest(Device device, Device parentDevice);
}
