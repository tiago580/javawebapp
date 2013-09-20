package br.com.twmtecnologia.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.twmtecnologia.base.repository.CustomerRepository;
import br.com.twmtecnologia.entities.graph.Customer;
import br.com.twmtecnologia.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	CustomerRepository customerRepository;
	@Override
	public void save(){
		
		Customer c = customerRepository.save(new Customer("Tiago"));
		System.out.println(c.getFirstName());
	}
}
