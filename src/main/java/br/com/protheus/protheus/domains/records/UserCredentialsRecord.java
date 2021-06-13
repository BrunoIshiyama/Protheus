package br.com.protheus.protheus.domains.records;

import br.com.protheus.protheus.domains.enums.Role;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "UserCredentials")
public class UserCredentialsRecord {

    @Id
    private String uuid;

    @Indexed
    private String email;

    @Indexed
    private String username;

    private String password;
    private String secret;
    private List<Role> roles;

}
