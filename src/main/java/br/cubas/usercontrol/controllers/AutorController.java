package br.cubas.usercontrol.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.cubas.usercontrol.beans.Autor;
import br.cubas.usercontrol.services.AutorService;

@Controller
@RequestMapping(AutorController.PATH_AUTOR)
public class AutorController {
	
	public static final String PATH_AUTOR = "/autores";
	public static final String PATH_AUTOR_LIST = "/list";
	public static final String PATH_AUTOR_NOVO = "/novo";
	public static final String PATH_AUTOR_GRAVAR = "/gravar";
	public static final String PATH_AUTOR_EXCLUIR = "/excluir/{id}";
	public static final String PATH_AUTOR_UPDATE = "/alterar/{id}";
	public static final String PATH_AUTOR_EXIBIR = "/exibir/{id}";
	
	@Autowired
	AutorService autorService;
	
	@RequestMapping("/")
	public ModelAndView  home() {
		return new ModelAndView("index");
	}
	
	@RequestMapping(PATH_AUTOR_LIST)
	public ModelAndView autores() {
		List<Autor> autores = autorService.listaAutores();
		return new ModelAndView("autores/autores", "autores", autores);
	}
	
	@GetMapping(PATH_AUTOR_NOVO)
	public ModelAndView createForm(@ModelAttribute Autor autor) {
		ModelAndView modelAndView = new ModelAndView("autores/form");
		return modelAndView;
	}
	
	@PostMapping(value = PATH_AUTOR_GRAVAR)
	public ModelAndView create(@ModelAttribute("autor") @Valid Autor autor) {
		autor = autorService.salvaAutor(autor);
		return new ModelAndView("redirect:/autores/list");
	}

	@GetMapping(PATH_AUTOR_UPDATE)
	public ModelAndView alterar(@PathVariable("id") Long id) {
		Autor autor = this.autorService.buscaAutor(id);
		ModelAndView modelAndView = new ModelAndView("autores/form");
		modelAndView.addObject("autor", autor);
		return modelAndView;
	}

	@GetMapping(PATH_AUTOR_EXCLUIR)
	public ModelAndView excluir(@PathVariable("id") Long id) {
		this.autorService.apagaAutor(id);
		return new ModelAndView("redirect:/autores/list");
	}
	
	@GetMapping(PATH_AUTOR_EXIBIR)
	public ModelAndView exibir(@PathVariable("id") Long id) {
		Autor autor = this.autorService.buscaAutor(id);
		ModelAndView modelAndView = new ModelAndView("autores/exibir");
		modelAndView.addObject("autor", autor);
		return modelAndView;
	}

}