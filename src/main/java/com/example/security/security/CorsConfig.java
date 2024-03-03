package com.example.security.security;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {
    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        //1.允許 localhost:4200 存取
        corsConfiguration.setAllowedOriginPatterns(Arrays.asList("http://localhost:4200"));
        //2.允許任何請求頭
        corsConfiguration.addAllowedHeader(CorsConfiguration.ALL);
        //3.允許任何方法
        corsConfiguration.addAllowedMethod(CorsConfiguration.ALL);
        //4.允許憑證
        corsConfiguration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfiguration);
        return new CorsFilter(source);
    }
}