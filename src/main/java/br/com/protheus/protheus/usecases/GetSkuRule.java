package br.com.protheus.protheus.usecases;

import br.com.protheus.protheus.domains.enums.FeatureType;
import br.com.protheus.protheus.domains.enums.SkuCreationRule;

public interface GetSkuRule {

    SkuCreationRule execute(FeatureType type);

}
