package com.devices.homework.core.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.devices.homework.core.CoreConstants;
import com.devices.homework.core.data.AccessPoint;
import com.devices.homework.core.data.Device;
import com.devices.homework.core.repository.DeviceRepository;


@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class DeviceUnitTest
{

	@InjectMocks
	private DefaultDeviceService deviceService;

	@Mock
	private AccessPoint accessPoint;

	@Mock
	private DeviceRepository deviceRepository;

	@Before
	public void setUp()
	{
		when(deviceRepository.save(accessPoint)).thenReturn(new AccessPoint());
	}

	@Test
	public void accessPointTypeTest()
	{
		final Device device = mock(AccessPoint.class);
		final Device result = deviceService.createDevice(device);
		assertEquals(result.getDeviceType(), CoreConstants.ACCESSPOINT.toLowerCase());
	}

}
