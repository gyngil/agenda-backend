package br.edu.pucgoias.cmp1491.agendabackend.util;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

/**
 * Classe que encapsula as excecoes da aplicacao Agenda
 * @author Gilcimar
 *
 */
public class AgendaException extends ResponseStatusException {

	public AgendaException(String mensagem) {
		super(HttpStatus.INTERNAL_SERVER_ERROR,mensagem);
	}

}
