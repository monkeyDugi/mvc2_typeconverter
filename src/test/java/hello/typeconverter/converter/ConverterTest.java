package hello.typeconverter.converter;

import hello.typeconverter.type.IpPort;
import org.junit.jupiter.api.Test;
import org.springframework.core.convert.converter.Converter;

import static org.assertj.core.api.Assertions.assertThat;

class ConverterTest {

    @Test
    void stringToInteger() {
        Converter<String, Integer> converter = new StringToIntegerConverter();
        Integer result = converter.convert("10");
        assertThat(result).isEqualTo(10);
    }

    @Test
    void IntegerToString() {
        Converter<Integer, String> converter = new IntegerToStringConverter();
        String result = converter.convert(10);
        assertThat(result).isEqualTo("10");
    }

    @Test
    void stringToIpPort() {
        Converter<IpPort, String> converter = new IpPortToStringConverter();
        IpPort source = new IpPort("127.0.0.1", 8080);
        String result = converter.convert(source);
        assertThat(result).isEqualTo("127.0.0.1:8080");
    }

    @Test
    void ipPortToString() {
        Converter<String, IpPort> converter = new StringToIpPortConverter();
        String source = "127.0.0.1:8080";
        IpPort result = converter.convert(source);
        assertThat(result).isEqualTo(new IpPort("127.0.0.1", 8080));
    }
}
