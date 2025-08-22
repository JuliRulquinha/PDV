package com.crossmade.pdv.dominio.produto;

import java.math.BigDecimal;

import jakarta.persistence.Embeddable;

@Embeddable
public class Dimensoes {
    private BigDecimal peso;
    private BigDecimal altura;
    private BigDecimal largura;


    public Dimensoes(){
        
    }

    public Dimensoes(BigDecimal peso, BigDecimal altura, BigDecimal largura) {
        this.peso = peso;
        this.altura = altura;
        this.largura = largura;
    }

    public void setPeso(BigDecimal peso) {
        this.peso = peso;
    }

    public void setAltura(BigDecimal altura) {
        this.altura = altura;
    }

    public void setLargura(BigDecimal largura) {
        this.largura = largura;
    }

    public BigDecimal getPeso() { return peso; }
    public BigDecimal getAltura() { return altura; }
    public BigDecimal getLargura() { return largura; }
}
