package br.com.protheus.protheus.domains;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Brand {

    private final String id;
    private final String name;

}
