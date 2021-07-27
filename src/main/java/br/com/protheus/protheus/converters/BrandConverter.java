package br.com.protheus.protheus.converters;

import br.com.protheus.protheus.domains.Brand;
import br.com.protheus.protheus.domains.records.BrandRecord;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class BrandConverter {
    public static Brand toDomain(final BrandRecord brandRecord) {
        return Brand.builder()
                .id(brandRecord.getId())
                .name(brandRecord.getName())
                .build();
    }

    public static BrandRecord toRecord(final Brand brand) {
        final var brandRecord = new BrandRecord();
        brandRecord.setId(brand.getId());
        brandRecord.setName(brand.getName());
        return brandRecord;
    }
}
