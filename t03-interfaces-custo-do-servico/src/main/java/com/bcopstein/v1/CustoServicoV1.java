package com.bcopstein.v1;

// Versão 1: Método static que faz tudo
public class CustoServicoV1 {
    public static CustoServicoDTO calculaCustoServico(int valorHora,int quantidadeDehoras,Promocao promocao,Estado estado){
        int valorBruto = valorHora * quantidadeDehoras;

        int desconto = switch(promocao){
            case SEMPROMO -> 0;
            case PRIMEIRACOMPRA -> (int)(valorBruto * 0.1);
            case BLACKFRIDAY -> (int)(valorBruto * 0.25);
            default -> 0;
        };

        int issqn = switch(estado){
            case RS -> {
                if (valorBruto < 100) yield 0;
                if (valorBruto >= 100 && valorBruto <= 1000) yield (int)(valorBruto * 0.15);
                yield (int)(valorBruto * 0.25);
            }
            case SC -> (int)(valorBruto*0.20);
        };

        int precoPagar = valorBruto + issqn - desconto;
        return new CustoServicoDTO(valorBruto,desconto,issqn,precoPagar);
    }
}
