package br.cubas.usercontrol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.cubas.usercontrol.beans.Emprestimo;


@Repository
public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {

}