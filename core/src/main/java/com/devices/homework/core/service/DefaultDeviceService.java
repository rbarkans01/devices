package com.devices.homework.core.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devices.homework.core.data.Device;
import com.devices.homework.core.repository.DeviceRepository;


@Service
public class DefaultDeviceService implements DeviceService
{
	@Autowired
	private DeviceRepository deviceRepository;

	@Override
	public Device createDevice(final Device device)
	{
		return deviceRepository.save(device);
	}

	@Override
	public Optional<Device> findDevice(final String macAddress)
	{
		return deviceRepository.findById(macAddress);
	}

	@Override
	public List<Device> findAll()
	{
		return deviceRepository.findAll();
	}
}
