package com.devices.homework.core.service.command;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.devices.homework.core.CoreConstants;
import com.devices.homework.core.data.Device;


@Component
public class DefaultConnectionCommand implements SetupCommand<DeviceConnectionRequest>
{
	private static final Logger LOG = LoggerFactory.getLogger(DefaultConnectionCommand.class);

	public DeviceConnectionResult perform(final DeviceConnectionRequest request)
	{
		final Device device = request.getDevice();
		final Device parentDevice = request.getParentDevice();
		final DeviceConnectionResult result = new DeviceConnectionResult();
		if (device.isConected() || device.getParent() != null)
		{
			LOG.debug(CoreConstants.CONNECTION_MESSAGE);
			result.setMessage(CoreConstants.CONNECTION_MESSAGE);
			result.setDevice(device);
			return result;
		}
		device.setParent(parentDevice);
		device.setConected(true);
		result.setDevice(device);
		return result;
	}

}
