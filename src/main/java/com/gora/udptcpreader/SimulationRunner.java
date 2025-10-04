package com.gora.udptcpreader;

import com.gora.udptcpreader.dto.DeviceMessageDTO;
import com.gora.udptcpreader.service.DataProcessorService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import static ch.qos.logback.core.encoder.ByteArrayUtil.hexStringToByteArray;

@Component
@RequiredArgsConstructor
public class SimulationRunner implements CommandLineRunner {

    private final DataProcessorService dataProcessorService;

    @Override
    public void run(String... args) throws Exception {
                String hex = "4D616E75666163747572657241000003E941BC000042366666003C0000000068E05B75";

        DeviceMessageDTO manufacturerA = dataProcessorService.run(hexStringToByteArray(hex));
        System.out.println(manufacturerA);
    }
}
