package br.com.zup.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.zup.factory.ConnectionFactory;
import br.com.zup.paisestrelas.cidade.Cidade;

public class CidadeDAO {

	private List<Cidade> gereciaConsultasNoBancoDeDados(List<Cidade> cidades, PreparedStatement stmt)
			throws SQLException {

		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			Cidade cidade = new Cidade();

			cidade.setNome(rs.getString("nome"));
			cidade.setCep(rs.getNString("cep"));
			cidade.setTotalHabitantes(rs.getInt("total_habitantes"));
			cidade.setCapital(rs.getInt("capital"));
			cidade.setEstado(rs.getNString("estado"));
			cidade.setRendaPerCapita(rs.getFloat("renda_per_capita"));
			cidade.setDataFundacao(rs.getString("data_fundação"));

			cidades.add(cidade);

		}

		return cidades;

	}

	private Connection connection;

	public CidadeDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void adicionaCidade(Cidade cidade) throws SQLException {

		String sqlInsert = "insert into cidade "
				+ "(nome, cep, total_habitantes, capital, estado, renda_per_capita, data_fundação) "
				+ "values (?, ?, ?, ?, ?, ?, ?);";

		PreparedStatement stmt = connection.prepareStatement(sqlInsert);
		stmt.setString(1, cidade.getNome());
		stmt.setString(2, cidade.getCep());
		stmt.setInt(3, cidade.getTotalHabitantes());
		stmt.setInt(4, cidade.isCapital());
		stmt.setString(5, cidade.getEstado());
		stmt.setFloat(6, cidade.getRendaPerCapita());
		stmt.setString(7, cidade.getDataFundacao().toString());

		stmt.execute();
		stmt.close();
	}

	public List<Cidade> consultaCidades() throws SQLException {

		List<Cidade> cidades = new ArrayList<Cidade>();

		String sqlConsulta = "select * from cidade";

		PreparedStatement stmt = connection.prepareStatement(sqlConsulta);

		cidades = gereciaConsultasNoBancoDeDados(cidades, stmt);

		if (cidades != null) {
			return cidades;

		} else {

			throw new SQLException("\n\tNÃO HÁ CIDADES NO BANCO DE DADOS!\n");
		}
	}

	public void removeCidadePorCep(String cep) throws SQLException {

//		Adicione ao DAO a funcionalidade de remover uma cidade passando como parâmetro seu
//		número de cep.

		String sqlConsulta = "delete from cidade where cep = ?;";

		PreparedStatement stmt = connection.prepareStatement(sqlConsulta);

		stmt.setString(1, cep);

		stmt.execute();

	}

	public List<Cidade> buscaCidadePorCep(String cep) throws SQLException {

//		. Crie no seu DAO um método que é capaz de retornar uma cidade com base no seu número de
//		cep.

		List<Cidade> cidades = new ArrayList<Cidade>();

		String sqlConsulta = "select * from cidade where cep = ?";

		PreparedStatement stmt = connection.prepareStatement(sqlConsulta);

		stmt.setString(1, cep);

		cidades = gereciaConsultasNoBancoDeDados(cidades, stmt);

		if (cidades != null) {
			return cidades;

		} else {
			throw new SQLException("\n\tCEP NÃO ENCONTRADO!\n");
		}
	}

	public List<Cidade> buscaCidadePorLetraReferencia(String letraReferencia) throws SQLException {

		// . Crie um método que é capaz de pesquisar cidades cujos nomes se iniciam por
		// um texto passado como parâmetro.

		List<Cidade> cidades = new ArrayList<Cidade>();

		String sqlConsulta = "select * from cidade where nome like ? ;";

		PreparedStatement stmt = connection.prepareStatement(sqlConsulta);

		stmt.setString(1, letraReferencia + '%');

		cidades = gereciaConsultasNoBancoDeDados(cidades, stmt);

		if (cidades != null) {
			return cidades;

		} else {
			throw new SQLException("\n\tCIDADE NÃO ENCONTRADA PELA LETRA REFERÊNCIA!\n");
		}
	}

	public List<Cidade> buscaCidadePorSiglaEstado(String siglaEstado) throws SQLException {
//	. Crie um método que é capaz de listar cidades filtradas pela sigla de estado.

		List<Cidade> cidades = new ArrayList<Cidade>();

		String sqlConsulta = "select * from cidade where estado = ? ;";

		PreparedStatement stmt = connection.prepareStatement(sqlConsulta);

		stmt.setString(1, siglaEstado);

		cidades = gereciaConsultasNoBancoDeDados(cidades, stmt);

		if (cidades != null) {
			return cidades;

		} else {
			throw new SQLException("\n\tNÃO HÁ CIDADES DESSE ESTADO NO BANCO DE DADOSS!\n");
		}
	}

	public int retornaQuantidadeDeCidadePorSiglaEstado(String siglaEstado) throws SQLException {
//		Crie um método que recebe a sigla de um estado e retorna a quantidade de cidades daquele
//		estado.

		String sqlConsulta = "select count(*) from cidade where estado = ? ;";
		int qtdCidades = 0;

		PreparedStatement stmt = connection.prepareStatement(sqlConsulta);

		stmt.setString(1, siglaEstado);

		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {

			qtdCidades = rs.getInt(1);
		}
		if (qtdCidades != 0) {
			return qtdCidades;
		} else {
			throw new SQLException("\n\tNÃO HÁ CIDADES REFERÊNTE A ESSE ESTADO NO BANCO DE DADOS\n");
		}

	}

	public List<Cidade> buscaCidadePorCapitalOuMunicípio(int capital) throws SQLException {

//	Crie um método que filtra cidades pela coluna capital, onde o valor do filtro é passado como
//	parâmetro.

		List<Cidade> cidades = new ArrayList<Cidade>();

		String sqlConsulta = "select * from cidade where capital = ? ;";

		PreparedStatement stmt = connection.prepareStatement(sqlConsulta);

		stmt.setInt(1, capital);

		cidades = gereciaConsultasNoBancoDeDados(cidades, stmt);

		if (cidades != null) {
			return cidades;

		} else {
			throw new SQLException("\n\tNÃO HÁ CIDADES QUE SE ENCAIXAM NESSE FILTRO!\n");
		}

	}

}