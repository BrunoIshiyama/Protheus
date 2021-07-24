package br.com.protheus.protheus.gateways.impl;

import br.com.protheus.protheus.converters.InventoryConverter;
import br.com.protheus.protheus.domains.Inventory;
import br.com.protheus.protheus.domains.records.InventoryRecord;
import br.com.protheus.protheus.exceptions.InventoryNotFoundException;
import br.com.protheus.protheus.exceptions.UpdateFailureException;
import br.com.protheus.protheus.gateways.InventoryGateway;
import br.com.protheus.protheus.gateways.mongo.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class InventoryGatewayImpl implements InventoryGateway {

    private final InventoryRepository repository;


    @Override
    public Inventory findByStoreIdAndSku(final String storeId, final String sku) {
        final var id = new InventoryRecord.InventoryId();
        id.setStoreId(storeId);
        id.setSku(sku);

        return repository.findById(id)
                .map(InventoryConverter::toDomain)
                .orElseThrow(() -> new InventoryNotFoundException(storeId, sku));
    }

    @Override
    public Inventory save(final Inventory inventory) {
        final var sku = inventory.getProduct().getSku();
        final var storeId = inventory.getStoreId();
        final var inventoryToUpdate = InventoryConverter.toRecord(inventory);

        final var id = new InventoryRecord.InventoryId();
        id.setStoreId(storeId);
        id.setSku(sku);

        return repository.findById(id)
                .map(inventoryRecord -> updateWithCreationDate(inventoryToUpdate, inventoryRecord.getCreationDate()))
                .or(() -> Optional.of(updateWithCreationDate(inventoryToUpdate, LocalDateTime.now())))
                .map(InventoryConverter::toDomain)
                .orElseThrow(() -> new UpdateFailureException(inventoryToUpdate));
    }

    private InventoryRecord updateWithCreationDate(final InventoryRecord inventoryToUpdate,
                                                   final LocalDateTime creationDate) {
        inventoryToUpdate.setCreationDate(creationDate);
        return repository.save(inventoryToUpdate);
    }

}
