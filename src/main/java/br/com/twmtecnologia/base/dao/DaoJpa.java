package br.com.twmtecnologia.base.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import br.com.twmtecnologia.base.entity.EntityObject;

public class DaoJpa<T extends EntityObject> implements Dao<T>{

	private Class<T> type;
	
	protected EntityManager entityManager;
	
	
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public DaoJpa(Class<T> type){
		super();
		this.type = type;
	}

	@Override
	@Transactional(readOnly=true)
	public T get(Long id) {
		if(id == null){
			return null;
		}else{
			return entityManager.find(type, id);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly=true)
	public List<T> getAll() {
		return entityManager.createQuery("select o from " + type.getName() + " o").getResultList();
	}

	@Override
	@Transactional
	public void save(T object) {
		entityManager.persist(object);
		
	}

	@Override
	@Transactional
	public void delete(T object) {
		entityManager.remove(object);
		
	}

}
