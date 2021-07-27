package br.com.protheus.protheus.domains;

import com.google.common.collect.Sets;
import lombok.Builder;
import lombok.Getter;

import java.util.Collections;
import java.util.Objects;
import java.util.Set;

@Getter
@Builder
public class Inventory {

    private final String storeId;
    private final Product product;
    private final Set<String> barCodes;
    private final long quantity;

    public Set<String> getBarCodes() {
        if (Objects.isNull(barCodes))
            return Collections.unmodifiableSet(Sets.newHashSet());
        return Collections.unmodifiableSet(barCodes);
    }

    public Inventory addInventory(final Inventory newInventory) {
        return Inventory.builder()
                .product(getProduct())
                .storeId(getStoreId())
                .quantity(getQuantity() + newInventory.getQuantity())
                .barCodes(appendBarCodes(newInventory.getBarCodes()))
                .build();
    }

    public Inventory removeInventory(final Inventory newInventory) {

        final var quantity = getQuantity() - newInventory.getQuantity();
        final Set<String> barCodes = quantity == 0 ? Sets.newHashSet() : getBarCodes();

        return Inventory.builder()
                .product(getProduct())
                .storeId(getStoreId())
                .quantity(quantity)
                .barCodes(barCodes)
                .build();
    }

    public Set<String> appendBarCodes(final Set<String> newBarCodes) {
        final var updatedBarCodes = Sets.newHashSet(getBarCodes());
        updatedBarCodes.addAll(newBarCodes);
        return updatedBarCodes;
    }
}
