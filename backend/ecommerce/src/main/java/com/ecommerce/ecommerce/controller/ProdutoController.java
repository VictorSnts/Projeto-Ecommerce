package com.ecommerce.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.ecommerce.model.Produto;
import com.ecommerce.ecommerce.service.ProdutoService;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoController {

	@Autowired
	ProdutoService produtoService;

	// GET - Retorna lista paginada com todos os produtos, de acordo com a busca
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Page<Produto>> getProdutos(@RequestParam(value = "busca", defaultValue = "") String busca,
			@RequestParam(value = "cor", defaultValue = "") Integer idCor,
			@RequestParam(value = "marca", defaultValue = "") Integer idMarca,
			@RequestParam(value = "categoria", defaultValue = "") Integer idCategoria,
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "9") Integer size,
			@RequestParam(value = "sort", defaultValue = "id") String sort,
			@RequestParam(value = "order", defaultValue = "DESC") String order) {
		
		busca = busca.toUpperCase();

		Sort sortParm;
		if (order.equals("DESC")) {
			sortParm = Sort.by(sort).descending();
		} else {
			sortParm = Sort.by(sort).ascending();
		}

		Pageable pageable = PageRequest.of(page, size, sortParm);
		Page<Produto> produtos = produtoService.getProdutos(pageable, busca, idCategoria, idMarca, idCor);
		return ResponseEntity.ok(produtos);
	}

	// GET - Retorna um produto especifico, de acordo com o id informado
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public Produto getProdutoById(@PathVariable Integer id) {
		Produto produto = produtoService.getProdutoById(id);
		return produto;
	}

	// GET - Retorna lista paginada com todos os produtos, de acordo com a categoria
	// selecionada
	@RequestMapping(method = RequestMethod.GET, value = "/categoria/{idCategoria}")
	public ResponseEntity<Page<Produto>> getProdutosByCategoria(@PathVariable Integer idCategoria,
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "9") Integer size,
			@RequestParam(value = "sort", defaultValue = "id") String sort,
			@RequestParam(value = "order", defaultValue = "DESC") String order) {

		Sort sortParm;
		if (order.equals("DESC")) {
			sortParm = Sort.by(sort).descending();
		} else {
			sortParm = Sort.by(sort).ascending();
		}

		Pageable pageable = PageRequest.of(page, size, sortParm);
		Page<Produto> produtos = produtoService.getProdutosByCategoria(idCategoria, pageable);
		return ResponseEntity.ok(produtos);
	}

	// GET - Retorna lista paginada com todos os produtos, de acordo com a cor
	// selecionada
	@RequestMapping(method = RequestMethod.GET, value = "/cor/{idCor}")
	public Page<Produto> getProdutosByCor(@PathVariable Integer idCor,
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "9") Integer size,
			@RequestParam(value = "sort", defaultValue = "id") String sort,
			@RequestParam(value = "order", defaultValue = "DESC") String order) {

		Sort sortParm;
		if (order.equals("DESC")) {
			sortParm = Sort.by(sort).descending();
		} else {
			sortParm = Sort.by(sort).ascending();
		}

		Pageable pageable = PageRequest.of(page, size, sortParm);
		Page<Produto> produtos = produtoService.getProdutosByCor(idCor, pageable);
		return produtos;
	}
	
	/*
	public Produto postProduto(ProdutoDTO produto) {
		
		return null;
	}
	*/


}
