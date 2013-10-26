package br.com.twmtecnologia.beans;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ConversationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.twmtecnologia.entities.Pessoa;
import br.com.twmtecnologia.service.CadastroService;

//@Controller
//@Scope("request")

@Named
@ConversationScoped
public class CadastroBean {
    private Pessoa pessoa;
 
    @Autowired
    private CadastroService service;
 
    private String username = "tiago580";
    private String password;
    @PostConstruct
    private void init() {
        pessoa = new Pessoa();
    }
 
    public String login(){
    	System.out.println("teste");
    	return "/home/index";
    }
    
    public String cadastrar() {
        try {
            service.save(pessoa);
 
            message("Cadastro realizado com sucesso!");
        } catch (IllegalArgumentException e) {
            message(e.getMessage());
        }
        return "";
    }
 
    private void message(String msg) {
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(msg, ""));
    }
 
    public Pessoa getPessoa() {
        return pessoa;
    }
 
    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
    
    
    
}