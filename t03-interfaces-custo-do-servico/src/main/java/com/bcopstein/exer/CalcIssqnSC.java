package com.bcopstein.exer;

public class CalcIssqnSC implements IssqnCalculator {
    @Override
    public int calcular(int valorBruto) {
        return (int) (valorBruto * 0.10);
    }

    @Override
    public Estado estado() {
        return Estado.SC;
    }
}
