package br.com.trsystems.base.conversores;


import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.trsystems.base.indicadores.IndicadorSimNao;

@FacesConverter("simNaoConverter")
public class SimNaoConverter implements  Converter{


	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		System.out.println(value);
		if(value.equals("0")){
			return IndicadorSimNao.SIM;
		}else{
			return IndicadorSimNao.NAO;	
		}
			
		
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object object) {
		if(object.equals(IndicadorSimNao.SIM)){
			return "0";
		}else{
			return "1";
		}
	}

}
