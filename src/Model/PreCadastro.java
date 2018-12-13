package Model;

public class PreCadastro {
	
	private int id;
	private String situacaoCadastral;
	private String razaoSocial;
	private String email;
	private String cnpf_cnpj;
	private String tipoCadastro;
	
	public PreCadastro(){
		
	}
	
	public String getTipoCadastro() {
		return tipoCadastro;
	}
	public void setTipoCadastro(String tipoCadastro) {
		this.tipoCadastro = tipoCadastro;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSituacaoCadastral() {
		return situacaoCadastral;
	}
	public void setSituacaoCadastral(String situacaoCadastral) {
		this.situacaoCadastral = situacaoCadastral;
	}
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCnpf_cnpj() {
		return cnpf_cnpj;
	}
	public void setCnpf_cnpj(String cnpf_cnpj) {
		this.cnpf_cnpj = cnpf_cnpj;
	}

	
	 
	  

}
