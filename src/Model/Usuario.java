package Model;

import java.io.Serializable;

public class Usuario implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public int id;
	public String 	nomeUsuario;
	public String 	emailUsuario;
	public String 	documentoCPFCNPJEmpresa;
	public String	situacaoCadastral;
	public String 	documentoEmpresa;
	public int 		idTipoPerfil;
	public String 	senha;
	public String 	tipoCadastro;
	
	public String getTipoCadastro() {
		return tipoCadastro;
	}

	public void setTipoCadastro(String tipoCadastro) {
		this.tipoCadastro = tipoCadastro;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public int getIdTipoPerfil() {
		return idTipoPerfil;
	}

	public void setIdTipoPerfil(int idTipoPerfil) {
		this.idTipoPerfil = idTipoPerfil;
	}

	public Usuario() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getEmailUsuario() {
		return emailUsuario;
	}

	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}

	public String getDocumentoCPFCNPJEmpresa() {
		return documentoCPFCNPJEmpresa;
	}

	public void setDocumentoCPFCNPJEmpresa(String documentoCPFCNPJEmpresa) {
		this.documentoCPFCNPJEmpresa = documentoCPFCNPJEmpresa;
	}


	public String getSituacaoCadastral() {
		return situacaoCadastral;
	}

	public void setSituacaoCadastral(String situacaoCadastral) {
		this.situacaoCadastral = situacaoCadastral;
	}


	public String getDocumentoEmpresa() {
		return documentoEmpresa;
	}

	public void setDocumentoEmpresa(String documentoEmpresa) {
		this.documentoEmpresa = documentoEmpresa;
	}

	
}
