package com.devices.homework.core.entity;

import java.util.HashSet;
import java.util.Set;

import com.devices.homework.core.CoreConstants;


public class WanDevice extends Device
{
	private Set<LanDevice> children = new HashSet<>(CoreConstants.RECOMMENDED_MAX_CAPACITY);
}
