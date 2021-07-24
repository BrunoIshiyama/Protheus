package br.com.protheus.protheus.usecases.impl;

import br.com.protheus.protheus.domains.Inventory;
import br.com.protheus.protheus.gateways.InventoryGateway;
import br.com.protheus.protheus.usecases.AddToInventory;
import com.google.common.collect.Sets;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Set;

@Slf4j
@Service
@RequiredArgsConstructor
public class AddToInventoryImpl implements AddToInventory {

    private final InventoryGateway inventoryGateway;

    public Inventory execute(final Inventory inventory) {
        final var currentInventory = inventoryGateway.findByStoreIdAndSku(inventory.getStoreId(), inventory.getProduct().getSku());
        final var updatedInventory = updateInventory(currentInventory, inventory);
        log.info("Saving an nem inventory log: {}", updatedInventory);
        return inventoryGateway.save(updatedInventory);
    }

    private Inventory updateInventory(final Inventory currentInventory, final Inventory newInventory) {
        return Inventory.builder()
                .product(currentInventory.getProduct())
                .storeId(currentInventory.getStoreId())
                .quantity(currentInventory.getQuantity() + newInventory.getQuantity())
                .barCodes(appendBarCodes(currentInventory.getBarCodes(), newInventory.getBarCodes()))
                .build();
    }

    private Set<String> appendBarCodes(final Set<String> currentBarCodes, final Set<String> newBarCodes) {
        final var updatedBarCodes = Sets.newHashSet(currentBarCodes);
        updatedBarCodes.addAll(newBarCodes);
        return updatedBarCodes;
    }
}
