package br.com.twmtecnologia.beans;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.twmtecnologia.service.CustomerService;

@Named
@ConversationScoped
public class CustomerBean {

	@Autowired
	CustomerService service;
	
	@PostConstruct
	private void init(){
		service.save();
	}
}
