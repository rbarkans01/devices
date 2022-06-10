package com.devices.homework.core.entity;

import java.io.Serializable;

import lombok.Data;


@Data
public abstract class AbstractDevice implements Serializable
{
	abstract String getDeviceType();

}
