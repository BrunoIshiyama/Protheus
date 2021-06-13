package br.com.protheus.protheus.gateways.contracts;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UserCredentialsContract {

    @NotNull
    private String email;

    @NotNull
    private String username;

    @NotNull
    private String password;

    @NotNull
    private String secret;

}
