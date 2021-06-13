package br.com.protheus.protheus.gateways;

import br.com.protheus.protheus.domains.UserCredentials;

public interface UserCredentialsGateway {

    UserCredentials findUserCredentials(final String usernameOrEmail);
    UserCredentials save(final UserCredentials userCredentials);

}
