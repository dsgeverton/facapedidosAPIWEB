package br.com.codever.resource;

import java.util.ArrayList;
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

import br.com.codever.model.Produto;
import br.com.codever.repository.ProdutoRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api")
@Api(value="API REST Produtos")
@CrossOrigin(origins="*")
public class ProdutoResource {

	@Autowired
	ProdutoRepository produtoRepository;
	
	@GetMapping("/produtos")
	@ApiOperation(value="Retorna uma lista de produtos")
	public List<Produto> listaProdutos(){
		return produtoRepository.findAll();
	}
	
	@GetMapping("/produtos/{id}")
	@ApiOperation(value="Retorna um produto específico")
	public Produto listaProduto(@PathVariable(value="id") long id){
		return produtoRepository.findById(id);
	}
	
	@GetMapping("/produtos/all")
	public ResponseEntity<List<Produto>> listar() {
		return new ResponseEntity<List<Produto>>(new ArrayList<Produto>(produtoRepository.findAll()), 
				HttpStatus.OK);
	}
	
	@PostMapping("/produtos")
	@ApiOperation(value="Salva um produto")
	public ResponseEntity<?> salvaProduto(@RequestBody Produto produto) {
		return new ResponseEntity<Produto> (produtoRepository.save(produto), HttpStatus.OK);
	}
	
	@DeleteMapping("/produtos/{id}")
	@ApiOperation(value="Deleta um produto")
	public ResponseEntity<?> deletaProduto(@PathVariable(value = "id") long id){
		Produto p = produtoRepository.findById(id);
		if (p == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		produtoRepository.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping("/produtos")
	@ApiOperation(value="Atualiza um produto")
	public Produto atualizaProduto(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}
	
}
