package br.com.protheus.protheus.domains;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Category {

    private final String id;
    private final String name;

}
