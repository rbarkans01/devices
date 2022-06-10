package com.devices.homework.core.entity;

import javax.persistence.Entity;


@Entity
public class Gateway extends WanDevice
{
	@Override
	public String getDeviceType()
	{
		return this.getClass().getSimpleName().toLowerCase();
	}

}
