
package com.ecommerce.ecommerce.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ecommerce.ecommerce.model.Categoria;
import com.ecommerce.ecommerce.model.Cor;
import com.ecommerce.ecommerce.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
	
	@Query("SELECT DISTINCT p FROM Produto AS p WHERE nome LIKE %:busca%")
	public Page<Produto> findAll(Pageable pageable, @Param("busca") String busca);
	
	@Query("SELECT DISTINCT p FROM Produto AS p WHERE categoria LIKE :categoria")
	public Page<Produto> findByCategoria(@Param("categoria") Categoria categoria, Pageable pageable);
	
	@Query("SELECT DISTINCT p FROM Produto AS p WHERE corPredominante LIKE :cor")
	public Page<Produto> findByCor(@Param("cor") Cor cor, Pageable pageable);
}