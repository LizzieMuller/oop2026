package com.bcopstein.v4;

public class App {

    public static void main(String[] args) {
        System.out.println("Custo do serviço:");
        CustoServicoV4 cs = new CustoServicoV4();
        var custo = cs.calculaCustoServico(31500, 45, new CalcPromoPrimeiraCompra(), new CalcIssqnRS());
        System.out.println(custo);

        IIssqnCalculator ic;
        ic = new CalcIssqnRS();
        System.out.println(ic.calcular(3000));
        ic = new CalcIssqnSC();
        System.out.println(ic.calcular(3000));
    }

    public void imprimeImposto(IIssqnCalculator isc,int valorBruto){
        System.out.println("Valor do imposto:");
        System.out.println("R$ "+isc.calcular(valorBruto));
    }
}
