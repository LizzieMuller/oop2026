package com.bcopstein.v4;

public class CalcIssqnRS implements IIssqnCalculator {
    @Override
    public int calcular(int valorBruto) {
        if (valorBruto < 100) return 0;
        if (valorBruto <= 1000) return (int) (valorBruto * 0.15);
        return (int) (valorBruto * 0.25);
    }
}
