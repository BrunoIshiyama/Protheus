package br.com.protheus.protheus.domains;

import lombok.Builder;
import lombok.Getter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

import static org.springframework.security.crypto.password.Pbkdf2PasswordEncoder.SecretKeyFactoryAlgorithm.PBKDF2WithHmacSHA512;

@Builder
@Getter
public class PasswordConfiguration {

    private final String password;
    private final String secret;

    private PasswordEncoder getPasswordEncoder() {
        final var encoder = new Pbkdf2PasswordEncoder(secret);
        encoder.setAlgorithm(PBKDF2WithHmacSHA512);
        return encoder;
    }

    public String getEncryptedPassword() {
        return getPasswordEncoder().encode(password);
    }

    public boolean matches(final String rawPassword, final String encryptedPassword) {
        return getPasswordEncoder().matches(rawPassword, encryptedPassword);
    }

}
