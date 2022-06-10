package com.devices.homework.core.entity;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import lombok.Data;


@Data
@Entity
public class AccessPoint extends LanDevice
{
	@OneToOne
	private Switch integratedSwitch;
	@Override
	public String getDeviceType()
	{
		return this.getClass().getSimpleName().toLowerCase();
	}
}
