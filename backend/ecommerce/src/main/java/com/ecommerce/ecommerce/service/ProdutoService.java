package com.ecommerce.ecommerce.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.ecommerce.model.Categoria;
import com.ecommerce.ecommerce.model.Produto;
import com.ecommerce.ecommerce.repository.CategoriaRepository;
import com.ecommerce.ecommerce.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	ProdutoRepository produtoRepo;
	
	@Autowired
	CategoriaRepository categoriaRepo;
	
	public List<Produto> getProdutos(){
		List<Produto> produtos = produtoRepo.findAll();
		
		if(!produtos.isEmpty()) return produtos;
		else throw new EntityNotFoundException("Nenhum produto cadastrado na base de dados!");
	}
	
	public Produto getProdutoById(Integer id){
		Optional<Produto> produto = produtoRepo.findById(id);
		
		if(!produto.isEmpty()) return produto.get();
		else throw new IllegalArgumentException("Nenhum produto cadastrado com o id [" + id + "]!");
	}
	
	public List<Produto> getProdutoByCategoria(Integer idCategoria){
		Optional<Categoria> categoria = categoriaRepo.findById(idCategoria);
		if(!categoria.isEmpty()) {
			List<Produto> produtos = produtoRepo.findByCategoria(categoria.get());
			if(!produtos.isEmpty()) return produtos;
			else throw new EntityNotFoundException("Nenhum produto cadastrado com essa categoria na base de dados!");
		} else {
			throw new IllegalArgumentException("Nenhuma categoria cadastrada com id [" + idCategoria + "]!");
		}
	}
	
}
