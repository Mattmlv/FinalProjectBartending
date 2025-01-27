package bartending.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.util.List;

@Configuration
public class JacksonConfig {

    @Bean
    public MappingJackson2HttpMessageConverter jsonConverter(ObjectMapper objectMapper) {
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setObjectMapper(objectMapper);
        converter.setSupportedMediaTypes(List.of(
            org.springframework.http.MediaType.APPLICATION_JSON,
            org.springframework.http.MediaType.valueOf("application/json;charset=UTF-8")
        ));
        return converter;
    }
}
