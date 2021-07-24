package br.com.protheus.protheus.domains.records;

import br.com.protheus.protheus.domains.enums.FeatureType;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("ProductFeatures")
public class FeatureRecord {
    //Color, Voltage, Size

    @Id
    private String id;

    @Indexed
    private String name;

    @Indexed
    private FeatureType type;

}
