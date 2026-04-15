package br.edu.utfpr.pb.pw44s.server.model.enums;

import lombok.Getter;

@Getter
public enum TargetType {
    ALL("Todos os Produtos"),
    CATEGORY("Categoria Específica"),
    PRODUCT("Produto Específico");

    private final String description;

    TargetType(String description) {
        this.description = description;
    }
}