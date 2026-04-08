package com.bcopstein.exer;

public class CalcPromoBlackFriday implements DescontoCalculator {
    @Override
    public int calcular(int valorBruto) {
        return (int) (valorBruto * 0.25);
    }
}
