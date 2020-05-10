package com.chairmo.service.securityService;

import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.stereotype.Service;

@Service
public class EncryptionServiceImpl implements EncryptionService {

    private final StrongPasswordEncryptor strongEncryption;

    public EncryptionServiceImpl(StrongPasswordEncryptor strongEncryption) {
        this.strongEncryption = strongEncryption;
    }


    @Override
    public String encryptString(String input) {
        return strongEncryption.encryptPassword(input);
    }

    @Override
    public boolean checkPassword(String plainPassword, String encryptedPassword) {
        return strongEncryption.checkPassword(plainPassword, encryptedPassword);
    }
}
