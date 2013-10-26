package br.com.twmtecnologia.validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;


@FacesValidator("br.com.twmtecnologia.validators.Password")
public class PasswordValidator implements Validator{
	@Override
	public void validate(FacesContext context, UIComponent component, Object value){
		String pwd = (String) value;
		if(pwd.contains("@")){
			throw new ValidatorException(new FacesMessage("Password cannot contain @"));
		}
	}
}
