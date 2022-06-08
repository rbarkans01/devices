package com.devices.homework.core.data;

import com.devices.homework.core.CoreConstants;
import com.devices.homework.core.exception.DeviceNotFoundException;


public class DeviceFactory implements AbstractFactory<Device>
{

	@Override
	public Device create(String deviceType) throws DeviceNotFoundException
	{
		switch (deviceType)
		{
			case CoreConstants.ACCESSPOINT:
				return new AccessPoint();
			case CoreConstants.SWITCH:
				return new Switch();
			case CoreConstants.GATEWAY:
				return new Gateway();
			default:
				throw new DeviceNotFoundException("no such device");
		}
	}

}
