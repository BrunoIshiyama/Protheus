package br.com.protheus.protheus.converters;

import br.com.protheus.protheus.domains.Inventory;
import br.com.protheus.protheus.domains.Product;
import br.com.protheus.protheus.domains.records.InventoryRecord;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

import static br.com.protheus.protheus.domains.records.InventoryRecord.*;
import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class InventoryConverter {

    public static Inventory toDomain(final InventoryRecord inventoryRecord) {
        return Inventory.builder()
                .barCodes(inventoryRecord.getBarCodes())
                .quantity(inventoryRecord.getQuantity())
                .storeId(inventoryRecord.getId().getStoreId())
                .product(buildProduct(inventoryRecord))
                .build();
    }

    private static Product buildProduct(final InventoryRecord inventoryRecord) {
        return Product.builder()
                .brandId(inventoryRecord.getBrandId())
                .categoryId(inventoryRecord.getCategoryId())
                .dateToPerish(inventoryRecord.getDateToPerish())
                .departmentId(inventoryRecord.getDepartmentId())
                .features(inventoryRecord.getFeatures().stream()
                        .map(FeatureConverter::toDomain)
                        .collect(Collectors.toList()))
                .perishable(inventoryRecord.isPerishable())
                .sku(inventoryRecord.getId().getSku())
                .build();
    }

    public static InventoryRecord toRecord(final Inventory inventory) {
        final var product = inventory.getProduct();

        final var inventoryId = new InventoryId();
        inventoryId.setSku(product.getSku());
        inventoryId.setStoreId(inventory.getStoreId());

        final var inventoryRecord = new InventoryRecord();

        inventoryRecord.setBrandId(product.getBrandId());
        inventoryRecord.setCategoryId(product.getCategoryId());
        inventoryRecord.setFeatures(product.getFeatures().stream()
                .map(FeatureConverter::toRecord)
                .collect(Collectors.toList()));
        inventoryRecord.setDateToPerish(product.getDateToPerish());
        inventoryRecord.setDepartmentId(product.getDepartmentId());
        inventoryRecord.setPerishable(product.isPerishable());

        inventoryRecord.setQuantity(inventory.getQuantity());
        inventoryRecord.setBarCodes(inventoryRecord.getBarCodes());

        inventoryRecord.setId(inventoryId);
        inventoryRecord.setLastUpdate(LocalDateTime.now());
        return inventoryRecord;
    }
}
