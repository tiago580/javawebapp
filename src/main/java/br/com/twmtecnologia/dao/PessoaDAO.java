package br.com.twmtecnologia.dao;


import javax.naming.AuthenticationException;
import javax.persistence.EntityNotFoundException;

import br.com.trsystems.base.dao.Dao;
import br.com.twmtecnologia.entities.Pessoa;

public interface PessoaDAO extends Dao<Pessoa>{

	public Pessoa getPessoaByUsername(String username)throws EntityNotFoundException;
	public Pessoa authenticatePerson(String username, String password)throws AuthenticationException;
	
}
