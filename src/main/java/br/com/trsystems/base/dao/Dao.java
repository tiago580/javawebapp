package br.com.trsystems.base.dao;

import java.util.List;

import br.com.trsystems.base.entity.EntityObject;

public interface Dao<T extends EntityObject> {
	T get(Long id);

	List<T> getAll();

	List<T> find(int startingAt, int maxPerPage);
	
	int countRecordsTotal();

	void save(T object);

	void delete(T object);
}
