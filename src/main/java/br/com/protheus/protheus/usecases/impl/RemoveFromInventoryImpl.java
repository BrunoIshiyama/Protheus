package br.com.protheus.protheus.usecases.impl;

import br.com.protheus.protheus.domains.Inventory;
import br.com.protheus.protheus.gateways.InventoryGateway;
import br.com.protheus.protheus.usecases.RemoveFromInventory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class RemoveFromInventoryImpl implements RemoveFromInventory {

    private final InventoryGateway inventoryGateway;

    @Override
    public Inventory execute(final Inventory inventory) {
        final var currentInventory = inventoryGateway.findByStoreIdAndSku(inventory.getStoreId(), inventory.getProduct().getSku());
        final var updatedInventory = currentInventory.removeInventory(inventory);
        log.info("Saving a new inventory log: operation: [REMOVAL] {}", updatedInventory);
        return inventoryGateway.save(updatedInventory);
    }
}
