package br.com.protheus.protheus.domains;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class RawCredentials {

    private final String usernameOrEmail;
    private final String password;

}
