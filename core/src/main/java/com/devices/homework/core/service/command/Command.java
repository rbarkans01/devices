package com.devices.homework.core.service.command;

public interface Command<R, O>
{
	O perform(R var1);
}
