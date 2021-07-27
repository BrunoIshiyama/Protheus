package br.com.protheus.protheus.usecases;

import br.com.protheus.protheus.domains.Inventory;

public interface AddToInventory {

    Inventory execute(Inventory inventory);

}
