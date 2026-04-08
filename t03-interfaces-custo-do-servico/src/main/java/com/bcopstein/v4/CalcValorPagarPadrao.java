package com.bcopstein.v4;

public class CalcValorPagarPadrao implements IValorPagarCalculator {
    @Override
    public int calcular(int valorBruto, int desconto, int issqn) {
        return valorBruto + issqn - desconto;
    }
}
