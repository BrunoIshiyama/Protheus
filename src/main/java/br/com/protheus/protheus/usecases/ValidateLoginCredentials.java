package br.com.protheus.protheus.usecases;

import br.com.protheus.protheus.domains.RawCredentials;

public interface ValidateLoginCredentials {

    boolean isValid(final RawCredentials rawCredentials);

}
