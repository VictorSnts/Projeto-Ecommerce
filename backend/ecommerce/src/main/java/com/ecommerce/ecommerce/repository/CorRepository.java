package com.ecommerce.ecommerce.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.ecommerce.model.Cor;

@Repository
public interface CorRepository extends JpaRepository<Cor, Integer> {

}