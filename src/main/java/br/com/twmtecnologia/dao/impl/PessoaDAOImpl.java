package br.com.twmtecnologia.dao.impl;

import java.util.List;

import javax.naming.AuthenticationException;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import br.com.trsystems.base.dao.DaoJpa;
import br.com.twmtecnologia.dao.PessoaDAO;
import br.com.twmtecnologia.entities.Pessoa;

@Repository
public class PessoaDAOImpl extends DaoJpa<Pessoa> implements PessoaDAO {

	public PessoaDAOImpl() {
		super(Pessoa.class);
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("unchecked")
	@Override
	public Pessoa getPessoaByUsername(String username)
			throws DataAccessException, EntityNotFoundException {
		List<Pessoa> results = null;
		Query query = entityManager
				.createQuery("from Pessoa as p where p.username = :username");
		query.setParameter("username", username);
		results = query.getResultList();
		if (results == null || results.size() <= 0) {
			throw new EntityNotFoundException("Nenhum usuário encontrado");
		} else {
			return results.get(0);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Pessoa authenticatePerson(String username, String password)
			throws AuthenticationException, DataAccessException {
		List<Pessoa> results = null;
		Query query = entityManager
				.createQuery("from Pessoa as p where p.username = :username and p.password = :password");
		query.setParameter("username", username);
		query.setParameter("password", password);
		results = query.getResultList();
		if (results == null || results.size() <= 0) {
			throw new AuthenticationException("Nenhum usuário encontrado");
		} else {
			return results.get(0);
		}

	}

}
