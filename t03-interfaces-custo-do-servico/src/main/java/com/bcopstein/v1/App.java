package com.bcopstein.v1;

public class App {
    public static void main(String[] args) {
        System.out.println("Custo do serviço:");
        var custo = CustoServicoV1.calculaCustoServico(31500, 45, Promocao.SEMPROMO, Estado.RS);
        System.out.println(custo);
    }
}
