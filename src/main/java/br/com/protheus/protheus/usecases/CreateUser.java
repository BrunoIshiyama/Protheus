package br.com.protheus.protheus.usecases;

import br.com.protheus.protheus.domains.PasswordConfiguration;
import br.com.protheus.protheus.domains.UserCredentials;
import br.com.protheus.protheus.gateways.UserCredentialsGateway;
import com.google.common.collect.Lists;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

import static br.com.protheus.protheus.domains.enums.Role.BASIC;

@Service
@RequiredArgsConstructor
public class CreateUser {

    private final UserCredentialsGateway userCredentialsGateway;

    public UserCredentials execute(final UserCredentials userCredentials) {
        final var encodedPassword = getEncodedPassword(userCredentials);
        final var userWithId = buildUserCredentials(encodedPassword, userCredentials);
        return userCredentialsGateway.save(userWithId);
    }

    private String getEncodedPassword(final UserCredentials userCredentials) {
       return buildPasswordConfiguration(userCredentials)
               .getEncryptedPassword();
    }

    private PasswordConfiguration buildPasswordConfiguration(final UserCredentials userCredentials) {
        return PasswordConfiguration.builder()
                .secret(userCredentials.getSecret())
                .password(userCredentials.getPassword())
                .build();
    }

    private UserCredentials buildUserCredentials(final String encodedPassword,
                                                 final UserCredentials userCredentials) {
        return UserCredentials.builder()
                .uuid(UUID.randomUUID().toString())
                .username(userCredentials.getUsername())
                .password(encodedPassword)
                .secret(userCredentials.getSecret())
                .email(userCredentials.getEmail())
                .roles(Lists.newArrayList(BASIC))
                .build();
    }
}
