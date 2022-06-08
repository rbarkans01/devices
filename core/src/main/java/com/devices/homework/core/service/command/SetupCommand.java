package com.devices.homework.core.service.command;

public interface SetupCommand<T extends AbstractRequest> extends Command<T, AbstractResult>
{
	AbstractResult perform(T paramT);
}
