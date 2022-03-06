package hello.typeconverter.converter;

import hello.typeconverter.type.IpPort;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.core.convert.support.DefaultConversionService;

import static org.assertj.core.api.Assertions.*;

public class ConversionServiceTest {

    @Test
    void conversionService() {
        // 등록
        DefaultConversionService conversionService = new DefaultConversionService();
        conversionService.addConverter(new StringToIntegerConverter());
        conversionService.addConverter(new IntegerToStringConverter());
        conversionService.addConverter(new StringToIpPortConverter());
        conversionService.addConverter(new IpPortToStringConverter());

        Integer stringToInteger = conversionService.convert("10", Integer.class);
        assertThat(stringToInteger).isEqualTo(10);

        String integerToString = conversionService.convert(10, String.class);
        assertThat(integerToString).isEqualTo("10");

        IpPort stringToIpPort = conversionService.convert("127.0.0.1:8080", IpPort.class);
        assertThat(stringToIpPort).isEqualTo(new IpPort("127.0.0.1", 8080));

        String ipPortToString = conversionService.convert(new IpPort("127.0.0.1", 8080), String.class);
        assertThat(ipPortToString).isEqualTo("127.0.0.1:8080");
    }
}
