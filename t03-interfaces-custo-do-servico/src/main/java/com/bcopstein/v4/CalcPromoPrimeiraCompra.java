package com.bcopstein.v4;

public class CalcPromoPrimeiraCompra implements IDescontoCalculator {
    @Override
    public int calcular(int valorBruto) {
        return (int) (valorBruto * 0.10);
    }
}
