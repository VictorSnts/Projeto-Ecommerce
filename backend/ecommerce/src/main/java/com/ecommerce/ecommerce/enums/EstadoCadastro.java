package com.ecommerce.ecommerce.enums;

public enum EstadoCadastro {
	ATIVO(1, "Ativo"),
	INATIVO(2, "Inativo");

	private Integer id;
	private String descricao;
	
	private EstadoCadastro(Integer id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	public Integer getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}
	
	
	public static EstadoCadastro toEnum(Integer id) {
		if(id == null) {
			return null;
		}
		
		for(EstadoCadastro estado : EstadoCadastro.values()) {
			if(id.equals(estado.getId())) {
				return estado;
			}
		}
		throw new IllegalArgumentException("Nenhum tipo cadastrado com id ["+ id + "]");
	}
}
