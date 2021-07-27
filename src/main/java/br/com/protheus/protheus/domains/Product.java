package br.com.protheus.protheus.domains;

import br.com.protheus.protheus.domains.enums.FeatureType;
import com.google.common.collect.Lists;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Getter
@Builder
public class Product {

    private final String sku;
    private final String departmentId;
    private final String brandId;
    private final String categoryId;
    private final List<Feature> features;
    private final boolean perishable;
    private final LocalDateTime dateToPerish;

    public List<Feature> getFeatures() {
        if (Objects.isNull(features))
            return Collections.unmodifiableList(Lists.newArrayList());
        features.sort((o1, o2) -> FeatureType.compareSortingOrder(o1.getType(), o2.getType()));
        return Collections.unmodifiableList(features);
    }

    public String getSku() {
        return String.join("-", getIds());
    }

    private List<String> getIds() {
        final var list = Lists.newArrayList(departmentId, brandId, categoryId);
        list.addAll(features.stream().map(Feature::getId).collect(Collectors.toList()));
        return list;
    }
}
