package br.com.protheus.protheus.usecases;

import br.com.protheus.protheus.domains.UserCredentials;

public interface CreateUser {

    UserCredentials execute(final UserCredentials userCredentials);

}
