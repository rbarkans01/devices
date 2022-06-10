package com.devices.homework.core.service.command;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devices.homework.core.CoreConstants;
import com.devices.homework.core.entity.Device;
import com.devices.homework.core.entity.LanDevice;
import com.devices.homework.core.repository.DeviceRepository;


@Service
public class ConectDeviceCommandExecutor implements CommandExecutor<ConnectDeviceCommand, DeviceConnectionResult>
{
	private static final Logger LOG = LoggerFactory.getLogger(ConectDeviceCommandExecutor.class);

	@Autowired
	private DeviceRepository deviceRepository;

	@Override
	public DeviceConnectionResult execute(ConnectDeviceCommand command)
	{
		final LanDevice device = command.getDevice();
		final Device parentDevice = command.getParentDevice();
		final DeviceConnectionResult result = new DeviceConnectionResult();
//		final Set<LanDevice> children = parentDevice.getChildren(); || children.contains(device)
		if (device.isConected() || StringUtils.isNotEmpty(device.getParentMacAddress()))
		{
			LOG.debug(CoreConstants.CONNECTION_FAILURE_MESSAGE);
			result.setMessage(CoreConstants.CONNECTION_FAILURE_MESSAGE);
			result.setDevice(device);
			return result;
		}
		device.setParentMacAddress(parentDevice.getMacAddress());
//		children.add(device);
		device.setConected(true);
		deviceRepository.save(device);
		result.setMessage(CoreConstants.CONNECTION_SUCCESSFUL_MESSAGE);
		result.setDevice(device);
		return result;
	}
}
