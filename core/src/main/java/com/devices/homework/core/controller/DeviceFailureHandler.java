package com.devices.homework.core.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.devices.homework.core.exception.DeviceNotFoundException;
import com.devices.homework.core.exception.InvalidStateException;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@ControllerAdvice
public class DeviceFailureHandler
{

	@ExceptionHandler(DeviceNotFoundException.class)
	public ResponseEntity<Object> handleFailureForFindingDevice(final DeviceNotFoundException failure)
	{
		return new ResponseEntity<>(getError(HttpStatus.NOT_FOUND, failure.getMessage()), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(InvalidStateException.class)
	public ResponseEntity<Object> handleFailureForInvalidState(final InvalidStateException failure)
	{
		return new ResponseEntity<>(getError(HttpStatus.METHOD_NOT_ALLOWED, failure.getMessage()), HttpStatus.METHOD_NOT_ALLOWED);
	}

	private DeviceErrorResponseEntity getError(final HttpStatus status, final String message)
	{
		log.debug(message);
		final DeviceErrorResponseEntity response = new DeviceErrorResponseEntity();
		response.setResult(status.getReasonPhrase());
		response.setMessage(message);
		return response;
	}
}
