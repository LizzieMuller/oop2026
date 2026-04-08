package com.bcopstein.v3;

public class CalculadoraDesconto {
    public int calcular(int valorBruto, Promocao promocao) {
        return switch (promocao) {
            case SEMPROMO -> 0;
            case PRIMEIRACOMPRA -> (int) (valorBruto * 0.10);
            case BLACKFRIDAY -> (int) (valorBruto * 0.25);
            default -> 0;
        };
    }
}
