package com.bcopstein.v4;

public class CalcPromoBlackFriday implements IDescontoCalculator {
    @Override
    public int calcular(int valorBruto) {
        return (int) (valorBruto * 0.25);
    }
}
