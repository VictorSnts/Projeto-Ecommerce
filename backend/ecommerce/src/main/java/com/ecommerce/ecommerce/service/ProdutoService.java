package com.ecommerce.ecommerce.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.ecommerce.model.Produto;
import com.ecommerce.ecommerce.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	ProdutoRepository produtoRepo;
	
	public List<Produto> getProdutos(){
		List<Produto> produtos = produtoRepo.findAll();
		
		if(!produtos.isEmpty()) return produtos;
		else throw new EntityNotFoundException("Nenhum produto cadastrado na base de dados!");
	}
	
	public Produto getProduto(Integer id){
		Optional<Produto> produto = produtoRepo.findById(id);
		
		if(!produto.isEmpty()) return produto.get();
		else throw new IllegalArgumentException("Nenhum produto cadastrado com o id [" + id + "]!");
	}
}
