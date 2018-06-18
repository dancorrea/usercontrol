package br.cubas.usercontrol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.cubas.usercontrol.beans.Autor;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {

}