package br.cubas.usercontrol.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.cubas.usercontrol.beans.Livro;
import br.cubas.usercontrol.repository.LivroRepository;


@Service
public class LivroService {
	
	@Autowired
	LivroRepository livroRepository;
	
	public List<Livro> listaLivros(){
		return livroRepository.findAll();
	}

	public Livro salvaLivro(Livro livro) {
		return livroRepository.save(livro);
	}
	
	public Livro buscaLivro(Long id) {
		Livro livro = this.livroRepository.findOne(id);
		return livro;
	}

	public void apagaLivro(Long id) {
		this.livroRepository.delete(id);		
	}

}
