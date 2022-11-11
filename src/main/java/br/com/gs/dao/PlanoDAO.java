package br.com.gs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gs.to.PlanoTO;

public class PlanoDAO {
	
	private Connection conn = null;
	
	public PlanoDAO(Connection conn) {
		this.conn = conn;
	}
	
	public void insert(PlanoTO pto) throws SQLException {
		String sql = "INSERT INTO T_XXX_PLANO (id_plano, nm_plano, ds_valor, nr_tempo) VALUES (SQ_T_XXX_PLANO.nextval,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, pto.getNome());
		ps.setDouble(2, pto.getValor());
		ps.setString(3, pto.getTempo());
		ps.executeUpdate();
		ps.close();

	}
	
	/**
	 * GET BY ID
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public PlanoTO select(int id) throws SQLException{
		PlanoTO plano = new PlanoTO();
		String sql = "SELECT * FROM T_XXX_PLANO WHERE id_plano = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			plano.setId(id);
			plano.setNome(rs.getString("nm_plano"));
			plano.setValor(rs.getDouble("ds_valor"));
			plano.setTempo(rs.getString("nr_tempo"));
		}
		ps.close();
		rs.close();

		return plano;
	}
	
	/**
	 * GET ALL
	 * @return
	 * @throws SQLException
	 */
	public List<PlanoTO> select() throws SQLException {
		List<PlanoTO> planos = new ArrayList<PlanoTO>();
		String sql = "SELECT * FROM T_XXX_PLANO";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			int id = rs.getInt("id_plano");
			String nome = rs.getString("nm_plano");
			Double valor = rs.getDouble("ds_valor");
			String tempo = rs.getString("nr_tempo");
			planos.add(new PlanoTO(id, nome, valor, tempo));
		}
		ps.close();
		rs.close();

		return planos;
	}
	
	
	public void update(PlanoTO pto, int idPlano) throws SQLException {
		String sql = "UPDATE T_XXX_PLANO SET nm_plano=?, ds_valor=?, nr_tempo=? where id_plano=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, pto.getNome());
		ps.setDouble(2, pto.getValor());
		ps.setString(3, pto.getTempo());
		ps.setInt(4, idPlano);
		ps.executeUpdate();
		ps.close();
	}
	
	public void delete(int idPlano) throws SQLException {
		String sql = "DELETE FROM T_XXX_PLANO WHERE id_plano=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, idPlano);
		ps.executeUpdate();
		ps.close();
	}
	

}
