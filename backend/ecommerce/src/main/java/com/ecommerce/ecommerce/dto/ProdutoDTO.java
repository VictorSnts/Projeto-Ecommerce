package com.ecommerce.ecommerce.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;

import com.ecommerce.ecommerce.model.Produto;
import com.ecommerce.ecommerce.repository.CategoriaRepository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

 public class ProdutoDTO {
	
	private Integer id;
	
	private String nome;
	
	private Double preco;
	
	private String descricao;
	
	private Double avalidacao;
	
	private Double peso;
	
	private Integer idEstadoCadastro;
	
	private Integer qtdEstoque;
	
	private Integer idCorPredominante;
	
	private Integer idMarca;

	private Integer idCategoria;
	
	
	public static Produto toEntity(ProdutoDTO produtoDTO) {
		
		
				
		Produto produto = new Produto();
		produto.setId(produtoDTO.getId());
		produto.setNome(produtoDTO.getNome());
		produto.setPreco(produtoDTO.getPreco());
		produto.setDescricao(produtoDTO.getDescricao());
		produto.setAvalidacao(produtoDTO.getAvalidacao());
		produto.setPeso(produtoDTO.getPeso());
//		produto.setCategoria(categoriaRepo.getById(produtoDTO.getIdCategoria()));
		produto.setQtdEstoque(produtoDTO.getQtdEstoque());
		
		
		
		
		return null;
		
	}
	

}