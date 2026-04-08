package com.bcopstein.v4;

public class CustoServicoV4 {
    private final IValorBrutoCalculator calcValorBruto;
    private final IValorPagarCalculator calcValorPagar;

    public CustoServicoV4(){
        this.calcValorBruto = new CalcValorBrutoPadrao();
        this.calcValorPagar = new CalcValorPagarPadrao();
    }

    public CustoServicoDTO calculaCustoServico(int valorHora, int quantidadeDeHoras, IDescontoCalculator calcDesconto, IIssqnCalculator calcIssqn) {
        if (calcDesconto == null) throw new IllegalArgumentException("calcDesconto não pode ser nulo");
        if (calcIssqn == null) throw new IllegalArgumentException("calcIssqn não pode ser nulo");
        int valorBruto = calcValorBruto.calcular(valorHora, quantidadeDeHoras);
        int desconto = calcDesconto.calcular(valorBruto);
        int issqn = calcIssqn.calcular(valorBruto);
        int valorPagar = calcValorPagar.calcular(valorBruto, desconto, issqn);
        return new CustoServicoDTO(valorBruto, desconto, issqn, valorPagar);
    }
}
