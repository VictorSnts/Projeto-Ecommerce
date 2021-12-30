package com.ecommerce.ecommerce.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.ecommerce.model.Categoria;
import com.ecommerce.ecommerce.repository.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	CategoriaRepository categoriaRepo;
	
	
	public Categoria getCategoriaById(Integer id){
		Optional<Categoria> categoria = categoriaRepo.findById(id);
		
		if(!categoria.isEmpty()) return categoria.get();
		else throw new IllegalArgumentException("Nenhuma categoria cadastrada com o id [" + id + "]!");
	}
	
}
