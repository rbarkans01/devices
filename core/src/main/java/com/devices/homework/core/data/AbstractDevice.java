package com.devices.homework.core.data;

import java.io.Serializable;

import lombok.Data;


@Data
public abstract class AbstractDevice implements Serializable
{
	abstract String getDeviceType();

}
