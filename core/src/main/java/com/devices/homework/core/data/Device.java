package com.devices.homework.core.data;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.devices.homework.core.CoreConstants;

import lombok.Data;


@Data
@Entity
public class Device extends AbstractDevice
{
	@Id
	private String macAddress;
	//	@Column
	private boolean conected;
	private Device parent;
	@Override
	public String getDeviceType()
	{
		return CoreConstants.NA;
	}

}
