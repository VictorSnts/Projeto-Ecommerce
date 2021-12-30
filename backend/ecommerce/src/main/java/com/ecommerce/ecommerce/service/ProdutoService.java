package com.ecommerce.ecommerce.service;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ecommerce.ecommerce.model.Categoria;
import com.ecommerce.ecommerce.model.Cor;
import com.ecommerce.ecommerce.model.Marca;
import com.ecommerce.ecommerce.model.Produto;
import com.ecommerce.ecommerce.repository.CategoriaRepository;
import com.ecommerce.ecommerce.repository.CorRepository;
import com.ecommerce.ecommerce.repository.MarcaRepository;
import com.ecommerce.ecommerce.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	ProdutoRepository produtoRepo;

	@Autowired
	CategoriaRepository categoriaRepo;

	@Autowired
	CorRepository corRepo;

	@Autowired
	MarcaRepository marcaRepo;

	// Retorna uma lista de produtos pagiado para o controller, com a possibilidade
	// de buscar por nome de produto.
	public Page<Produto> getProdutos(Pageable pageable, String busca, Integer idCategoria, Integer idMarca,
			Integer idCor) {

		Optional<Categoria> categoria = null;
		Optional<Marca> marca = null;
		Optional<Cor> cor = null;

		if (!(idCategoria == null)) {
			categoria = categoriaRepo.findById(idCategoria);
		}
		if (!(idMarca == null)) {
			marca = marcaRepo.findById(idMarca);
		}
		if (!(idCor == null)) {
			cor = corRepo.findById(idCor);
		}

		Page<Produto> produtos = null;

		if (categoria == null && marca == null && cor == null) { // Sem Filtro
			produtos = produtoRepo.findAll(pageable, busca);

		} else if (!(categoria == null) && !(marca == null) && !(cor == null)) { // Todos os filtros
			produtos = produtoRepo.findFilter(pageable, busca, categoria.get(), marca.get(), cor.get());

		} else if (!(categoria == null) && !(marca == null) && (cor == null)) { // Filtro Categoria e Marca
			produtos = produtoRepo.findFilter(pageable, busca, categoria.get(), marca.get());

		} else if (!(categoria == null) && (marca == null) && !(cor == null)) { // Filtro Categoria e Cor
			produtos = produtoRepo.findFilter(pageable, busca, categoria.get(), cor.get());

		} else if ((categoria == null) && !(marca == null) && !(cor == null)) { // Filtro Marca e Cor
			produtos = produtoRepo.findFilter(pageable, busca, marca.get(), cor.get());

		} else if (!(categoria == null) && (marca == null) && (cor == null)) { // Filtro Categoria
			produtos = produtoRepo.findFilter(pageable, busca, categoria.get());

		} else if ((categoria == null) && !(marca == null) && (cor == null)) { // Filtro Marca
			produtos = produtoRepo.findFilter(pageable, busca, marca.get());

		} else if ((categoria == null) && (marca == null) && !(cor == null)) { // Filtro Cor
			produtos = produtoRepo.findFilter(pageable, busca, cor.get());

		}

		if (!produtos.isEmpty())
			return produtos;
		else
			throw new EntityNotFoundException("Nenhum produto cadastrado na base de dados!");
	}

	// Retorna um produto especifico, de acordo com ID informado, para o controller
	public Produto getProdutoById(Integer id) {
		Optional<Produto> produto = produtoRepo.findById(id);

		if (!produto.isEmpty())
			return produto.get();
		else
			throw new IllegalArgumentException("Nenhum produto cadastrado com o id [" + id + "]!");
	}

	// Retorna uma lista paginada de produtos de uma categoria especifica para o
	// controller
	public Page<Produto> getProdutosByCategoria(Integer idCategoria, Pageable pageable) {
		Optional<Categoria> categoria = categoriaRepo.findById(idCategoria);

		if (!categoria.isEmpty()) {
			Page<Produto> produtos = produtoRepo.findByCategoria(categoria.get(), pageable);

			if (!produtos.isEmpty())
				return produtos;
			else
				throw new EntityNotFoundException("Nenhum produto cadastrado com essa categoria na base de dados!");
		} else {
			throw new IllegalArgumentException("Nenhuma categoria cadastrada com id [" + idCategoria + "]!");
		}
	}

	// Retorna uma lista paginada de produtos de uma cor especifica para o
	// controller
	public Page<Produto> getProdutosByCor(Integer idCor, Pageable pageable) {
		Optional<Cor> cor = corRepo.findById(idCor);

		if (!cor.isEmpty()) {
			Page<Produto> produtos = produtoRepo.findByCor(cor.get(), pageable);
			if (!produtos.isEmpty())
				return produtos;
			else
				throw new EntityNotFoundException("Nenhum produto cadastrado com essa cor na base de dados!");
		} else {
			throw new IllegalArgumentException("Nenhuma cor cadastrada com id [" + idCor + "]!");
		}
	}

}
