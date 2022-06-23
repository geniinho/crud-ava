package com.avanade.crud.domain.enums;

public enum TipoMaterial {
    ORGANICO(0,"ORGANICO"),
    PLASTICO(1,"PLASTICO"),
    BATERIA(2,"BATERIA"),
    ELETRONICO(3,"ELETRONICO"),
    VIDRO(4,"VIDRO"),
    METAL(5,"METAL"),
    PAPEL(6,"PAPEL");

    private Integer codigo;
    private String descricao;

    private TipoMaterial(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static TipoMaterial toEnum(Integer cod) {
        if(cod == null) {
            return null;
        }

        for (TipoMaterial x : TipoMaterial.values()) {
            if (cod.equals(x.getCodigo())) {
                return x;
            }
        }

        throw new IllegalArgumentException("Tipo de material inválido");
    }
}