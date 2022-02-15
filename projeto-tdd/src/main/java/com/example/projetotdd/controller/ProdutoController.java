package com.example.projetotdd.controller;

import com.example.projetotdd.model.Produto;
import com.example.projetotdd.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/produtos")
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<List<Produto>> obterTodos(){
        List<Produto> produtos = produtoService.obterTodos();
        return new ResponseEntity<>(produtos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Produto>> obterPorId(@PathVariable Long id){
        Optional<Produto> produtos = produtoService.obterPorId(id);
        return new ResponseEntity<>(produtos, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Produto> adicionar(@RequestBody Produto produto){
        return new ResponseEntity<>(produtoService.adicionar(produto), HttpStatus.CREATED);
    }
}
