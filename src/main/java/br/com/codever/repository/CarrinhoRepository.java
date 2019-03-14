package br.com.codever.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.codever.model.Carrinho;

public interface CarrinhoRepository extends JpaRepository<Carrinho, Long>{

	Carrinho findById(long id);

	List<Carrinho> findAll();
	
}
