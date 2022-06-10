package com.devices.homework.core.service.command;

public interface CommandExecutor<C extends Command, R extends AbstractResult>
{
	R execute(C command);
}
