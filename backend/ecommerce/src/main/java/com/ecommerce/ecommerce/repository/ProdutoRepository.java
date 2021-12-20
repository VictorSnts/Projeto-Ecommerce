
package com.ecommerce.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ecommerce.ecommerce.model.Categoria;
import com.ecommerce.ecommerce.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
	@Query("SELECT DISTINCT p FROM Produto AS p WHERE categoria LIKE :categoria")
	public List<Produto> findByCategoria(@Param("categoria") Categoria categoria);
}