package br.com.protheus.protheus.converters;

import br.com.protheus.protheus.domains.Feature;
import br.com.protheus.protheus.domains.records.FeatureRecord;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class FeatureConverter {

    public static Feature toDomain(final FeatureRecord featureRecord) {
        return Feature.builder()
                .id(featureRecord.getId())
                .name(featureRecord.getName())
                .type(featureRecord.getType())
                .build();
    }

    public static FeatureRecord toRecord(final Feature feature) {
        final var featureRecord = new FeatureRecord();
        featureRecord.setId(feature.getId());
        featureRecord.setName(feature.getName());
        featureRecord.setType(feature.getType());
        return featureRecord;
    }

}
