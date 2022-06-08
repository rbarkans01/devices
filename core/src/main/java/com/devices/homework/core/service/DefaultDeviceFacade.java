package com.devices.homework.core.service;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devices.homework.core.data.ConnectionRequest;
import com.devices.homework.core.data.Device;
import com.devices.homework.core.exception.DeviceNotFoundException;
import com.devices.homework.core.service.command.DeviceConnectionResult;


@Service
public class DefaultDeviceFacade implements DeviceFacade
{
	@Autowired
	private DeviceService deviceService;
	//	@Autowired
	//	private ModelMapper modelMapper;
	@Autowired
	private DeviceConnectionHandler deviceConnectionHandler;

	//	@Override
	//	public <T extends Device> T createDevice(final T device, Class<T> exactDeviceType)
	//	{
	//		checkNotNull(device, "Device must not be null");
	//		final DeviceEntity deviceEntity = deviceToDeviceEntityConverter.convert(device);
	//		return deviceEntityToDeviceConverter.convert(deviceService.createDevice(deviceEntity));
	//	}

	@Override
	public <T extends Device> T createDevice(final T device)
	{
		checkNotNull(device, "Device must not be null");
		return (T) deviceService.createDevice(device);
	}

	@Override
	public DeviceConnectionResult setDeviceStateConnected(final String deviceMacAddress, final String parentMacAddress)
			throws DeviceNotFoundException
	{
		checkNotNull(deviceMacAddress, "Device mac address must not be null");
		checkNotNull(parentMacAddress, "Parent device mac address must not be null");
		final Device device = findDevice(deviceMacAddress);
		final Device parentDevice = findDevice(parentMacAddress);
		final ConnectionRequest request = new ConnectionRequest.Builder().deviceType(device.getDeviceType()).device(device)
				.parent(parentDevice).build();
		return deviceConnectionHandler.connectDevice(request);
	}

	@Override
	public CompletableFuture<String> setDisconnected(final String id)
	{
		throw new UnsupportedOperationException("Operation not implemented");
	}

	@Override
	public CompletableFuture<Void> removeDevice(final String id)
	{
		throw new UnsupportedOperationException("Operation not implemented");
	}

	@Override
	public List<Device> findAll()
	{
		return deviceService.findAll();
	}

	@Override
	public Device findDevice(final String macAddress) throws DeviceNotFoundException
	{
		checkNotNull(macAddress, "Mac address must not be null");
		final Optional<Device> optionalDevice = deviceService.findDevice(macAddress);
		if (optionalDevice.isEmpty())
		{
			throw new DeviceNotFoundException(macAddress);
		}
		return optionalDevice.get();
	}
}
