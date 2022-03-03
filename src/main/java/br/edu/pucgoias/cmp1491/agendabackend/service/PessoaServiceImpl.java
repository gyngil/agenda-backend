package br.edu.pucgoias.cmp1491.agendabackend.service;

import br.edu.pucgoias.cmp1491.agendabackend.model.Pessoa;
import br.edu.pucgoias.cmp1491.agendabackend.model.Telefone;
import br.edu.pucgoias.cmp1491.agendabackend.repository.PessoaRepository;
import br.edu.pucgoias.cmp1491.agendabackend.util.AgendaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Classe que define as operacoes da camada de negocio de Pessoa
 * @author Gilcimar
 *
 */
@Service
@Transactional
public class PessoaServiceImpl implements PessoaService {

	//Interface da persistencia
	private PessoaRepository pessoaRepository;

	public PessoaRepository getPessoaRepository() {
		return pessoaRepository;
	}

	@Autowired
	public void setPessoaRepository(PessoaRepository pessoaRepository) {
		this.pessoaRepository = pessoaRepository;
	}

	/**
	 * Inclui uma pessoa
	 * @param pessoa
	 * @return
	 * @throws AgendaException
	 */
	@Transactional(readOnly=false, propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public Pessoa incluir(Pessoa pessoa) throws AgendaException {

		//Regra de negócio 1: apenas inclui se a pessoa for maior de 18 anos
		if(pessoa.getIdade()>=18) {
			return getPessoaRepository().save(pessoa);
		}
		else {
			throw new AgendaException("Para ser inclída a pessoa deve ter idade maior que 18 anos!");
		}
	}

	/**
	 * Altera uma pessoa
	 * @param pessoa
	 * @return
	 * @throws AgendaException
	 */
	@Transactional(readOnly=false, propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public Pessoa alterar(Pessoa pessoa) throws AgendaException {

		//Regra de negócio 1: apenas altera se a pessoa for maior de 18 anos
		if(pessoa.getIdade()>=18) {
			return getPessoaRepository().save(pessoa);
		}
		else {
			throw new AgendaException("Para ser alterada a pessoa deve ter idade maior que 18 anos!");
		}

	}

	/**
	 * Exclui uma pessoa
	 * @param id
	 * @throws AgendaException
	 */
	@Transactional(readOnly=false, propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public void excluir(Integer id) throws AgendaException {

		//Regra de negócio 1: apenas exclui a pessoa se ela não tiver telefones residenciais
		Pessoa pessoa = this.consultar(id);
		for (Telefone telefone:pessoa.getListaTelefones()) {
			if("R".equals(telefone.getTipo())){
				throw new AgendaException("Não é permitida a exclusão de pessoa da agenda que tenha telefone reesidencial!");
			}
		}

		//exclui a pessoa
		getPessoaRepository().delete(pessoa);

	}

	/**
	 * Consulta uma pessoa pelo identificador
	 * @param id
	 * @return
	 * @throws AgendaException
	 */
	@Transactional(readOnly=true, propagation = Propagation.SUPPORTS)
	public Pessoa consultar(Integer id){

		try {
			Pessoa pessoa = getPessoaRepository().findById(id).get();
			return pessoa;
		}
		catch (Exception ex){
			throw new AgendaException("Não foi possível consultar a pessoa! id: " + id);
		}

	}

	/**
	 * Lista todas as pessoas cadastradas
	 * @return
	 * @throws AgendaException
	 */
	@Transactional(readOnly=true, propagation = Propagation.SUPPORTS)
	public List<Pessoa> listar() {
		try {
			return (List<Pessoa>) getPessoaRepository().findAll();
		}
		catch (Exception ex){
			throw new AgendaException("Não foi possível listar as pessoas da agenda!");
		}
	}

}
