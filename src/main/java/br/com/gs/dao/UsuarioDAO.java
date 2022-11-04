package br.com.gs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.gs.to.EnderecoTO;
import br.com.gs.to.PlanoTO;
import br.com.gs.to.UsuarioTO;

public class UsuarioDAO {
	private Connection conexao;
	
	public UsuarioDAO(Connection conexao) {
		this.conexao = conexao;
	}
	
	public void register(UsuarioTO usuario) throws SQLException {
		PreparedStatement stmt = conexao.prepareStatement(
				"insert into t_charchen_usuario values "
				+ "(sq_t_charchen_usuario.nextval, ?,?,?,?,to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?)",
				new String[] {"id_usuario"});
		
		stmt.setString(1, usuario.getNome());
		stmt.setString(2, usuario.getSobrenome());
		stmt.setString(3, usuario.getCpf());
		stmt.setString(4, usuario.getCnh());
		stmt.setString(5, usuario.getDataNascimento());
		stmt.setString(6, usuario.getTelefone());
		stmt.setString(7, usuario.getEmail());
		stmt.setString(8, usuario.getSenha());
		stmt.setString(9, usuario.getTipo());
		stmt.setInt(10, usuario.getPlanoTo().getId());
		stmt.setInt(11, usuario.getEnderecoTo().getId());
		
		stmt.executeUpdate();
		
		ResultSet result = stmt.getGeneratedKeys();
		if (result.next()) {
			int id = result.getInt(1);
			usuario.setId(id);
		}

	}

	public void update(UsuarioTO usuario) {
		
	}
	
	public void delete(int id) {
		
	}
	
	public void consult() {
		
	}
}
