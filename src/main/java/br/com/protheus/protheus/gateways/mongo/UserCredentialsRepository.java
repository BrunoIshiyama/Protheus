package br.com.protheus.protheus.gateways.mongo;

import br.com.protheus.protheus.domains.records.UserCredentialsRecord;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserCredentialsRepository extends MongoRepository<UserCredentialsRecord, String> {
    Optional<UserCredentialsRecord> findByUsername(String username);
    Optional<UserCredentialsRecord> findByEmail(String email);
}
