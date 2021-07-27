package br.com.protheus.protheus.gateways;

import br.com.protheus.protheus.domains.Inventory;

public interface InventoryGateway {

    Inventory findByStoreIdAndSku(final String storeId, final String sku);

    Inventory save(final Inventory inventory);

}
