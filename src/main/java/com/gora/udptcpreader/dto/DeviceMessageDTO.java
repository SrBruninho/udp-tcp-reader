package com.gora.udptcpreader.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class DeviceMessageDTO {

    private long deviceId;
    private double latitude;
    private double longitude;
    private short speed;
    private long timestamp;
}
