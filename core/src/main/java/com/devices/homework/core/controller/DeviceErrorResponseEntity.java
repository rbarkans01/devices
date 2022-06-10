package com.devices.homework.core.controller;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class DeviceErrorResponseEntity implements Serializable
{
	private static final long serialVersionUID = 1L;
	private String result;
	private String message;

}
