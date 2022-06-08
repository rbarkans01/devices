package com.devices.homework.core.service;

import com.devices.homework.core.data.ConnectionRequest;
import com.devices.homework.core.service.command.DeviceConnectionResult;


public interface DeviceConnectionHandler
{
	DeviceConnectionResult connectDevice(ConnectionRequest request);
}
