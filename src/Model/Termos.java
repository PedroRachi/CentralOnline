package Model;

import java.io.Serializable;

public class Termos implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public int id;
	public String dadoDoUpload;
	public String documento;

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDadoDoUpload() {
		return dadoDoUpload;
	}

	public void setDadoDoUpload(String dataDoTemos) {
		this.dadoDoUpload = dataDoTemos;
	}

}
