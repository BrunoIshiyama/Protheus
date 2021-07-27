package br.com.protheus.protheus.domains.records;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Data
@Document("Inventory")
public class InventoryRecord {

    @Id
    private InventoryId id;

    @Indexed
    private String departmentId;

    @Indexed
    private String brandId;

    @Indexed
    private String categoryId;

    @Indexed
    private List<FeatureRecord> features;

    @Indexed
    private Set<String> barCodes;

    @Indexed
    private boolean perishable;

    @Indexed
    private LocalDateTime dateToPerish;

    private long quantity;
    private LocalDateTime creationDate;
    private LocalDateTime lastUpdate;

    @Data
    public static class InventoryId {
        private String storeId;
        private String sku;
    }

}
