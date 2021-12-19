package com.ecommerce.ecommerce.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
public class Cor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;
		
	@JsonIgnore
	@OneToMany(mappedBy = "corPredominante", cascade = CascadeType.ALL)
	private List<Produto> produtos;
	
	public Cor(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
		this.produtos = new ArrayList<>();
	}
}
