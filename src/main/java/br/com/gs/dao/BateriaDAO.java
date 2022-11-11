package br.com.gs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.gs.to.BateriaTO;

public class BateriaDAO {
	
	private Connection conexao;

	public BateriaDAO(Connection conexao) {
		this.conexao = conexao;
	}
	
	public void register(BateriaTO bateria) throws SQLException {		
		PreparedStatement stmt = conexao.prepareStatement("insert into t_charchan_bateria (cd_produtora, nm_produtora, ds_pais) "
				+ " values (sq_tdss_tb_produtora.nextval, ?, ?)", new String[] {"cd_produtora"});
		
		stmt.setString(1, bateria.getNome());
		stmt.setString(2, bateria.getPais());
		
		stmt.executeUpdate();
		
		//Recuperar e setar o codigo gerado pela sequence
		ResultSet result = stmt.getGeneratedKeys();
		if (result.next()) {
			int codigo = result.getInt(1);
			bateria.setCodigo(codigo);
		}
	}

}
