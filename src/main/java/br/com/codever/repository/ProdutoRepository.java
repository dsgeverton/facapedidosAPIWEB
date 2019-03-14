package br.com.codever.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.codever.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

	Produto findById(long id);
	
	List<Produto> findAll();
	
}
