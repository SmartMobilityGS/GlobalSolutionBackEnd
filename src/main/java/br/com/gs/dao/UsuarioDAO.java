package br.com.gs.dao;

import java.sql.Connection;

import br.com.gs.to.UsuarioTO;

public class UsuarioDAO {
	private Connection conexao;
	
	public UsuarioDAO(Connection conexao) {
		this.conexao = conexao;
	}
	
	public void register(UsuarioTO usuario) {
		
	}
	
	public void update(UsuarioTO usuario) {
		
	}
	
	public void delete(int id) {
		
	}
	
	public void consult() {
		
	}
}
