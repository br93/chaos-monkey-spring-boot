package com.example.loja.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.loja.entities.Produto;
import com.example.loja.exceptions.ProdutoNotFoundException;
import com.example.loja.repositories.ProdutoRepository;

@Service

public class ProdutoService {
	
	private final ProdutoRepository produtoRepository;
	
	public ProdutoService(ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}
	
	public Produto criarProduto (Produto produto) {
		return produtoRepository.save(produto);
	}
	
	public Produto buscarProduto (Long id) {
		Optional<Produto> optional = produtoRepository.findById(id);
		
		return optional.orElseThrow(ProdutoNotFoundException::new);
	}
	
	
	/*Antes de ChaosMonkey
	public List<Produto> listarProdutos() {
		return produtoRepository.findAll();
	} */
	
	public List<Produto> listarProdutos() {
		List<Produto> listaProdutos = null;
		try {
			listaProdutos = produtoRepository.findAll();
		} catch (Exception e) {
			System.out.println("Exceção capturada");
			listaProdutos = new ArrayList<>();
		}
		return listaProdutos;
	}
	
	public Produto atualizarProduto (Long id, Produto novoProduto) {
		Produto produto = this.buscarProduto(id);
		novoProduto.setId(produto.getId());
		
		return novoProduto;
	}
	
	public void excluirProduto(Long id) {
		Produto produto = this.buscarProduto(id);
		produtoRepository.delete(produto);
	}

}
