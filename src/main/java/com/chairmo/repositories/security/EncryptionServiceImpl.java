package com.chairmo.repositories.security;

import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("jpaDao")
public class EncryptionServiceImpl implements EncryptionService {
    private StrongPasswordEncryptor encryptor;
    @Autowired
    private void setEncryptor(StrongPasswordEncryptor encryptor){this.encryptor = encryptor;}

    @Override
    public String encryptionString(String input) {
        return encryptor.encryptPassword(input);
    }

    @Override
    public boolean checkPassword(String plainPassword, String encryptedPassword) {
        return encryptor.checkPassword(plainPassword, encryptedPassword);
    }
}
