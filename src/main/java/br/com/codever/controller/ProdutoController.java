package br.com.codever.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import br.com.codever.model.Carrinho;
import br.com.codever.model.Produto;
import br.com.codever.model.Upload;
import br.com.codever.repository.CarrinhoRepository;
import br.com.codever.repository.ProdutoRepository;
import br.com.codever.repository.Uploads;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {
	
	@Autowired
	ProdutoRepository produtoRepository;

	@Autowired
	CarrinhoRepository carrinhoRepository;
	
	@Autowired 
	Uploads uploads;

	@RequestMapping("")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("ListaProdutos.html");
		mv.addObject(new Produto());
		mv.addObject(new Upload());
		mv.addObject("carrinhos", carrinhoRepository.findAll());
		mv.addObject("produtos",produtoRepository.findAll());
		return mv;
	}

	@RequestMapping(value="",method=RequestMethod.POST)
	public String gravar(Produto p) {
		Carrinho c = new Carrinho();
		c = carrinhoRepository.getOne(p.getCarrinho().getId());
		c.setSubtotal(c.getSubtotal()+p.getValor());
		produtoRepository.save(p);
		return "redirect:/produtos";
	}	

	@RequestMapping(value="alterar/{id}")
	public ModelAndView alterar(@PathVariable Long id) {
		ModelAndView mv = new ModelAndView("ListaProdutos.html");
		Produto festa = produtoRepository.getOne(id);
		mv.addObject(festa);
		mv.addObject(new Upload());
		mv.addObject("carrinhos", carrinhoRepository.findAll());
		mv.addObject("produtos",produtoRepository.findAll());
		return mv;
	}

	@RequestMapping(value="/excluir/{id}")
	public String excluir(@PathVariable Long id) {
		produtoRepository.deleteById(id);
		return "redirect:/produtos";
	}

	@RequestMapping(value="/image2",method=RequestMethod.POST)
	public String storeImage(Upload u) {
		uploads.save(u);
		return "redirect:/produtos";
	}

	@RequestMapping(value="/image",method=RequestMethod.POST)
	public String uploadMultipartFile(@RequestParam("file") MultipartFile file,@RequestParam("item_id") String id) {
		if (file.isEmpty()) {
			//redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
			return "redirect:/produtos";
		}
		try {
			byte[] bytes = file.getBytes();
			Path path = Paths.get("./image/" + id + file.getOriginalFilename());
			Files.write(path, bytes);
			//redirectAttributes.addFlashAttribute("message", "You successfully uploaded '" + file.getOriginalFilename() + "'");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "redirect:/produtos";
	}

}
