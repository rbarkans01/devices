package com.devices.homework.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devices.homework.core.data.Device;


@Repository
public interface DeviceRepository extends JpaRepository<Device, String>
{
}
