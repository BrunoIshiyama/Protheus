package br.com.protheus.protheus.converters;

import br.com.protheus.protheus.domains.Category;
import br.com.protheus.protheus.domains.records.CategoryRecord;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class CategoryConverter {
    public static Category toDomain(final CategoryRecord categoryRecord) {
        return Category.builder()
                .id(categoryRecord.getId())
                .name(categoryRecord.getName())
                .build();
    }

    public static CategoryRecord toRecord(final Category category) {
        final var categoryRecord = new CategoryRecord();
        categoryRecord.setId(category.getId());
        categoryRecord.setName(category.getName());
        return categoryRecord;
    }
}
