package com.devices.homework.core.data;

import javax.persistence.Entity;


@Entity
public class Switch extends LanDevice
{
	@Override
	public String getDeviceType()
	{
		return this.getClass().getSimpleName().toLowerCase();
	}

}
