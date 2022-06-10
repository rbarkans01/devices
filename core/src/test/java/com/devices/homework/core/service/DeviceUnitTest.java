package com.devices.homework.core.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.devices.homework.core.CoreConstants;
import com.devices.homework.core.entity.AccessPoint;
import com.devices.homework.core.entity.Device;


@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class DeviceUnitTest
{
	@Test
	public void accessPointTypeTest()
	{
		final Device device = new AccessPoint();
		assertEquals(device.getDeviceType(), CoreConstants.ACCESSPOINT.toLowerCase());
	}
}

