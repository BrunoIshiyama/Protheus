package br.com.protheus.protheus.usecases.impl;

import br.com.protheus.protheus.domains.enums.FeatureType;
import br.com.protheus.protheus.domains.enums.SkuCreationRule;
import br.com.protheus.protheus.exceptions.ResourceNotFoundException;
import br.com.protheus.protheus.usecases.GetSkuRule;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static br.com.protheus.protheus.domains.enums.SkuCreationRule.*;
import static java.lang.String.*;

@Slf4j
@Service
public class GetSkuRuleByFeatureType implements GetSkuRule {

    private static final String RULE_NOT_FOUND = "Rule not found for feature type: %s";

    public SkuCreationRule execute(final FeatureType type) {
        switch (type) {
            case COLOR:
                return COLOR_RULE;
            case SIZE:
                return SIZE_RULE;
            case VOLTAGE:
                return VOLTAGE_RULE;
            default:
                final var message = format(RULE_NOT_FOUND, type);
                log.info(message);
                throw new ResourceNotFoundException(message);
        }
    }

}
