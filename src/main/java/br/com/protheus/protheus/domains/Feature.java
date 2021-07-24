package br.com.protheus.protheus.domains;

import br.com.protheus.protheus.domains.enums.FeatureType;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Feature {

    private final String id;
    private final String name;
    private final FeatureType type;

    //TODO create usecase to getSkuRule based on the FeatureType or object type

}
