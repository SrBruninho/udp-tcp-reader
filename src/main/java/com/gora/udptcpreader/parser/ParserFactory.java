package com.gora.udptcpreader.parser;

import com.gora.udptcpreader.parser.manufacturers.Manufacturer;
import com.gora.udptcpreader.parser.manufacturers.ManufacturerAParser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ParserFactory {

    private final MessageParser messageParser;

    public MessageParser getParser(byte[] data){
        Manufacturer manufacturer = messageParser.canParse(data)
                .orElseThrow(() -> new IllegalArgumentException("Manufacturer not found!"));

        return switch (manufacturer){
            case MANUFACTURER_A -> new ManufacturerAParser();
            case MANUFACTURER_B -> null; //TODO
        };
    }
}
