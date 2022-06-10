package com.devices.homework.core.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Table(name = "LANDEVICE")
@Entity
public class LanDevice extends Device
{
	private String parentMacAddress;
}
