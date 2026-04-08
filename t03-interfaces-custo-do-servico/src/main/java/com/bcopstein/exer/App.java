package com.bcopstein.exer;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        ArrayList<IssqnCalculator> impostos = new ArrayList<>();
        impostos.add(new CalcIssqnPR());
        impostos.add(new CalcIssqnSC());
        impostos.add(new CalcIssqnRS());

        int valorBruto = 5000;
        int imposto = -1;
        String estado = "SC";
        for(IssqnCalculator imp:impostos){
            if (estado.equals(imp.estado().name())){
                imposto = imp.calcular(valorBruto);
                break;
            }
        }
        if (imposto == -1){
            System.out.println("Estado não encontrado: "+estado);
        }else{
            System.out.println("Valor do imposto em "+estado+": R$ "+imposto);
        }
    }
}
