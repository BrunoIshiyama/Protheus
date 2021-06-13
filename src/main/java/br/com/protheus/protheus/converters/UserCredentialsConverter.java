package br.com.protheus.protheus.converters;

import br.com.protheus.protheus.domains.UserCredentials;
import br.com.protheus.protheus.domains.records.UserCredentialsRecord;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserCredentialsConverter {

    public static UserCredentials toDomain(final UserCredentialsRecord userCredentialsRecord){
        return UserCredentials.builder()
                .email(userCredentialsRecord.getEmail())
                .password(userCredentialsRecord.getPassword())
                .secret(userCredentialsRecord.getSecret())
                .username(userCredentialsRecord.getUsername())
                .uuid(userCredentialsRecord.getUuid())
                .roles(userCredentialsRecord.getRoles())
                .build();
    }

    public static UserCredentialsRecord toRecord(final UserCredentials userCredentials) {
        final var userRecord = new UserCredentialsRecord();
        userRecord.setEmail(userCredentials.getEmail());
        userRecord.setUsername(userCredentials.getUsername());
        userRecord.setPassword(userCredentials.getPassword());
        userRecord.setSecret(userCredentials.getSecret());
        userRecord.setUuid(userCredentials.getUuid());
        userRecord.setRoles(userCredentials.getRoles());
        return userRecord;
    }
}
