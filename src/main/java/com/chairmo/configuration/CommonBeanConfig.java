package com.chairmo.configuration;

import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommonBeanConfig {

    @Bean
    public StrongPasswordEncryptor strongEncryption() {
        return new StrongPasswordEncryptor();
    }
}
