package com.crossmade.pdv.dominio.produto;

import java.math.BigDecimal;

public class Dimensoes {
    private BigDecimal peso;
    private BigDecimal altura;
    private BigDecimal largura;

    public Dimensoes(BigDecimal peso, BigDecimal altura, BigDecimal largura) {
        this.peso = peso;
        this.altura = altura;
        this.largura = largura;
    }

    public BigDecimal getPeso() { return peso; }
    public BigDecimal getAltura() { return altura; }
    public BigDecimal getLargura() { return largura; }
}
