package Model;

import java.io.Serializable;

public class Empresa implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int id;
	private String empresaCNPJ;
	private String razaoSocial;
	private String logradouro;
	private String cidade;
	private String estado;
	private int cep;
	private String telEmpresa;
	private String contatoPrincipalNome;
	private String contatoPrincipalCPF;
	private String contatoPrincipalEmail;
	private String situacaoCadastral;
	private String site;
	private String dataAbertura;
	private String descriAtvEconomicas;
	private String tipoPerfil;
	private String senhaAcesso; 

	public String getSenhaAcesso() {
		return senhaAcesso;
	}

	public void setSenhaAcesso(String senhaAcesso) {
		this.senhaAcesso = senhaAcesso;
	}

	public String getTipoPerfil() {
		return tipoPerfil;
	}

	public void setTipoPerfil(String tipoPerfil) {
		this.tipoPerfil = tipoPerfil;
	}

	public Empresa() {
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmpresaCNPJ() {
		return empresaCNPJ;
	}
	public void setEmpresaCNPJ(String empresaCNPJ) {
		this.empresaCNPJ = empresaCNPJ;
	}
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public int getCep() {
		return cep;
	}
	public void setCep(int cep) {
		this.cep = cep;
	}
	public String getTelefone() {
		return telEmpresa;
	}
	public void setTelefone(String telefone) {
		this.telEmpresa = telefone;
	}
	public String getContatoPrincipalNome() {
		return contatoPrincipalNome;
	}
	public void setContatoPrincipalNome(String contatoPrincipalNome) {
		this.contatoPrincipalNome = contatoPrincipalNome;
	}
	public String getContatoPrincipalCPF() {
		return contatoPrincipalCPF;
	}
	public void setContatoPrincipalCPF(String contatoPrincipalCPF) {
		this.contatoPrincipalCPF = contatoPrincipalCPF;
	}
	public String getContatoPrincipalEmail() {
		return contatoPrincipalEmail;
	}
	public void setContatoPrincipalEmail(String contatoPrincipalEmail) {
		this.contatoPrincipalEmail = contatoPrincipalEmail;
	}
	public String getSituacaoCadastral() {
		return situacaoCadastral;
	}
	public void setSituacaoCadastral(String situacaoCadastral) {
		this.situacaoCadastral = situacaoCadastral;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public String getDataAbertura() {
		return dataAbertura;
	}
	public void setDataAbertura(String dataAbertura) {
		this.dataAbertura = dataAbertura;
	}
	public String getDescriAtvEconomicas() {
		return descriAtvEconomicas;
	}
	public void setDescriAtvEconomicas(String descriAtvEconomicas) {
		this.descriAtvEconomicas = descriAtvEconomicas;
	}

}
