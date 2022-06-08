package com.devices.homework.core.data;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;

import com.devices.homework.core.CoreConstants;

import lombok.Data;


@Data
public class LanDevice extends Device
{
	@ElementCollection
	private Set<LanDevice> children = new HashSet<>(CoreConstants.RECOMMENDED_MAX_CAPACITY);
}
