package br.com.protheus.protheus.gateways.mongo;

import br.com.protheus.protheus.domains.records.InventoryRecord;
import org.springframework.data.mongodb.repository.MongoRepository;

import static br.com.protheus.protheus.domains.records.InventoryRecord.*;

public interface InventoryRepository extends MongoRepository<InventoryRecord, InventoryId> {
}
