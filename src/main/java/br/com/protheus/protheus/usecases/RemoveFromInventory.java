package br.com.protheus.protheus.usecases;

import br.com.protheus.protheus.domains.Inventory;

public interface RemoveFromInventory {

    Inventory execute(Inventory inventory);

}
