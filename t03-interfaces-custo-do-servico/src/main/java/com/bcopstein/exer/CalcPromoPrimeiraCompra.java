package com.bcopstein.exer;

public class CalcPromoPrimeiraCompra implements DescontoCalculator {
    @Override
    public int calcular(int valorBruto) {
        return (int) (valorBruto * 0.10);
    }
}
