# Devices
## 1. Install mandatory software
### * Java 11
### * Maven

## 2. Run application
mvn clean install && mvn spring-boot:run -pl application

Db H2 console: http://localhost:8080/h2-console

## 3. Endpoints

### Create device - Switch
#### POST
#### http://localhost:8080/devices/switch
#### Json payload:
```json
{
    "macAddress": "321",
    "conected": false,
    "parentMacAddress": null,
    "deviceType": "switch"
}
```
#### Response: HTTP 200 OK
```json
{
    "macAddress": "321",
    "conected": false,
    "parentMacAddress": null,
    "deviceType": "switch"
}
```
### Create device - AccessPoint
#### POST
#### http://localhost:8080/devices/accesspoint
#### Json payload:
```json
{
    "macAddress": "123",
    "conected": false,
    "parentMacAddress": null,
    "integratedSwitch": {
        "macAddress": "321",
        "conected": false,
        "parentMacAddress": null,
        "deviceType": "switch"
    },
    "deviceType": "accesspoint"
}
```
#### Response: HTTP 200 OK
```json
{
    "macAddress": "123",
    "conected": false,
    "parentMacAddress": null,
    "integratedSwitch": {
        "macAddress": "321",
        "conected": false,
        "parentMacAddress": null,
        "deviceType": "switch"
    },
    "deviceType": "accesspoint"
}
```
### Connect devices
#### PUT
#### http://localhost:8080/devices/connect/{deviceMacAddress}/{parentMacAddress}
#### Response: HTTP 200 OK
```json
{
    "device": {
        "macAddress": "321",
        "conected": true,
        "parentMacAddress": "123",
        "deviceType": "switch"
    },
  "message": "Device is already connected"
}
```
### Find all devices
#### GET
#### http://localhost:8080/devices/all
#### Response: Response: HTTP 200 OK
```json
[
  {
    "macAddress": "321",
    "conected": true,
    "parentMacAddress": "123",
    "deviceType": "switch"
  },
  {
    "macAddress": "123",
    "conected": false,
    "parentMacAddress": null,
    "integratedSwitch": {
      "macAddress": "321",
      "conected": true,
      "parentMacAddress": "123",
      "deviceType": "switch"
    },
    "deviceType": "accesspoint"
  }
]
```
### Find a device by MAC address
#### GET
#### http://localhost:8080/devices/{macAddress}
#### Response: Response: HTTP 200 OK
```json
[
  {
    "macAddress": "321",
    "conected": true,
    "parentMacAddress": "123",
    "deviceType": "switch"
  },
  {
    "macAddress": "123",
    "conected": false,
    "parentMacAddress": null,
    "integratedSwitch": {
      "macAddress": "321",
      "conected": true,
      "parentMacAddress": "123",
      "deviceType": "switch"
    },
    "deviceType": "accesspoint"
  }
]
```
