package com.octotelematics.predictive_maintenance.Interface.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.JsonbHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class JsonbConfig implements WebMvcConfigurer {
    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.removeIf(c -> c.getClass().getSimpleName().contains("MappingJackson2HttpMessageConverter"));
        converters.add(new JsonbHttpMessageConverter());
    }
}