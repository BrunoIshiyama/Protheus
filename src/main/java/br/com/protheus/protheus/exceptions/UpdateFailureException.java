package br.com.protheus.protheus.exceptions;

import br.com.protheus.protheus.domains.records.InventoryRecord;

public class UpdateFailureException extends RuntimeException {

    private static final String MESSAGE = "There was an error whilst trying to save a new InventoryRecord: %s";

    public UpdateFailureException(final InventoryRecord inventoryRecord){
        super(String.format(MESSAGE, inventoryRecord.toString()));
    }

}
