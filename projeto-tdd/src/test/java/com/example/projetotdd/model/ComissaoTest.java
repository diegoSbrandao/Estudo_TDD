package com.example.projetotdd.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootTest
public class ComissaoTest {

    @TestConfiguration
    static class ComissaoConfiguracao{

        @Bean
        public Comissao comissao(){
            return new Comissao();
        }
    }

    @Autowired
    Comissao comissao;

        @Test
        public void deve_calcular_100_reais_de_comissao_para_venda_de_1000_com_10_por_cento(){
            //Arrange = Preparação
            Double valorVenda = 1000.00;
            Double valorComissao = 100.00;

            //Act = Ação
            Double valorCalculado = comissao.calcular(valorVenda);

            //Assert = Confirmação
            Assertions.assertEquals(valorComissao,valorCalculado);
        }

    @Test
    public void deve_calcular_300_reais_de_comissao_para_venda_de_2000_com_15_por_cento(){
        //Arrange = Preparação
        Double valorVenda = 2000.00;
        Double valorComissao = 300.00;

        //Act = Ação
        Double valorCalculado = comissao.calcular(valorVenda);

        //Assert = Confirmação
        Assertions.assertEquals(valorComissao,valorCalculado);
    }

}
