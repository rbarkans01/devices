package com.devices.homework.core.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.devices.homework.core.CoreConstants;

import lombok.Data;


@Data
@Entity
@Table(name = "DEVICE")
public class Device extends AbstractDevice
{
	@Id
	private String macAddress;
	private boolean conected;
	@Override
	public String getDeviceType()
	{
		return CoreConstants.NA;
	}

}
