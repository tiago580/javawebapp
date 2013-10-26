package br.com.trsystems.base.bean;


public abstract class BaseCadastroBeanAbstract extends BaseBean implements
		BaseCadastroBean {

	@Override
	public String deleterecord() {
		String result = null; 
		try {
			result = delete();
			addInfoMessage("Registro removido com sucesso.");
		} catch (Exception e) {
			addErrorMessage("Erro ao remover registro.");
		}
		return result;

	}

	@Override
	public String saveRecord() {
		String result = null;
		try {
			result = save();
			addInfoMessage("Registro salvo com sucesso.");
		} catch (Exception e) {
			addErrorMessage("Erro ao salvar registro.");
		}
		
		return result;

	}

	public abstract String delete();

	public abstract String save();
	
	public abstract String add();

}
