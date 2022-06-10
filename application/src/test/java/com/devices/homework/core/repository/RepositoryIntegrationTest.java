package com.devices.homework.core.repository;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.devices.homework.DevicesApplication;
import com.devices.homework.core.entity.AccessPoint;
import com.devices.homework.core.entity.Device;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = DevicesApplication.class)
public class RepositoryIntegrationTest
{
	@Autowired
	private DeviceRepository repository;

	private Device accessPoint;

	@Before
	public void init()
	{
		accessPoint = new AccessPoint();
		accessPoint.setMacAddress("TEST");
	}

	@Test
	public void createNewDeviceTest() throws Exception
	{
		repository.delete(accessPoint);
		final Device createdDevice = repository.save(accessPoint);
		Assert.assertNotNull(createdDevice);
		Assert.assertEquals(createdDevice.getMacAddress(),"TEST");
	}

	@After
	public void finish() throws Exception
	{
		repository.delete(accessPoint);
	}

}
