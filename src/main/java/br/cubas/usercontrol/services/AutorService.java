package br.cubas.usercontrol.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.cubas.usercontrol.beans.Autor;
import br.cubas.usercontrol.repository.AutorRepository;

@Service
public class AutorService {

	@Autowired
	AutorRepository autorRepository;

	public List<Autor> listaAutores() {
		return autorRepository.findAll();
	}

	public Autor salvaAutor(Autor autor) {
		return autorRepository.save(autor);
	}

	public Autor buscaAutor(Long id) {
		Autor autor = this.autorRepository.findOne(id);
		return autor;
	}

	public void apagaAutor(Long id) {
		this.autorRepository.delete(id);
	}

}