package br.com.protheus.protheus.exceptions;

public class InventoryNotFoundException extends ResourceNotFoundException {

    private static final String MESSAGE = "Inventory not found with storeId: %s and sku: %s";

    public InventoryNotFoundException(final String storeId, final String sku) {
        super(String.format(MESSAGE, storeId, sku));
    }
}
