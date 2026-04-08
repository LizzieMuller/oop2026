package com.bcopstein.v3;

public class App {
    public static void main(String[] args) {
        System.out.println("Custo do serviço:");
        CustoServicoV3 cs = new CustoServicoV3();
        var custo = cs.calculaCustoServico(31500, 45, Promocao.SEMPROMO, Estado.RS);
        System.out.println(custo);
    }
}
