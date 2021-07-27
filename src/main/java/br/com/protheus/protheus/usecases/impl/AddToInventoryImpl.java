package br.com.protheus.protheus.usecases.impl;

import br.com.protheus.protheus.domains.Inventory;
import br.com.protheus.protheus.gateways.InventoryGateway;
import br.com.protheus.protheus.usecases.AddToInventory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AddToInventoryImpl implements AddToInventory {

    private final InventoryGateway inventoryGateway;

    public Inventory execute(final Inventory inventory) {
        final var currentInventory = inventoryGateway.findByStoreIdAndSku(inventory.getStoreId(), inventory.getProduct().getSku());
        final var updatedInventory = currentInventory.addInventory(inventory);
        log.info("Saving a new inventory log: operation: [ADDITION] {}", updatedInventory);
        return inventoryGateway.save(updatedInventory);
    }
}
