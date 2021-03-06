package br.com.codever.resource;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.codever.model.Carrinho;
import br.com.codever.repository.CarrinhoRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api")
@Api(value="API REST Carrinho")
@CrossOrigin(origins="*")
public class CarrinhoResource {

	@Autowired
	CarrinhoRepository carrinhoRepository;
	
	@GetMapping("/carrinhos")
	@ApiOperation(value="Retorna uma lista de carrinhos de compra")
	public List<Carrinho> listaCarrinhos(){
		return carrinhoRepository.findAll();
	}
	
	@GetMapping("/carrinhos/{id}")
	@ApiOperation(value="Retorna um produto específico")
	public Carrinho listaCarrinho(@PathVariable(value="id") long id){
		return carrinhoRepository.findById(id);
	}
	
	@PostMapping("/carrinhos")
	@ApiOperation(value="Salva um produto")
	public ResponseEntity<?> salvaCarrinho(@RequestBody Carrinho carrinho) {
		return new ResponseEntity<Carrinho> (carrinhoRepository.save(carrinho), HttpStatus.OK);
	}
	
	@DeleteMapping("/carrinhos/{id}")
	@ApiOperation(value="Deleta um produto")
	public ResponseEntity<?> deletaCarrinho(@PathVariable(value="id") long id){
		Carrinho c = carrinhoRepository.findById(id);
		if (c == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		carrinhoRepository.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping("/carrinhos")
	@ApiOperation(value="Atualiza um produto")
	public Carrinho atualizaCarrinho(@RequestBody Carrinho carrinhoCompras) {
		return carrinhoRepository.save(carrinhoCompras);
	}
	
}
