package com.devices.homework.core.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.devices.homework.core.entity.Device;
import com.devices.homework.core.exception.DeviceNotFoundException;
import com.devices.homework.core.service.command.DeviceConnectionResult;


public interface DeviceFacade
{
	<T extends Device> T createDevice(T device);

	DeviceConnectionResult setDeviceStateConnected(final String deviceMacAddress, final String parentMacAddress)
			throws DeviceNotFoundException;

	CompletableFuture<String> setDisconnected(final String id);

	CompletableFuture<Void> removeDevice(final String id);

	List<Device> findAll();

	Device findDevice(String macAddress) throws DeviceNotFoundException;
}
