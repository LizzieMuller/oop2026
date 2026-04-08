package com.bcopstein.v4;

public class CalcValorBrutoPadrao implements IValorBrutoCalculator {
    @Override
    public int calcular(int valorHora, int quantidadeDeHoras) {
        return valorHora * quantidadeDeHoras;
    }
}
