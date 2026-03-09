package com.liz;

public class NovoSwitchExemplos {

    public static void main(String[] args) {

        System.out.println("=== Switch como EXPRESSÃO ===");
        int dia = 6;

        String nomeDia = switch (dia) {
            case 1 -> "Domingo";
            case 2 -> "Segunda";
            case 3 -> "Terça";
            case 4 -> "Quarta";
            case 5 -> "Quinta";
            case 6 -> "Sexta";
            case 7 -> "Sábado";
            default -> "Dia inválido";
        };

        System.out.println("Dia " + dia + " = " + nomeDia);

        System.out.println("\n=== Switch com múltiplos rótulos ===");
        String tipo = "TXT";

        String categoria = switch (tipo) {
            case "PNG", "JPG", "GIF" -> "Imagem";
            case "TXT", "LOG" -> "Texto";
            case "PDF" -> "Documento PDF";
            default -> "Outro tipo";
        };

        System.out.println("Tipo " + tipo + " é da categoria: " + categoria);

        System.out.println("\n=== Switch com bloco e yield ===");
        int idade = 3;

        String classificacao = switch (idade) {
            case 0, 1, 2 -> "Bebê";
            case 3, 4, 5 -> "Criança pequena";
            default -> {
                if (idade < 13) {
                    yield "Criança";
                } else if (idade < 18) {
                    yield "Adolescente";
                } else {
                    yield "Adulto";
                }
            }
        };

        System.out.println("Classificação: " + classificacao);

        System.out.println("\n=== Switch com comportamento tradicional (compatibilidade) ===");

        int mes = 2;
        String nomeMes;

        switch (mes) {
            case 1:
                nomeMes = "Janeiro";
                break;
            case 2:
                nomeMes = "Fevereiro";
                break;
            default:
                nomeMes = "Outro mês";
        }

        System.out.println("Mês " + mes + " = " + nomeMes);

        System.out.println("\n=== Switch com pattern matching (Java 17 preview) ===");

        Object valor = 42;

        String resultado = switch (valor) {
            case Integer i -> "Número inteiro: " + i;
            case String s -> "Texto: " + s;
            case null -> "Valor nulo";
            default -> "Outro tipo";
        };

        System.out.println(resultado);
    }
}