# Custo do Serviço — Quatro Versões (V1–V4)

Este projeto apresenta quatro abordagens evolutivas para calcular o custo de um serviço, indo de uma solução monolítica até uma baseada em interfaces e injeção de dependências.

Observação: todos os valores monetários estão em centavos (inteiros multiplicados por 100).

## Estrutura de Pacotes

- V1: [src/main/java/com/bcopstein/v1](src/main/java/com/bcopstein/v1)
    - [CustoServicoV1](src/main/java/com/bcopstein/v1/CustoServicoV1.java), [CustoServicoDTO](src/main/java/com/bcopstein/v1/CustoServicoDTO.java), [Promocao](src/main/java/com/bcopstein/v1/Promocao.java), [Estado](src/main/java/com/bcopstein/v1/Estado.java)
- V2: [src/main/java/com/bcopstein/v2](src/main/java/com/bcopstein/v2)
    - [CustoServicoV2](src/main/java/com/bcopstein/v2/CustoServicoV2.java), [CustoServicoDTO](src/main/java/com/bcopstein/v2/CustoServicoDTO.java), [Promocao](src/main/java/com/bcopstein/v2/Promocao.java), [Estado](src/main/java/com/bcopstein/v2/Estado.java)
- V3: [src/main/java/com/bcopstein/v3](src/main/java/com/bcopstein/v3)
    - [CustoServicoV3](src/main/java/com/bcopstein/v3/CustoServicoV3.java), [CalculadoraValorBruto](src/main/java/com/bcopstein/v3/CalculadoraValorBruto.java), [CalculadoraDesconto](src/main/java/com/bcopstein/v3/CalculadoraDesconto.java), [CalculadoraISSQN](src/main/java/com/bcopstein/v3/CalculadoraISSQN.java), [CustoServicoDTO](src/main/java/com/bcopstein/v3/CustoServicoDTO.java), [Promocao](src/main/java/com/bcopstein/v3/Promocao.java), [Estado](src/main/java/com/bcopstein/v3/Estado.java)
- V4: [src/main/java/com/bcopstein/v4](src/main/java/com/bcopstein/v4)
    - [CustoServicoV4](src/main/java/com/bcopstein/v4/CustoServicoV4.java) + Interfaces e calculadoras: [ValorBrutoCalculator](src/main/java/com/bcopstein/v4/ValorBrutoCalculator.java), [DescontoCalculator](src/main/java/com/bcopstein/v4/DescontoCalculator.java), [IssqnCalculator](src/main/java/com/bcopstein/v4/IssqnCalculator.java), [ValorPagarCalculator](src/main/java/com/bcopstein/v4/ValorPagarCalculator.java), e implementações [CalcValorBrutoPadrao](src/main/java/com/bcopstein/v4/CalcValorBrutoPadrao.java), [CalcPromoSemPromo](src/main/java/com/bcopstein/v4/CalcPromoSemPromo.java), [CalcPromoPrimeiraCompra](src/main/java/com/bcopstein/v4/CalcPromoPrimeiraCompra.java), [CalcPromoBlackFriday](src/main/java/com/bcopstein/v4/CalcPromoBlackFriday.java), [CalcIssqnRS](src/main/java/com/bcopstein/v4/CalcIssqnRS.java), [CalcIssqnSC](src/main/java/com/bcopstein/v4/CalcIssqnSC.java), [CalcValorPagarPadrao](src/main/java/com/bcopstein/v4/CalcValorPagarPadrao.java), além de [CustoServicoDTO](src/main/java/com/bcopstein/v4/CustoServicoDTO.java), [Promocao](src/main/java/com/bcopstein/v4/Promocao.java), [Estado](src/main/java/com/bcopstein/v4/Estado.java).

## Regras de Cálculo

- Valor bruto: `valorHora * quantidadeDeHoras`.
- Desconto por promoção:
    - `SEMPROMO`: 0%
    - `PRIMEIRACOMPRA`: 10%
    - `BLACKFRIDAY`: 25%
- ISSQN por estado:
    - `RS`: `<100` → 0%; `100..1000` → 15%; `>1000` → 25%
    - `SC`: 20%
- Valor a pagar: `valorBruto + issqn - desconto`.

## Uso por Versão

- V1: chamada estática
    - `CustoServicoV1.calculaCustoServico(valorHora, quantidade, Promocao, Estado)` retorna `CustoServicoDTO`.
- V2: igual à V1, porém com extração em métodos privados.
- V3: orquestra três classes (`CalculadoraValorBruto`, `CalculadoraDesconto`, `CalculadoraISSQN`).
    - Possui setters para trocar calculadoras em runtime.
- V4: baseada em interfaces.
    - Construtor recebe apenas `ValorBrutoCalculator` (há default). O método `calculaCustoServico(...)` recebe as calculadoras de promoção e ISS; `ValorPagarCalculator` é configurável via setter (default incluso).

Veja [src/main/java/com/bcopstein/App.java](src/main/java/com/bcopstein/App.java) para um exemplo simples com a V4.

## Testes

As suítes de testes cobrem os principais cenários em cada versão:
- V1: [src/test/java/com/bcopstein/v1/CustoServicoV1Test.java](src/test/java/com/bcopstein/v1/CustoServicoV1Test.java)
- V2: [src/test/java/com/bcopstein/v2/CustoServicoV2Test.java](src/test/java/com/bcopstein/v2/CustoServicoV2Test.java)
- V3: [src/test/java/com/bcopstein/v3/CustoServicoV3Test.java](src/test/java/com/bcopstein/v3/CustoServicoV3Test.java)
- V4: [src/test/java/com/bcopstein/v4/CustoServicoV4Test.java](src/test/java/com/bcopstein/v4/CustoServicoV4Test.java)

Para executar os testes:

```
mvn -q test
```

## Notas

- O objetivo didático é mostrar a evolução arquitetural: monolítico → extração de métodos → composição por classes → contratos via interfaces.
- A estrutura facilita extensões: novas promoções, novos estados, ou novas regras de cálculo por versão.
