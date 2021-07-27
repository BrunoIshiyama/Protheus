package br.com.protheus.protheus.gateways.impl;

import br.com.protheus.protheus.converters.UserCredentialsConverter;
import br.com.protheus.protheus.domains.UserCredentials;
import br.com.protheus.protheus.exceptions.UserNotFoundException;
import br.com.protheus.protheus.gateways.UserCredentialsGateway;
import br.com.protheus.protheus.gateways.mongo.UserCredentialsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserCredentialsGatewayImpl implements UserCredentialsGateway {

    private final UserCredentialsRepository repository;

    @Override
    public UserCredentials findUserCredentials(final String usernameOrEmail) {
        return repository.findByUsername(usernameOrEmail)
                .or(() -> repository.findByEmail(usernameOrEmail))
                .map(UserCredentialsConverter::toDomain)
                .orElseThrow(() -> new UserNotFoundException(usernameOrEmail));
    }

    @Override
    public UserCredentials save(final UserCredentials userCredentials) {
        final var userRecord = UserCredentialsConverter.toRecord(userCredentials);
        return UserCredentialsConverter.toDomain(repository.save(userRecord));
    }
}
