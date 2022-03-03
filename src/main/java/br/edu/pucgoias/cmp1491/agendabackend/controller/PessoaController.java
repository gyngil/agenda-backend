package br.edu.pucgoias.cmp1491.agendabackend.controller;

import br.edu.pucgoias.cmp1491.agendabackend.model.Pessoa;
import br.edu.pucgoias.cmp1491.agendabackend.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Classe controladora de Pessoa
 * Exemplo para aula CMP1491 da PUC Goias
 * Prof.: Gilcimar
 */
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class PessoaController {

    private PessoaService pessoaService;

    @Autowired
    public void setPessoaService(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    /**
     * Este metodo lista as pessoas da base de dados da agenda
     * @return lista de pessoas
     */
    @GetMapping(value = "/listar-pessoas")
    public List<Pessoa> listar() {

        List<Pessoa> lista = pessoaService.listar();
        return lista;

    }

    /**
     * Este metodo consulta uma pessoa na base de dados por id
     * @param id é o identificador chave da pessoa
     * @return objeto pessoa
     */
    @GetMapping(value = "/consultar-pessoa/{id}")
    public Pessoa consultar(@PathVariable Integer id){

        return pessoaService.consultar(id);

    }

    /**
     * Este metodo inclui uma pessoa no banco de dados da agenda
     * @param pessoa no formato JSON
     * @return pessoa incluida na base de dados da agenda
     */
    @PostMapping(value = "/incluir-pessoa")
    public Pessoa incluir(@RequestBody Pessoa pessoa){

//        pessoa.getListaTelefones().get(0).setPessoa(pessoa);

        return pessoaService.incluir(pessoa);

    }

    /**
     * Este metodo altera uma pessoa no banco de dados da agenda
     * @param pessoa no formato JSON
     * @return pessoa alterada na base de dados da agenda
     */
    @PostMapping(value = "/alterar-pessoa")
    public Pessoa alterar(@RequestBody Pessoa pessoa){

        return pessoaService.alterar(pessoa);

    }

    /**
     * Este metodo exclui pessoa pelo seu identificador do banco de dados da agenda
     * @param id é o identificador do pessoa a ser excluida do banco de dados da agenda
     */
    @DeleteMapping(value = "/excluir-pessoa/{id}")
    public void excluir(@PathVariable Integer id){

        pessoaService.excluir(id);

    }

}
