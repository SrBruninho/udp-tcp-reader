package com.gora.udptcpreader.parser.manufacturers;

import com.gora.udptcpreader.dto.DeviceMessageDTO;
import com.gora.udptcpreader.parser.MessageParser;
import org.springframework.stereotype.Component;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Optional;

import static com.gora.udptcpreader.parser.manufacturers.Manufacturer.MANUFACTURER_A;

@Component
public class ManufacturerAParser implements MessageParser {

    @Override
    public DeviceMessageDTO parseData(byte[] data) {
        ByteBuffer byteBuffer = ByteBuffer
                .wrap(data)
                .order(ByteOrder.BIG_ENDIAN);

        return DeviceMessageDTO
                .builder()
                .deviceId(byteBuffer.getInt())
                .latitude(byteBuffer.getFloat())
                .longitude(byteBuffer.getFloat())
                .speed(byteBuffer.getShort())
                .timestamp(byteBuffer.getLong())
                .build();
    }

    @Override
    public Optional<Manufacturer> canParse(byte[] data) {
        if(data.length == 35 && (data[0] & 0xFF) == 0x4D)
            return Optional.of(MANUFACTURER_A);

        return Optional.empty();
    }
}
