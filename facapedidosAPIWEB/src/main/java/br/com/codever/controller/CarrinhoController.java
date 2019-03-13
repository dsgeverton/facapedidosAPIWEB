package br.com.codever.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.codever.model.Carrinho;
import br.com.codever.repository.CarrinhoRepository;
import br.com.codever.repository.ProdutoRepository;

@Controller
@RequestMapping("/carrinhos")
public class CarrinhoController {

		@Autowired
		private CarrinhoRepository carrinhoRepository;
		
		@Autowired
		private ProdutoRepository produtoRepository;

		@RequestMapping("")
		public ModelAndView listar() {
			ModelAndView mv = new ModelAndView("ListaCarrinhos.html");
			mv.addObject(new Carrinho());
			mv.addObject("carrinhos", carrinhoRepository.findAll());
			mv.addObject("produtos", produtoRepository.findAll());
			return mv;
		}
		
		@RequestMapping(value="", method = RequestMethod.POST)
		public String gravar(Carrinho c) {
			carrinhoRepository.save(c);
			return "redirect:/carrinhos";
		}
		
		@RequestMapping(value="alterar/{id}")
		public ModelAndView alterar(@PathVariable Long id) {
			ModelAndView mv = new ModelAndView("ListaCarrinhos.html");
			Carrinho carrinho = carrinhoRepository.getOne(id);
			mv.addObject(carrinho);
			mv.addObject("produtos", produtoRepository.findAll());
			mv.addObject("carrinhos", carrinhoRepository.findAll());
			return mv;
		}

		@RequestMapping(value="/excluir/{id}")
		public String excluir(@PathVariable Long id) {
			carrinhoRepository.deleteById(id);
			return "redirect:/carrinhos";
	}
}
