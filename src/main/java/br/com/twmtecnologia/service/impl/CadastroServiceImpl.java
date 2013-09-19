package br.com.twmtecnologia.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.twmtecnologia.dao.PessoaDAO;
import br.com.twmtecnologia.entities.Pessoa;
import br.com.twmtecnologia.service.CadastroService;

@Service
public class CadastroServiceImpl implements CadastroService{

	@Autowired
    private PessoaDAO dao;

	@Override
	public Pessoa get(Long id) {
		return dao.get(id);
	}

	@Override
	public List<Pessoa> getAll() {
		return dao.getAll();
	}

	@Override
	public void save(Pessoa object) {
		dao.save(object);
		
	}

	@Override
	public void delete(Pessoa object) {
		dao.delete(object);
		
	}
 
		
}
