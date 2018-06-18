package br.cubas.usercontrol.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.cubas.usercontrol.beans.Emprestimo;
import br.cubas.usercontrol.repository.EmprestimoRepository;


@Service
public class EmprestimoService {

	@Autowired
	EmprestimoRepository emprestimoRepository;

	public List<Emprestimo> listaEmprestimos() {
		return emprestimoRepository.findAll();
	}

	public Emprestimo salvaEmprestimo(Emprestimo emprestimo) {
		return emprestimoRepository.save(emprestimo);
	}

	public Emprestimo buscaEmprestimo(Long id) {
		Emprestimo emprestimo = this.emprestimoRepository.findOne(id);
		return emprestimo;
	}

	public void apagaEmprestimo(Long id) {
		this.emprestimoRepository.delete(id);
	}

}