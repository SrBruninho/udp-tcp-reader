package com.gora.udptcpreader.service;

import com.gora.udptcpreader.dto.DeviceMessageDTO;
import com.gora.udptcpreader.parser.MessageParser;
import com.gora.udptcpreader.parser.ParserFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DataProcessorService {

    private final ParserFactory parserFactory;

    public DeviceMessageDTO run(byte[] data){
        MessageParser messageParser = parserFactory.getParser(data);
        return messageParser.parseData(data);
    }

}
