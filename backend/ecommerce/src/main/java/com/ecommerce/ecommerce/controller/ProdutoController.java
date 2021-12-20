package com.ecommerce.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.ecommerce.model.Produto;
import com.ecommerce.ecommerce.service.ProdutoService;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoController {
	
	@Autowired
	ProdutoService produtoService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Produto> getProdutos() {
		List<Produto> produtos = produtoService.getProdutos();
		return produtos;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public Produto getProdutoById(@PathVariable Integer id) {
		Produto produto = produtoService.getProdutoById(id);
		return produto;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/categoria/{idCategoria}")
	public List<Produto> getProdutoByCategoria(@PathVariable Integer idCategoria) {
		List<Produto> produtos = produtoService.getProdutoByCategoria(idCategoria);
		return produtos;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/cor/{idCor}")
	public List<Produto> getProdutoByCor(@PathVariable Integer idCor) {
		List<Produto> produtos = produtoService.getProdutoByCor(idCor);
		return produtos;
	}
}
