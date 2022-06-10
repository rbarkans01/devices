package com.devices.homework.core.service.command;

import com.devices.homework.core.entity.Device;
import com.devices.homework.core.entity.LanDevice;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class ConnectDeviceCommand implements Command<CommandVoidResult>
{
	private final LanDevice device;
	private final Device parentDevice;
}
