package com.cancha.cliente.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class AppConfig {
    @Value("${app.separator}")
    private String separator;
}
