package com.liz;

public class Cliente {
    private String nome;
    private String CPF;
    private int pontos;
   
    
    public Cliente(String nome, String CPF) { 
        this.nome = nome;
        this.CPF = CPF;
        this.pontos = 0; 
    }

    // Método para calcular e guardar pontos de uma compra
    public void registraCPontos(double valor) { 
        if (valor <= 100) {
            this.pontos += 1;
        } else if (valor <= 500) {
            this.pontos += (int) (valor / 100);
        } else if (valor > 500) {
            this.pontos += (int) (valor / 500) * 5;
        }
    } 

    // Método para aplicar desconto usando os pontos
    public double registraCDesconto(double valor) {
        if (this.pontos < 10) {
            return valor; 
        } else if (this.pontos >= 10 && this.pontos <= 50) { 
            this.pontos -= 10; // Gasta 10 pontos
            return valor - (valor * 0.10); // 10% de desconto
        } else { // Acima de 50 pontos
            this.pontos -= 10; // Gasta 10 pontos
            return valor - (valor * 0.20); // 20% de desconto
        }
    }


    public String getNome() {
        return this.nome; // Retorna o nome do cliente
    }

    public String getCPF() {
        return this.CPF; 
    }


    public int getPontos() {
        return this.pontos; 
    }
}