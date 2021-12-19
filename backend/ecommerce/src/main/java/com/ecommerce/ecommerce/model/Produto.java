package com.ecommerce.ecommerce.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;
	
	private Double preco;
	
	private String descricao;
	
	private Double avalidacao;
	
	private Double peso;
	
	@ManyToOne
	@JoinColumn(name = "corPredominante_id")
	private Cor corPredominante;
	
	@ManyToOne
	@JoinColumn(name = "marca_id")
	private Marca marca;

	@ManyToOne
	@JoinColumn(name = "categoria_id")
	private Categoria categoria;

}