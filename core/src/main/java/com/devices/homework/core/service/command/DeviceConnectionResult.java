package com.devices.homework.core.service.command;

import com.devices.homework.core.entity.Device;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class DeviceConnectionResult extends AbstractResult
{
	private Device device;
	private String message;
}
