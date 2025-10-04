package com.gora.udptcpreader.parser;

import com.gora.udptcpreader.dto.DeviceMessageDTO;
import com.gora.udptcpreader.parser.manufacturers.Manufacturer;

import java.util.Optional;

/**
 * Strategy Pattern interface for parsing device messages.
 * <p>
 * These methods supporting multiple manufacturers, each with its own parser implementation.
 * Each parser knows how to interpret the specific binary format of a given manufacturer.
 *
 */
public interface MessageParser {

    DeviceMessageDTO parseData(byte[] data);

    Optional<Manufacturer> canParse(byte[] data);
}
