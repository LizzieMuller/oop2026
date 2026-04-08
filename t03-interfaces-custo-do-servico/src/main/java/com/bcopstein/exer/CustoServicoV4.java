package com.bcopstein.exer;

public class CustoServicoV4 {
    private ValorBrutoCalculator calcValorBruto;
    private ValorPagarCalculator calcValorPagar;

    public CustoServicoV4(ValorBrutoCalculator calcValorBruto) {
        if (calcValorBruto == null) throw new IllegalArgumentException("calcValorBruto não pode ser nulo");
        this.calcValorBruto = calcValorBruto;
        this.calcValorPagar = new CalcValorPagarPadrao();
    }

    public CustoServicoV4() {
        this(new CalcValorBrutoPadrao());
    }

    public void setValorPagarCalculator(ValorPagarCalculator calcValorPagar) {
        if (calcValorPagar == null) throw new IllegalArgumentException("calcValorPagar não pode ser nulo");
        this.calcValorPagar = calcValorPagar;
    }

    public void setValorBrutoCalculator(ValorBrutoCalculator calcValorBruto) {
        if (calcValorBruto == null) throw new IllegalArgumentException("calcValorBruto não pode ser nulo");
        this.calcValorBruto = calcValorBruto;
    }

    public CustoServicoDTO calculaCustoServico(int valorHora, int quantidadeDeHoras, DescontoCalculator calcDesconto, IssqnCalculator calcIssqn) {
        if (calcDesconto == null) throw new IllegalArgumentException("calcDesconto não pode ser nulo");
        if (calcIssqn == null) throw new IllegalArgumentException("calcIssqn não pode ser nulo");
        int valorBruto = calcValorBruto.calcular(valorHora, quantidadeDeHoras);
        int desconto = calcDesconto.calcular(valorBruto);
        int issqn = calcIssqn.calcular(valorBruto);
        int valorPagar = calcValorPagar.calcular(valorBruto, desconto, issqn);
        return new CustoServicoDTO(valorBruto, desconto, issqn, valorPagar);
    }
}
