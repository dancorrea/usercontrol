package br.cubas.usercontrol.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.cubas.usercontrol.beans.Emprestimo;
import br.cubas.usercontrol.beans.Livro;
import br.cubas.usercontrol.beans.User;
import br.cubas.usercontrol.services.EmprestimoService;
import br.cubas.usercontrol.services.LivroService;
import br.cubas.usercontrol.services.UserService;

@Controller
@RequestMapping(EmprestimoController.PATH_EMPRESTIMO)
public class EmprestimoController {

	public static final String PATH_EMPRESTIMO = "/emprestimos";
	public static final String PATH_EMPRESTIMO_LIST = "/list";
	public static final String PATH_EMPRESTIMO_NOVO = "/novo";
	public static final String PATH_EMPRESTIMO_GRAVAR = "/gravar";
	public static final String PATH_EMPRESTIMO_EXCLUIR = "/excluir/{id}";
	public static final String PATH_EMPRESTIMO_UPDATE = "/alterar/{id}";
	public static final String PATH_EMPRESTIMO_EXIBIR = "/exibir/{id}";

	@Autowired
	EmprestimoService emprestimoService;

	@Autowired
	LivroService livroService;

	@Autowired
	UserService userService;

	@RequestMapping("/")
	public ModelAndView home() {
		return new ModelAndView("index");
	}

	@RequestMapping(PATH_EMPRESTIMO_LIST)
	public ModelAndView emprestimos() {
		List<Emprestimo> emprestimos = emprestimoService.listaEmprestimos();
		return new ModelAndView("emprestimos/emprestimos", "emprestimos", emprestimos);
	}

	@GetMapping(PATH_EMPRESTIMO_NOVO)
	public ModelAndView createForm(@ModelAttribute Emprestimo emprestimo) {
		ModelAndView modelAndView = new ModelAndView("emprestimos/form");
		Iterable<Livro> livros = livroService.listaLivros();
		Iterable<User> users = userService.findAll();
		modelAndView.addObject("livros", livros);
		modelAndView.addObject("users", users);
		return modelAndView;
	}

	@PostMapping(value = PATH_EMPRESTIMO_GRAVAR)
	public ModelAndView create(@ModelAttribute("emprestimo") @Valid Emprestimo emprestimo) {
		emprestimo = emprestimoService.salvaEmprestimo(emprestimo);
		return new ModelAndView("redirect:/emprestimos/list");
	}

}