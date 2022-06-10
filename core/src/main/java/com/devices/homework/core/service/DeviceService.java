package com.devices.homework.core.service;

import java.util.List;
import java.util.Optional;

import com.devices.homework.core.entity.Device;


public interface DeviceService<T extends Device>
{
	T createDevice(T device);

	Optional<T> findDevice(String macAddress);

	List<Device> findAll();
}
