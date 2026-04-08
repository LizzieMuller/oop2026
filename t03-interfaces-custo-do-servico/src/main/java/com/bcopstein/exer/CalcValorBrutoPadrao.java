package com.bcopstein.exer;

public class CalcValorBrutoPadrao implements ValorBrutoCalculator {
    @Override
    public int calcular(int valorHora, int quantidadeDeHoras) {
        return valorHora * quantidadeDeHoras;
    }
}
