package com.example.projetotdd.service;

import com.example.projetotdd.model.Produto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    public List<Produto> obterTodos() {
        List<Produto> produtos = new ArrayList<>();
        return produtos;
    }

    public Optional<Produto> obterPorId(Long id) {
        Optional<Produto> produtos = Optional.of(new Produto());
        return produtos;
    }

    public Produto adicionar(Produto produto) {
        return produto;
    }
}
