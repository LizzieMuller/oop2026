package com.liz;

public class Main {
    public static void main(String[] args) {
        
        // 1. Criando um novo cliente
        Cliente cliente1 = new Cliente("Carolina", "123.456.789-00");
        System.out.println("Bem-vinda, " + cliente1.getNome() + "!");
        System.out.println("Pontos iniciais: " + cliente1.getPontos());
        System.out.println("--------------------------------------------------");

        // 2. Simulando compras APENAS para ganhar pontos
        System.out.println("COMPRANDO E ACUMULANDO PONTOS:");
        
        // Compra até R$ 100 (Ganha 1 ponto)
        cliente1.registraCPontos(50.0);
        System.out.println("Compra de R$ 50,00 registrada. Pontos atuais: " + cliente1.getPontos());
        
        // Compra entre R$ 101 e R$ 500 (Ganha 1 ponto a cada R$ 100 -> 2 pontos)
        cliente1.registraCPontos(250.0);
        System.out.println("Compra de R$ 250,00 registrada. Pontos atuais: " + cliente1.getPontos());
        
        // Compra acima de R$ 500 (Ganha 5 pontos a cada R$ 500 -> 10 pontos)
        cliente1.registraCPontos(1200.0);
        System.out.println("Compra de R$ 1200,00 registrada. Pontos atuais: " + cliente1.getPontos());
        
        // Total esperado aqui: 1 + 2 + 10 = 13 pontos
        System.out.println("--------------------------------------------------");

        // 3. Simulando uma compra usando o DESCONTO
        System.out.println("USANDO DESCONTO:");
        double valorDaNovaCompra = 200.0;
        
        System.out.println("Valor original da compra: R$ " + valorDaNovaCompra);
        System.out.println("O cliente tem " + cliente1.getPontos() + " pontos. (Direito a 10% de desconto)");
        
        // Chamamos o método que calcula o desconto e já subtrai os 10 pontos
        double valorFinal = cliente1.registraCDesconto(valorDaNovaCompra);
        
        System.out.println("Valor a pagar com desconto: R$ " + valorFinal); 
        System.out.println("Saldo de pontos após a compra: " + cliente1.getPontos()); // Deve sobrar 3 pontos
    }
}