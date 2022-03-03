package br.edu.pucgoias.cmp1491.agendabackend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Classe que representa os dados persistentes de pessoa
 * @author Gilcimar
 *
 */
@Entity
@Table(name="pessoas")
public class Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idPessoa")
	private Integer id;
	
	@Column(name="dsNome")
	private String nome;

	@Column(name="vlIdade")
	private Integer idade;

	@JsonBackReference
	@OneToMany(mappedBy="pessoa", cascade=CascadeType.ALL, orphanRemoval = true)
	private List<Telefone> listaTelefones = new ArrayList<>();
	
	public List<Telefone> getListaTelefones() {
		return listaTelefones;
	}

	public void setListaTelefones(List<Telefone> listaTelefone) {
		this.listaTelefones = listaTelefone;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer idPessoa) {
		this.id = idPessoa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String dsNome) {
		this.nome = dsNome;
	}
	

	public void setIdade(Integer vlIdade) {
		this.idade = vlIdade;
	}

	public Integer getIdade() {
		return idade;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Pessoa other = (Pessoa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
