package br.com.zup.paisestrelas.cidade;

public class Cidade {

	private String nome;
	private String cep;
	private Integer totalHabitantes;
	private int capital;
	private String estado;
	private float rendaPerCapita;
	private String dataFundacao;

	public Cidade(String nome, String cep, Integer totalHabitantes, int capital, String estado, float rendaPerCapita,
			String dataFundacao) {
		super();
		this.nome = nome;
		this.cep = cep;
		this.totalHabitantes = totalHabitantes;
		this.capital = capital;
		this.estado = estado;
		this.rendaPerCapita = rendaPerCapita;
		this.dataFundacao = dataFundacao;
	}

	public Cidade() {
	}

	@Override
	public String toString() {
		return "Cidade [nome=" + nome + ", cep=" + cep + ", totalHabitantes=" + totalHabitantes + ", capital=" + capital
				+ ", estado=" + estado + ", rendaPerCapita=" + rendaPerCapita + ", dataFundacao=" + dataFundacao + "]";
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Integer getTotalHabitantes() {
		return totalHabitantes;
	}

	public void setTotalHabitantes(Integer totalHabitantes) {
		this.totalHabitantes = totalHabitantes;
	}

	public int isCapital() {
		return capital;
	}

	public void setCapital(int capital) {
		this.capital = capital;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public float getRendaPerCapita() {
		return rendaPerCapita;
	}

	public void setRendaPerCapita(float rendaPerCapita) {
		this.rendaPerCapita = rendaPerCapita;
	}

	public String getDataFundacao() {
		return dataFundacao;
	}

	public void setDataFundacao(String dataFundacao) {
		this.dataFundacao = dataFundacao;
	}
}