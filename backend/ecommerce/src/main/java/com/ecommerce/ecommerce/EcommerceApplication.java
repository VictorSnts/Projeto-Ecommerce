package com.ecommerce.ecommerce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ecommerce.ecommerce.enums.EstadoCadastro;
import com.ecommerce.ecommerce.model.Categoria;
import com.ecommerce.ecommerce.model.Cor;
import com.ecommerce.ecommerce.model.Marca;
import com.ecommerce.ecommerce.model.Produto;
import com.ecommerce.ecommerce.repository.CategoriaRepository;
import com.ecommerce.ecommerce.repository.CorRepository;
import com.ecommerce.ecommerce.repository.MarcaRepository;
import com.ecommerce.ecommerce.repository.ProdutoRepository;

@SpringBootApplication
public class EcommerceApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(EcommerceApplication.class, args);
	}
	
	@Autowired
	CorRepository corRepo;
	@Autowired
	MarcaRepository marcaRepo;
	@Autowired
	CategoriaRepository categoriaRepo;
	@Autowired
	ProdutoRepository produtoRepo;
	 
	@Override
	public void run(String... args) throws Exception {
		
		Cor cor1 = new Cor(1, "BRANCO");
		Cor cor2 = new Cor(2, "PRETO");
		Cor cor3 = new Cor(3, "DOURADO");
		corRepo.save(new Cor(4, "MARROM"));
		corRepo.save(new Cor(5, "VERMELHO"));
		corRepo.save(new Cor(6, "AZUL"));
		corRepo.save(new Cor(7, "AMARELO"));
		corRepo.save(new Cor(8, "VERDE"));
		corRepo.save(new Cor(9, "LARANJA"));
		corRepo.save(new Cor(10, "ROXO"));
		corRepo.save(new Cor(11, "CINZA"));
		
		Marca marca1 = new Marca(1, "APPLE");
		Marca marca2 = new Marca(2, "SAMSUNG");
		marcaRepo.save(new Marca(3, "LG"));
		marcaRepo.save(new Marca(4, "MOTOROLA"));
		marcaRepo.save(new Marca(5, "DELL"));
		
		Categoria cat1 = new Categoria(1, "CELULARES");
		Categoria cat2 = new Categoria(2, "COMPUTADORES");
		categoriaRepo.save(new Categoria(3, "ELETRODOMESTICOS"));
		categoriaRepo.save(new Categoria(4, "HARDWARE"));
		categoriaRepo.save(new Categoria(5, "CADEIRAS"));
		categoriaRepo.save(new Categoria(6, "PERIFERICOS"));
		
		
		Produto produto1 = new Produto(1, "iPhone Xs Max 64GB", 3000.99, 
				"Lorem Ipsun Lorem Ipsun Lorem Ipsun Lorem Ipsun Lorem Ipsun Lorem "
				+ "Ipsun Lorem Ipsun  Lorem Ipsun", 
				4.0, 0.780, EstadoCadastro.ATIVO, cor1, marca1, cat1);
		cor1.getProdutos().add(produto1);
		marca1.getProdutos().add(produto1);

		Produto produto2 = new Produto(2, "iPhone Xs 64GB", 2400.99, 
				"Lorem Ipsun Lorem Ipsun Lorem Ipsun Lorem Ipsun Lorem Ipsun Lorem "
				+ "Ipsun Lorem Ipsun  Lorem Ipsun", 
				5.0, 0.623, EstadoCadastro.ATIVO, cor2, marca1, cat1);
		cor2.getProdutos().add(produto2);
		marca1.getProdutos().add(produto1);
		
		Produto produto3 = new Produto(3, "Galaxy Book 15'", 3400.99, 
				"Lorem Ipsun Lorem Ipsun Lorem Ipsun Lorem Ipsun Lorem Ipsun Lorem "
				+ "Ipsun Lorem Ipsun  Lorem Ipsun", 
				4.0,1.123, EstadoCadastro.ATIVO, cor3, marca2, cat2);
		cor3.getProdutos().add(produto3);
		marca2.getProdutos().add(produto3);

		produtoRepo.save(produto1);
		produtoRepo.save(produto2);
		produtoRepo.save(produto3);
		
		corRepo.save(cor1);
		corRepo.save(cor2);
		corRepo.save(cor3);

		marcaRepo.save(marca1);
		marcaRepo.save(marca2);
		
		categoriaRepo.save(cat1);
		categoriaRepo.save(cat2);
		





		
		

		
		
	}

}
