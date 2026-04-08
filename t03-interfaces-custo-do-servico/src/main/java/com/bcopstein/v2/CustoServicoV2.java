package com.bcopstein.v2;
public class CustoServicoV2 {
    public static CustoServicoDTO calculaCustoServico(int valorHora, int quantidadeDeHoras, Promocao promocao, Estado estado) {
        int valorBruto = calcularValorBruto(valorHora, quantidadeDeHoras);
        int desconto = calcularDesconto(valorBruto, promocao);
        int issqn = calcularISSQN(valorBruto, estado);
        int valorPagar = calcularValorPagar(valorBruto, desconto, issqn);
        return new CustoServicoDTO(valorBruto, desconto, issqn, valorPagar);
    }

    private static int calcularValorBruto(int valorHora, int quantidadeDeHoras) {
        return valorHora * quantidadeDeHoras;
    }

    private static int calcularDesconto(int valorBruto, Promocao promocao) {
        return switch (promocao) {
            case SEMPROMO -> 0;
            case PRIMEIRACOMPRA -> (int) (valorBruto * 0.10);
            case BLACKFRIDAY -> (int) (valorBruto * 0.25);
            default -> 0;
        };
    }

    private static int calcularISSQN(int valorBruto, Estado estado) {
        return switch (estado) {
            case RS -> {
                if (valorBruto < 100) yield 0;
                if (valorBruto <= 1000) yield (int) (valorBruto * 0.15);
                yield (int) (valorBruto * 0.25);
            }
            case SC -> (int) (valorBruto * 0.20);
        };
    }

    private static int calcularValorPagar(int valorBruto, int desconto, int issqn) {
        return valorBruto + issqn - desconto;
    }
}
