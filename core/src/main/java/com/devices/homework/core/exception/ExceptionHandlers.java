package com.devices.homework.core.exception;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@ControllerAdvice
public class ExceptionHandlers extends ResponseEntityExceptionHandler
{

	private static final String REQUESTED_DEVICE_NOT_FOUND = "Requested device not found";
	private static final String INVALID_DEVICE_STATE_EXCEPTION = "DeviceEntity state change operation aborted : Invalid State";

	@ExceptionHandler(DeviceNotFoundException.class)
	public ResponseEntity<Object> handleAccountNotFound(DeviceNotFoundException ex)
	{
		log.error(REQUESTED_DEVICE_NOT_FOUND);

		return buildResponseEntity(new ResponseError(NOT_FOUND, REQUESTED_DEVICE_NOT_FOUND));
	}

	@ExceptionHandler(InvalidStateException.class)
	public ResponseEntity<Object> handleInvalidDeviceState(InvalidStateException ex)
	{
		log.error(INVALID_DEVICE_STATE_EXCEPTION);

		return buildResponseEntity(new ResponseError(BAD_REQUEST, INVALID_DEVICE_STATE_EXCEPTION));
	}

	private ResponseEntity<Object> buildResponseEntity(ResponseError responseError)
	{
		return new ResponseEntity<>(responseError, responseError.getStatus());
	}
}
