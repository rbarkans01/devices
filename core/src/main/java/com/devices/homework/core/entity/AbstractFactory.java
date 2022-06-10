package com.devices.homework.core.entity;

import com.devices.homework.core.exception.DeviceNotFoundException;


public interface AbstractFactory<T>
{
	T create(String deviceType) throws DeviceNotFoundException;
}
