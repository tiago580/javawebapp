package br.com.twmtecnologia.base.repository;

import org.springframework.data.neo4j.repository.GraphRepository;

import br.com.twmtecnologia.entities.graph.Customer;
public interface CustomerRepository extends GraphRepository<Customer>{
	Customer findByEmailAddress(String emailAddress);
}
