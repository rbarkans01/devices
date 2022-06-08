package com.devices.homework.core.data;

public class ConnectionRequest
{
	private final Device device;
	private final Device parent;

	private final String deviceType;

	public static class Builder
	{
		private Device device;
		private Device parent;

		private String deviceType;

		public ConnectionRequest build()
		{
			return new ConnectionRequest(this);
		}

		public Builder device(final Device device)
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

	public Device getDevice()
	{
		return this.device;
	}

	public Device getParent()
	{
		return this.parent;
	}
}
