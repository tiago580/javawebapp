package br.com.trsystems.base.service;

import java.util.List;

import br.com.trsystems.base.entity.EntityObject;

public interface Service<T extends EntityObject> {
	T get(Long id);

	List<T> getAll();

	void save(T object);

	void delete(T object);

	List<T> find(int startingAt, int maxPerPage);

	int countRecordsTotal();

}
