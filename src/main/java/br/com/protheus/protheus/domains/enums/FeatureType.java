package br.com.protheus.protheus.domains.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum FeatureType {
    COLOR(1),
    SIZE(2),
    VOLTAGE(3);

    private final int sortingOrder;

    public static int compareSortingOrder(final FeatureType a, final FeatureType b) {
        return a.getSortingOrder() - b.getSortingOrder();
    }

}
