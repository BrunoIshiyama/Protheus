package br.com.protheus.protheus.domains;

import br.com.protheus.protheus.domains.enums.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.Collections;
import java.util.List;

@Builder
@Getter
@ToString
public class UserCredentials {

    private final String uuid;
    private final String email;
    private final String username;
    private final String password;
    private final String secret;
    private final List<Role> roles;

    public List<Role> getRoles() {
        return Collections.unmodifiableList(roles);
    }

}
