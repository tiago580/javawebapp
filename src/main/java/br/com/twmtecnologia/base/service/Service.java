package br.com.twmtecnologia.base.service;

import java.util.List;

import br.com.twmtecnologia.base.entity.EntityObject;

public interface Service<T extends EntityObject> {
	public T get(Long id);
	public List<T> getAll();
	public void save(T object);
	public void delete(T object);
}
