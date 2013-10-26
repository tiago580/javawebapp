package br.com.trsystems.base.bean;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;


public abstract class BaseBean {

	protected void addErrorMessage(String componentId, String errorMessage){
		addMessage(componentId,"Erro", errorMessage, FacesMessage.SEVERITY_ERROR);
	}
	
	protected void addErrorMessage(String errorMessage){
		addErrorMessage(null, errorMessage);
	}
	
	protected void addInfoMessage(String componentId, String infoMessage){
		addMessage(componentId,"Aviso", infoMessage, FacesMessage.SEVERITY_INFO);
	}
	
	protected void addInfoMessage(String infoMessage){
		addInfoMessage(null, infoMessage);
	}
	
	protected void addWarningMessage(String componentId, String warnMessage){
		addMessage(componentId, "Alerta", warnMessage, FacesMessage.SEVERITY_WARN);
	}
	
	protected void addWarningMessage(String warnMessage){
		addWarningMessage(null, warnMessage);
	}
	
	protected void addFatalMessage(String componentId, String fatalMessage){
		addMessage(componentId,"Fatal", fatalMessage, FacesMessage.SEVERITY_FATAL);
	}
	
	protected void addFatalMessage(String fatalMessage){
		addFatalMessage(null, fatalMessage);
	}
	
	private void addMessage(String componentId,String header, String message, Severity severity){
		FacesMessage facesMessage = new FacesMessage(header, message);
		facesMessage.setSeverity(severity);
		FacesContext.getCurrentInstance().addMessage(componentId, facesMessage);
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		//ec.getFlash().setKeepMessages(true);

	}
	
}
