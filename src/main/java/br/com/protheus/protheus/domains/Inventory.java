package br.com.protheus.protheus.domains;

import com.google.common.collect.Sets;
import lombok.Builder;
import lombok.Getter;

import java.util.Collections;
import java.util.Objects;
import java.util.Set;

@Getter
@Builder
public class Inventory {

    private final String storeId;
    private final Product product;
    private final Set<String> barCodes;
    private final long quantity;

    public Set<String> getBarCodes() {
        if (Objects.isNull(barCodes))
            return Collections.unmodifiableSet(Sets.newHashSet());
        return Collections.unmodifiableSet(barCodes);
    }
}
