package com.example.projetotdd.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootTest
public class ProdutoTest {

    @TestConfiguration
    static class ProdutoConfiguracao{

        @Bean
        public Produto produto(){
            return new Produto();
        }
    }

    @Autowired
    Produto produto;

    @Test
    public void deve_calcular_valor_total_produto(){
        //Arrange = Preparação
        produto.setQuantidade(10);
        produto.setDesconto(10.0);
        produto.setAcrescimo(0.0);
        produto.setValor(10.0);

        double resultadoEsperado = 90.0;

        //Act = Ação
        Double resultado = produto.calcularValorTotal();

        //Assert = Confirmação
        Assertions.assertEquals(resultadoEsperado, resultado);
    }
}
