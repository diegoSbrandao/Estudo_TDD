package com.example.projetotdd.model;

import lombok.Data;

@Data
public class Produto {

    private Long id;
    private String nome;
    private Integer quantidade;
    private Double desconto;
    private Double acrescimo;
    private Double valor;

    public Double calcularValorTotal(){
        return (quantidade * valor) + acrescimo -desconto;
    }
}
