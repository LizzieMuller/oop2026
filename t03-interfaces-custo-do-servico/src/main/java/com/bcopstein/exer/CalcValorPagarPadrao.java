package com.bcopstein.exer;

public class CalcValorPagarPadrao implements ValorPagarCalculator {
    @Override
    public int calcular(int valorBruto, int desconto, int issqn) {
        return valorBruto + issqn - desconto;
    }
}
