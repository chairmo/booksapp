package com.chairmo.repositories.security;

public interface EncryptionService {
    String encryptionString(String input);
    boolean checkPassword(String plainPassword, String encryptedPassword);
}
