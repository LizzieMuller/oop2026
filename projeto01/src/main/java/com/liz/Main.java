package com.liz;

public class Main {
    public static void main(String[] args) {
      
        Cliente cliente = new Cliente("12345678900", "João Silva");
        System.out.println("Cliente " + cliente.getNome() + " cadastrado com sucesso!");
        System.out.println(cliente.getPontos() + "Saldo inicial de pontos: ");
        System.out.println("--------------------------------------------------");

        // 2. Cliente faz compras para ACUMULAR pontos
        System.out.println("🛒 Registrando compras para pontuação...");
        
        // Compra de R$ 80,00 (Até 100 = 1 ponto)
        cliente.registraCPontos(80.0); 
        
        // Compra de R$ 250,00 (Entre 101 e 500 = 250/100 = 2 pontos)
        cliente.registraCPontos(250.0);
        
        // Compra de R$ 1.200,00 (Acima de 500 = (1200/500)*5 = 2 * 5 = 10 pontos)
        cliente.registraCPontos(1200.0);

        // Saldo esperado: 1 + 2 + 10 = 13 pontos
        System.out.println("Saldo atual de pontos: " + cliente.getPontos());
        System.out.println("--------------------------------------------------");

        // 3. Cliente faz uma compra e decide USAR O DESCONTO
        System.out.println("💸 Registrando nova compra com uso de desconto...");
        double valorDaNovaCompra = 200.0;
        
        System.out.println("Valor original da compra: R$ " + valorDaNovaCompra);
        
        // Como o cliente tem 13 pontos, ele cai na regra "Entre 10 e 50 pontos" (10% de desconto)
        double valorAposDesconto = cliente.registraCDesconto(valorDaNovaCompra);
        
        System.out.println("Valor final a pagar (com desconto): R$ " + valorAposDesconto);
        System.out.println("Saldo de pontos após gastar 10 pontos: " + cliente.getPontos());
    }
}