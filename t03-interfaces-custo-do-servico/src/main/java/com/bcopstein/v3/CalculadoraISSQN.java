package com.bcopstein.v3;

public class CalculadoraISSQN {
    public int calcular(int valorBruto, Estado estado) {
        return switch (estado) {
            case RS -> {
                if (valorBruto < 100) yield 0;
                if (valorBruto <= 1000) yield (int) (valorBruto * 0.15);
                yield (int) (valorBruto * 0.25);
            }
            case SC -> (int) (valorBruto * 0.20);
        };
    }
}
