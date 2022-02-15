package com.example.projetotdd.controller;

import com.example.projetotdd.model.Produto;
import com.example.projetotdd.service.ProdutoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@WebMvcTest
public class ProdutoControllerTest {
    //MockMVC
    //Mockito
    //Mock

    @Autowired
    private ProdutoController produtoController;

    @MockBean
    private ProdutoService produtoService;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void setup(){
        //Executado antes de qualquer caso de teste.
        this.mockMvc = MockMvcBuilders.standaloneSetup(produtoController).build();
    }

    @Test
    public void deve_retornar_status_200_ok_ao_chamar_o_metodo_obter_todos_os_produtos() throws Exception {
        //Arrange = Preparação
        List<Produto> produtoList = new ArrayList<>();
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/produtos");
        when(this.produtoService.obterTodos()).thenReturn(produtoList);

        //Act - Ação
       this.mockMvc.perform(requestBuilder)
        //Assert = Confirmação
        .andExpect(MockMvcResultMatchers.status().isOk());
    }
    @Test
    public void deve_retornar_o_produto_por_id() throws Exception {
        //Arrange = Preparação
        Produto produto = new Produto();
        produto.setId(2L);
        produto.setNome("Martelo");
        produto.setQuantidade(10);

        Optional<Produto> optionalProduto = Optional.of(produto);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/produtos/2");

        when(this.produtoService.obterPorId(2L)).thenReturn(optionalProduto);

        //Act - Ação
        this.mockMvc.perform(requestBuilder)
                //Assert = Confirmação
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(2L));
    }

    @Test
    public void deve_adicionar_o_produto() throws Exception {
        //Arrange = Preparação.
        //Criando o produto que será adicionado.
        Produto produto = new Produto();
        produto.setNome("Martelo");
        produto.setQuantidade(10);

        //Convertendo o produto em um json.
        String json = new ObjectMapper().writeValueAsString(produto);

        //Criando a requisição do tipo post.
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/v1/produtos")
        .content(json)
        .contentType(MediaType.APPLICATION_JSON);

        //Adicionando o id ao produto que iremos retornar.
        produto.setId(1L);

        when(this.produtoService.adicionar(produto)).thenReturn(produto);

        //Act - Ação
        this.mockMvc.perform(requestBuilder)
                //Assert = Confirmação
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }
}
