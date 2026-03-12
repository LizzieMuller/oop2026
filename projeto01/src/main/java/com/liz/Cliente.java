package com.liz;

public class Cliente {
    private String nome;
    private String CPF;
    private int pontos;
   

    public Cliente(String nome, String CPF) { // guarda a info do cliente
        this.CPF = CPF;
        this.nome = nome;
        this.pontos = 0;
    }

    public void registraCPontos(double valor) { // guarda o valor da compra e calcula os pontos
        if (valor <= 100) {
            this.pontos += 1;
        } else if (valor <= 500) {
            this.pontos += (int) (valor / 100);
        } else if (valor > 500) {
            this.pontos += (int) (valor / 500) * 5;
        }
    } 

    public double registraCDesconto(double valor) {
        if (this.pontos < 10) {
            return valor;
        } else if (this.pontos >= 10 && this.pontos <= 50) { 
            this.pontos -= 10;
            return valor - (valor * 0.1);
        } else {
            this.pontos -= 10;
            return valor - (valor * 0.2); 
            
        }
    }

    public String getNome() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getNome'");
    }

    public String getPontos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPontos'");
    }
}