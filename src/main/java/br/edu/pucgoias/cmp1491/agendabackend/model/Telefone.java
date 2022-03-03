package br.edu.pucgoias.cmp1491.agendabackend.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Classe que representa os dados persistentes de um telefone
 * @author Gilcimar
 *
 */
@Entity
@Table(name = "telefones")
public class Telefone {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idTelefone")
	private Integer id;

	@Column(name="dsNumero")
	private String numero;

	@Column(name="clTipo")
	private String tipo;
	
	@ManyToOne
	@JoinColumn(name="idPessoa", nullable=false)
	private Pessoa pessoa;
	
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer idTelefone) {
		this.id = idTelefone;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String dsNumero) {
		this.numero = dsNumero;
	}
	public String getTipo() {
		return tipo;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Telefone other = (Telefone) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	public void setTipo(String clTipo) {
		this.tipo = clTipo;
	}
		
}
