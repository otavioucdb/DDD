package hotel.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public final class Endereco {

	@Column
	private String Logradouro;

	@Column
	private String bairro;

	@Column
	private String cidade;

	@Column
	private String estado;

	@Column
	private String cep;

	public Endereco() {
		super();
	}

	public Endereco(String logradouro, String bairro, String cidade,
			String estado, String cep) {
		super();
		Logradouro = logradouro;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.cep = cep;
	}

	public String getLogradouro() {
		return Logradouro;
	}

	public String getBairro() {
		return bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public String getEstado() {
		return estado;
	}

	public String getCep() {
		return cep;
	}

}
