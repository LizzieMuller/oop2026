package com.bcopstein.v4;

public class CalcIssqnSC implements IIssqnCalculator {
    @Override
    public int calcular(int valorBruto) {
        return (int) (valorBruto * 0.20);
    }
}
