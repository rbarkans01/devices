package com.devices.homework.core.controller;

import static org.springframework.http.HttpStatus.CREATED;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.devices.homework.core.entity.AbstractDevice;
import com.devices.homework.core.entity.AccessPoint;
import com.devices.homework.core.entity.Device;
import com.devices.homework.core.entity.Gateway;
import com.devices.homework.core.entity.Switch;
import com.devices.homework.core.exception.DeviceNotFoundException;
import com.devices.homework.core.service.DeviceFacade;
import com.devices.homework.core.service.command.DeviceConnectionResult;


@RestController
@RequestMapping(value = "devices")
public class DeviceController
{
	@Autowired
	private DeviceFacade deviceFacade;

	@PostMapping(value = "accesspoint")
	@ResponseStatus(value = CREATED)
	public ResponseEntity<AbstractDevice> createAccessPoint(@RequestBody final AccessPoint device)
	{
		final Device result = deviceFacade.createDevice(device);
		return ResponseEntity.ok(result);
	}

	@PostMapping(value = "switch")
	@ResponseStatus(value = CREATED)
	public ResponseEntity<AbstractDevice> createSwitch(@RequestBody final Switch device)
	{
		final Device result = deviceFacade.createDevice(device);
		return ResponseEntity.ok(result);
	}

	@PostMapping(value = "gateway")
	@ResponseStatus(value = CREATED)
	public ResponseEntity<AbstractDevice> createGateway(@RequestBody final Gateway device)
	{
		final Device result = deviceFacade.createDevice(device);
		return ResponseEntity.ok(result);
	}

	@DeleteMapping(value = "{macAddress}")
	public CompletableFuture<Void> removeDevice(@PathVariable(value = "macAddress") final String macAddress)
	{
		return deviceFacade.removeDevice(macAddress);
	}

	@PutMapping(value = "connect/{deviceMacAddress}/{parentMacAddress}")
	public DeviceConnectionResult setConnected(@PathVariable(value = "deviceMacAddress") final String deviceMacAddress,
			@PathVariable(value = "parentMacAddress") final String parentMacAddress) throws DeviceNotFoundException
	{
		return deviceFacade.setDeviceStateConnected(deviceMacAddress, parentMacAddress);
	}

	@PutMapping(value = "disconnect/{macAddress}")
	public CompletableFuture<String> setDeviceDisconnected(@PathVariable(value = "macAddress") final String macAddress)
	{
		return deviceFacade.setDisconnected(macAddress);
	}

	@GetMapping("all")
	public CompletableFuture<List<Device>> findAll()
	{
		final CompletableFuture<List<Device>> completableFuture = new CompletableFuture<>();
		Executors.newCachedThreadPool().submit(() -> {
			completableFuture.complete(deviceFacade.findAll());
			return null;
		});
		return completableFuture;
	}

	@GetMapping("{macAddress}")
	public Device findDevice(@PathVariable(value = "macAddress") final String macAddress) throws DeviceNotFoundException
	{
		return deviceFacade.findDevice(macAddress);
	}
}

