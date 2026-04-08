package com.bcopstein.exer;

public class CalcIssqnPR implements IssqnCalculator{
    public static final int LIMITE_PROGRESSIVO = 1000;
    @Override
    public int calcular(int valorBruto) {
        if (valorBruto <= LIMITE_PROGRESSIVO){
            return 0;
        }else{
            int valor = valorBruto - LIMITE_PROGRESSIVO;
            return (int)(valor * 0.10);
        }
    }

    @Override
    public Estado estado() {
        return Estado.PR;
    }

}
