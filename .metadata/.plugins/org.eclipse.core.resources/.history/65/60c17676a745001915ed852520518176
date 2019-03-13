package br.com.codever.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.codever.model.CarrinhoCompras;
import br.com.codever.repository.CarrinhoComprasRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api")
@Api(value="API REST Carrinho")
@CrossOrigin(origins="*")
public class CarrinhoComprasController {

	@Autowired
	CarrinhoComprasRepository carrinhoComprasRepository;
	
	@GetMapping("/carrinhos")
	@ApiOperation(value="Retorna uma lista de carrinhos de compra")
	public List<CarrinhoCompras> listaCarrinhos(){
		return carrinhoComprasRepository.findAll();
	}
	
	@GetMapping("/carrinho/{id}")
	@ApiOperation(value="Retorna um produto específico")
	public CarrinhoCompras listaCarrinho(@PathVariable(value="id") long id){
		return carrinhoComprasRepository.findById(id);
	}
	
	@PostMapping("/carrinho")
	@ApiOperation(value="Salva um produto")
	public CarrinhoCompras salvaCarrinho(@RequestBody CarrinhoCompras carrinhoCompras) {
		return carrinhoComprasRepository.save(carrinhoCompras);
	}
	
	@DeleteMapping("/carrinho")
	@ApiOperation(value="Deleta um produto")
	public void deletaCarrinho(@RequestBody CarrinhoCompras carrinhoCompras){
		carrinhoComprasRepository.delete(carrinhoCompras);
	}
	
	@PutMapping("/carrinho")
	@ApiOperation(value="Atualiza um produto")
	public CarrinhoCompras atualizaCarrinho(@RequestBody CarrinhoCompras carrinhoCompras) {
		
		return carrinhoComprasRepository.save(carrinhoCompras);
	}
	
}
