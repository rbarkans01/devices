package com.devices.homework.core.service;

import java.util.UUID;


public final class ServiceUtils
{
	private ServiceUtils()
	{
		throw new AssertionError();
	}

	public static UUID formatUuid(final String id)
	{
		final String temp = id.replace("-", "");
		final String formatted = String
				.format("%s-%s-%s-%s-%s", temp.substring(0, 8), temp.substring(8, 12), temp.substring(12, 16),
						temp.substring(16, 20), temp.substring(20, 32));
		return UUID.fromString(formatted);
	}
}
