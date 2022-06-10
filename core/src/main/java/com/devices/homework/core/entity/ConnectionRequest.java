package com.devices.homework.core.entity;

public class ConnectionRequest
{
	private final LanDevice device;
	private final Device parent;

	private final String deviceType;

	public static class Builder
	{
		private LanDevice device;
		private Device parent;

		private String deviceType;

		public ConnectionRequest build()
		{
			return new ConnectionRequest(this);
		}

		public Builder device(final LanDevice device)
		{
			this.device = device;
			return this;
		}

		public Builder parent(final Device parent)
		{
			this.parent = parent;
			return this;
		}

		public Builder deviceType(final String deviceType)
		{
			this.deviceType = deviceType;
			return this;
		}
	}

	ConnectionRequest(Builder builder)
	{
		device = builder.device;
		parent = builder.parent;
		deviceType = builder.deviceType;
	}

	public LanDevice getDevice()
	{
		return this.device;
	}

	public Device getParent()
	{
		return this.parent;
	}
}
