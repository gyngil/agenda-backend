package br.edu.pucgoias.cmp1491.agendabackend.repository;

import br.edu.pucgoias.cmp1491.agendabackend.model.Pessoa;
import org.springframework.data.repository.CrudRepository;

public interface PessoaRepository extends CrudRepository<Pessoa, Integer> {

}
