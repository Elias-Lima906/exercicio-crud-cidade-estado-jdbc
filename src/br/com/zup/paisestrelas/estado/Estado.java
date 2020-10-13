package br.com.zup.paisestrelas.estado;

public class Estado {

	private String sigla;
	private String nome;
	private String regiao;

	public Estado(String sigla, String nome, String regiao) {
		super();
		this.sigla = sigla;
		this.nome = nome;
		this.regiao = regiao;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRegiao() {
		return regiao;
	}

	public void setRegiao(String regiao) {
		this.regiao = regiao;
	}
}