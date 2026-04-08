package com.bcopstein.v1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CustoServicoV1Test {

    @Test
    @DisplayName("RS: sem promo, faixa baixa (<100)")
    void rsSemPromoFaixaBaixa() {
        var dto = CustoServicoV1.calculaCustoServico(50, 1, Promocao.SEMPROMO, Estado.RS);
        assertEquals(50, dto.valorBruto());
        assertEquals(0, dto.desconto());
        assertEquals(0, dto.issqn());
        assertEquals(50, dto.valorPagar());
    }

    @Test
    @DisplayName("RS: PRIMEIRACOMPRA, faixa média (100..1000)")
    void rsPrimeiraCompraFaixaMedia() {
        var dto = CustoServicoV1.calculaCustoServico(250, 2, Promocao.PRIMEIRACOMPRA, Estado.RS); // bruto=500
        assertEquals(500, dto.valorBruto());
        assertEquals(50, dto.desconto()); // 10%
        assertEquals(75, dto.issqn());    // 15%
        assertEquals(525, dto.valorPagar()); // 500 + 75 - 50
    }

    @Test
    @DisplayName("RS: BLACKFRIDAY, faixa alta (>1000)")
    void rsBlackFridayFaixaAlta() {
        var dto = CustoServicoV1.calculaCustoServico(1000, 2, Promocao.BLACKFRIDAY, Estado.RS); // bruto=2000
        assertEquals(2000, dto.valorBruto());
        assertEquals(500, dto.desconto()); // 25%
        assertEquals(500, dto.issqn());    // 25%
        assertEquals(2000, dto.valorPagar()); // 2000 + 500 - 500
    }

    @Test
    @DisplayName("SC: sem promo, 20% ISSQN")
    void scSemPromo() {
        var dto = CustoServicoV1.calculaCustoServico(300, 3, Promocao.SEMPROMO, Estado.SC); // bruto=900
        assertEquals(900, dto.valorBruto());
        assertEquals(0, dto.desconto());
        assertEquals(180, dto.issqn()); // 20%
        assertEquals(1080, dto.valorPagar()); // 900 + 180
    }

    @Test
    @DisplayName("SC: BLACKFRIDAY aplica 25% e ISS 20%")
    void scBlackFriday() {
        var dto = CustoServicoV1.calculaCustoServico(400, 4, Promocao.BLACKFRIDAY, Estado.SC); // bruto=1600
        assertEquals(1600, dto.valorBruto());
        assertEquals(400, dto.desconto()); // 25%
        assertEquals(320, dto.issqn());    // 20%
        assertEquals(1520, dto.valorPagar()); // 1600 + 320 - 400
    }
}
