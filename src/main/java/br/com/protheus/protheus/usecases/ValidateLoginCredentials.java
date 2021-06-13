package br.com.protheus.protheus.usecases;

import br.com.protheus.protheus.domains.PasswordConfiguration;
import br.com.protheus.protheus.domains.RawCredentials;
import br.com.protheus.protheus.exceptions.UserNotFoundException;
import br.com.protheus.protheus.gateways.UserCredentialsGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ValidateLoginCredentials {

    private final UserCredentialsGateway credentialsGateway;

    public boolean isValid(final RawCredentials rawCredentials) {
        try {
            final var user = credentialsGateway.findUserCredentials(rawCredentials.getUsernameOrEmail());
            return buildPasswordConfiguration(rawCredentials.getPassword(), user.getSecret())
                    .matches(rawCredentials.getPassword(), user.getPassword());
        } catch (UserNotFoundException e) {
            return false;
        }
    }

    private PasswordConfiguration buildPasswordConfiguration(final String rawPassword, final String secret) {
        return PasswordConfiguration.builder()
                .password(rawPassword)
                .secret(secret)
                .build();
    }
}
