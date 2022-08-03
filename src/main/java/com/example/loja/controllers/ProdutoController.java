package com.example.loja.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.loja.entities.Produto;
import com.example.loja.services.ProdutoService;

@RestController
@RequestMapping("v1/produtos")
public class ProdutoController {

	private final ProdutoService produtoService;

	public ProdutoController(ProdutoService produtoService) {
		this.produtoService = produtoService;
	}

	@GetMapping
	public ResponseEntity<List<Produto>> listarProdutos() {
		List<Produto> lista = produtoService.listarProdutos();
		return new ResponseEntity<List<Produto>>(lista, HttpStatus.OK);
	}

	@GetMapping("{id}")
	public ResponseEntity<Produto> buscarProduto(@PathVariable Long id) {
		Produto produto = produtoService.buscarProduto(id);
		return new ResponseEntity<Produto>(produto, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Produto> salvarProduto(@RequestBody Produto produto) {
		Produto novoProduto = produtoService.criarProduto(produto);
		return new ResponseEntity<Produto>(novoProduto, HttpStatus.CREATED);
	}

	@PutMapping("{id}")
	public ResponseEntity<Produto> atualizarProduto(@RequestBody Produto produto, @PathVariable Long id) {
		Produto produtoAtualizado = produtoService.atualizarProduto(id, produto);
		return new ResponseEntity<Produto>(produtoAtualizado, HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<Produto> deletarProduto(@PathVariable Long id) {
		produtoService.excluirProduto(id);
		return new ResponseEntity<Produto>(HttpStatus.NO_CONTENT);
	}

}
