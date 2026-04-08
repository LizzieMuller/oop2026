# Enunciado

- Precisa-se de uma classe capaz de calcular o custo de um serviço
    - Entradas
        - Valor da hora técnica
        - Quantidade de horas técnicas
        - Nome da promoção
        - Estado brasileiro onde o serviços será oferecido (por enquanto apenas RS e SC)
    - Saidas:
        - Custo bruto do serviço (por enquanto apenas multiplicar o valor da hora pela quantidade de horas)
        - Valor do desconto (varia conforme a promoção informada)
        - Valor do ISSQN (varia conforme o estado)
        - Valor a pagar
- Serão desenvolvidas 4 versões
    - Uma classe com um método que faz tudo
    - Uma classe com méodos privados auxiliares
    - uma classe que depende de 3 outras classes
    - uma classe que depende de interfaces

OBS: todos os valores serão informados como inteiros multiplicados por 100

Prever as possibilidades de alteração:

- Alterações simples: mais promos, mais estados
- Alterações mais complexas: mais parãmetros em cada tipo de calculo (exemplo saber o mês para uma promo); saber o estado e o estado e a distancia da base conforme para o cálculo do custo

