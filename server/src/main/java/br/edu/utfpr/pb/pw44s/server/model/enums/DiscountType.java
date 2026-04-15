package br.edu.utfpr.pb.pw44s.server.model.enums;

import lombok.Getter;

@Getter
public enum DiscountType {
    FIXED("Valor Fixo"),
    PERCENTAGE("Percentual");

    private final String description;

    DiscountType(String description) {
        this.description = description;
    }
}