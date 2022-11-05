package br.com.gs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.gs.to.EnderecoTO;

public class EnderecoDAO {
	private Connection conexao;

	public EnderecoDAO(Connection conexao) {
		this.conexao = conexao;
	}
	
	public void register(EnderecoTO endereco) throws SQLException {
		PreparedStatement stmt = conexao.prepareStatement(
				"insert into T_charchen_endereco (id_endereco, ds_logradouro, nr_numero, ds_complemento +"
				+ "ds_bairro, ds_cidade, sg_uf, nr_cep, id_usuario) "
				+ "values (sq_t_charchen_endereco.nextval, ?,?,?,?,?,?,?,?)"); 
		
		stmt.setString(1, endereco.getLogradouro());
		stmt.setString(2, endereco.getNumero());
		stmt.setString(3, endereco.getComplemento());
		stmt.setString(4, endereco.getBairro());
		stmt.setString(5, endereco.getCidade());
		stmt.setString(6, endereco.getUf());
		stmt.setString(7, endereco.getCep());
		stmt.setInt(8, endereco.getUsuarioTo().getId());
		
		stmt.executeUpdate();
		
	}
}
