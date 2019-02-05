package br.com.sifivei.servlet;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.sifivei.beans.Cliente;
import br.com.sifivei.beans.Usuario;
import br.com.sifivei.beans.Veiculo;

public class DBUtils {

	public static Usuario findUser(Connection conn, 
			String login, String senha) throws SQLException {

		String sql = "Select * from public.\"Usuario\" a " //
				+ " where a.\"LOGIN\" = ? and a.\"SENHA\"= ?";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, login);
		pstm.setString(2, senha);
		ResultSet rs = pstm.executeQuery();

		if (rs.next()) {
			Integer id = rs.getInt("ID_USUARIO");
			String nome = rs.getString("NOME");			
			String sexo = rs.getString("SEXO");
			Usuario usuario = new Usuario();
			usuario.setId(id);
			usuario.setLogin(login);
			usuario.setNome(nome);
			usuario.setSenha(senha);
			usuario.setSexo(sexo);
			return usuario;
		}
		return null;
	}

	public static Usuario findUser(Connection conn, String login) throws SQLException {

		String sql = "Select * from public.\"Usuario\" a "
				+ " where a.\"LOGIN\" = ? ";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, login);

		ResultSet rs = pstm.executeQuery();

		if (rs.next()) {
			Integer id = rs.getInt("ID_USUARIO");
			String nome = rs.getString("NOME");			
			String sexo = rs.getString("SEXO");
			Usuario usuario = new Usuario();
			usuario.setId(id);
			usuario.setLogin(login);
			usuario.setNome(nome);
			usuario.setSenha("***");
			usuario.setSexo(sexo);
		}
		return null;
	}

	public static List<Cliente> queryCliente(Connection conn) throws SQLException {
		String sql = "Select * from public.\"Cliente\" c ";

		PreparedStatement pstm = conn.prepareStatement(sql);

		ResultSet rs = pstm.executeQuery();
		List<Cliente> list = new ArrayList<Cliente>();
		while (rs.next()) {
			Integer id = rs.getInt("ID_CLIENTE");
			String cpf = rs.getString("CPF");
			String nome = rs.getString("NOME");
			String cep = rs.getString("CEP");
			String rg = rs.getString("RG");
			String endereco = rs.getString("ENDERECO");
			String municipio = rs.getString("MUNICIPIO");
			String uf = rs.getString("UF");		
			BigDecimal renda = rs.getBigDecimal("VL_RENDA");
			Cliente cliente = new Cliente();
			cliente.setId(id);
			cliente.setCpf(cpf);
			cliente.setNome(nome);
			cliente.setCep(cep);
			cliente.setEndereco(endereco);
			cliente.setMunicipio(municipio);
			cliente.setRg(rg);
			cliente.setUf(uf);
			cliente.setValorRenda(renda);
			list.add(cliente);
		}
		return list;
	}

	public static Cliente findCliente(Connection conn, Integer id) throws SQLException {
		String sql = "Select * from public.\"Cliente\" c where c.\"ID_CLIENTE\"=?";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, id);

		ResultSet rs = pstm.executeQuery();

		while (rs.next()) {
			String cpf = rs.getString("CPF");
			String nome = rs.getString("NOME");
			String cep = rs.getString("CEP");
			String rg = rs.getString("RG");
			String endereco = rs.getString("ENDERECO");
			String municipio = rs.getString("MUNICIPIO");
			String uf = rs.getString("UF");		
			BigDecimal renda = rs.getBigDecimal("VL_RENDA");
			Cliente cliente = new Cliente();
			cliente.setId(id);
			cliente.setCpf(cpf);
			cliente.setNome(nome);
			cliente.setCep(cep);
			cliente.setEndereco(endereco);
			cliente.setMunicipio(municipio);
			cliente.setRg(rg);
			cliente.setUf(uf);
			cliente.setValorRenda(renda);
			return cliente;
		}
		return null;
	}

	public static void updateCliente(Connection conn, Cliente cliente) throws SQLException {
		String sql = " Update public.\"Cliente\" set  "
				+ "	\"CPF\"=?, "
				+ "	\"NOME\"=?, "
				+ "	\"CEP\"=?, "
				+ "	\"ENDERECO\"=?, "
				+ "	\"MUNICIPIO\"=?, "
				+ " \"UF\"=?, "
				+ "	\"RG\"=?, "
				+ "	\"VL_RENDA\"=? "
				+ " where \"ID_CLIENTE\"=? ";

		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setString(1, cliente.getCpf());
		pstm.setString(2, cliente.getNome());
		pstm.setString(3, cliente.getCep());
		pstm.setString(4, cliente.getEndereco());
		pstm.setString(5, cliente.getMunicipio());
		pstm.setString(6, cliente.getUf());
		pstm.setString(7, cliente.getRg());
		pstm.setBigDecimal(8, cliente.getValorRenda());
		pstm.setInt(9, cliente.getId());
		pstm.executeUpdate();
	}
	
	public static void insertCliente(Connection conn, Cliente cliente) throws SQLException {
		String sql = " INSERT INTO public.\"Cliente\" "
				+ " (\"ID_CLIENTE\", \"CPF\", \"NOME\", \"CEP\", \"ENDERECO\", \"MUNICIPIO\", \"UF\", \"RG\", \"VL_RENDA\") "
				+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?); ";

		PreparedStatement pstm = conn.prepareStatement(sql);
		
		pstm.setInt(1, cliente.getId());
		pstm.setString(2, cliente.getCpf());
		pstm.setString(3, cliente.getNome());
		pstm.setString(4, cliente.getCep());
		pstm.setString(5, cliente.getEndereco());
		pstm.setString(6, cliente.getMunicipio());
		pstm.setString(7, cliente.getUf());
		pstm.setString(8, cliente.getRg());
		pstm.setBigDecimal(9, cliente.getValorRenda());

		pstm.executeUpdate();
	}

	
	public static void deleteCliente(Connection conn, Integer id) throws SQLException {
		String sql = "DELETE FROM public.\"Cliente\" WHERE \"ID_CLIENTE\"= ?";

		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setInt(1, id);

		pstm.executeUpdate();
	}

	public static void deleteVeiculo(Connection conn, Integer id) throws SQLException {
		String sql = "DELETE FROM public.\"Veiculo\" WHERE \"ID_VEICULO\"= ?";

		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setInt(1, id);

		pstm.executeUpdate();
		
	}

	public static void insertVeiculo(Connection conn, Veiculo veiculo) throws SQLException {
		String sql = " INSERT INTO public.\"Veiculo\" "
				+ " (\"ID_VEICULO\", \"PLACA_VEICULO\", \"MODELO\", \"MARCA\", \"COR\", \"CHASSIS\", \"RESTRICOES\") "
				+ " VALUES (?, ?, ?, ?, ?, ?, ?); ";

		PreparedStatement pstm = conn.prepareStatement(sql);
		
		pstm.setInt(1, veiculo.getId());
		pstm.setString(2, veiculo.getPlacaVeiculo());
		pstm.setString(3, veiculo.getModelo());
		pstm.setString(4, veiculo.getMarca());
		pstm.setString(5, veiculo.getCor());
		pstm.setString(6, veiculo.getChassis());
		pstm.setString(7, veiculo.getRestricoes());

		pstm.executeUpdate();		
	}
	
	public static void updateVeiculo(Connection conn, Veiculo veiculo) throws SQLException {
		String sql = " Update public.\"Veiculo\" set  "
				+ " \"PLACA_VEICULO\"=?, \"MODELO\"=?, \"MARCA\"=?, \"COR\"=?, \"CHASSIS\"=?, \"RESTRICOES\"=?"
				+ " where \"ID_VEICULO\"=? ";

		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setString(1, veiculo.getPlacaVeiculo());
		pstm.setString(2, veiculo.getModelo());
		pstm.setString(3, veiculo.getMarca());
		pstm.setString(4, veiculo.getCor());
		pstm.setString(5, veiculo.getChassis());
		pstm.setString(6, veiculo.getRestricoes());		
		pstm.setInt(7, veiculo.getId());
		pstm.executeUpdate();
	}

	public static Veiculo findVeiculo(Connection conn, Integer id) throws SQLException {
		String sql = "Select * from public.\"Veiculo\" c where c.\"ID_VEICULO\"=?";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, id);

		ResultSet rs = pstm.executeQuery();

		while (rs.next()) {
			String placaVeiculo = rs.getString("PLACA_VEICULO");
			String modelo = rs.getString("MODELO");
			String marca= rs.getString("MARCA");
			String cor = rs.getString("COR");
			String chassis = rs.getString("CHASSIS");
			String restricoes = rs.getString("RESTRICOES");
			
			Veiculo veiculo = new Veiculo();
			veiculo.setId(id);
			veiculo.setPlacaVeiculo(placaVeiculo);
			veiculo.setModelo(modelo);
			veiculo.setMarca(marca);
			veiculo.setCor(cor);
			veiculo.setChassis(chassis);
			veiculo.setRestricoes(restricoes);
			
			return veiculo;
		}
		return null;
	}

	public static List<Veiculo> queryVeiculo(Connection conn) throws SQLException {
		String sql = "Select * from public.\"Veiculo\" v ";

		PreparedStatement pstm = conn.prepareStatement(sql);

		ResultSet rs = pstm.executeQuery();
		List<Veiculo> list = new ArrayList<>();
		while (rs.next()) {
			Integer id = rs.getInt("ID_VEICULO");
			String placaVeiculo = rs.getString("PLACA_VEICULO");
			String modelo = rs.getString("MODELO");
			String marca= rs.getString("MARCA");
			String cor = rs.getString("COR");
			String chassis = rs.getString("CHASSIS");
			String restricoes = rs.getString("RESTRICOES");
			
			Veiculo veiculo = new Veiculo();
			veiculo.setId(id);
			veiculo.setPlacaVeiculo(placaVeiculo);
			veiculo.setModelo(modelo);
			veiculo.setMarca(marca);
			veiculo.setCor(cor);
			veiculo.setChassis(chassis);
			veiculo.setRestricoes(restricoes);
			list.add(veiculo);
		}
		return list;
	}

}
