package com.bcopstein.v3;

public class CustoServicoV3 {
    private CalculadoraValorBruto calcBruto;
    private CalculadoraDesconto calcDesconto;
    private CalculadoraISSQN calcIssqn;

    public CustoServicoV3() {
        this.calcBruto = new CalculadoraValorBruto();
        this.calcDesconto = new CalculadoraDesconto();
        this.calcIssqn = new CalculadoraISSQN();  
     }

    public CustoServicoDTO calculaCustoServico(int valorHora, int quantidadeDeHoras, Promocao promocao, Estado estado) {
        int valorBruto = calcBruto.calcular(valorHora, quantidadeDeHoras);
        int desconto = calcDesconto.calcular(valorBruto, promocao);
        int issqn = calcIssqn.calcular(valorBruto, estado);
        int valorPagar = valorBruto + issqn - desconto;
        return new CustoServicoDTO(valorBruto, desconto, issqn, valorPagar);
    }
}
