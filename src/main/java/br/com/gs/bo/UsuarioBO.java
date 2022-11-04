package br.com.gs.bo;

import java.sql.Connection;

import br.com.gs.dao.EnderecoDAO;
import br.com.gs.dao.PlanoDAO;
import br.com.gs.dao.UsuarioDAO;

public class UsuarioBO {
	private UsuarioDAO usuarioDao;
	private PlanoBO planoBo;
	private EnderecoBO enderecoBo;
	private Connection conexao;
	
	public UsuarioBO(Connection conexao) {
		this.conexao = conexao;
		this.usuarioDao = new UsuarioDAO(conexao);
		this.planoBo = new PlanoBO(conexao);
		this.enderecoBo = new EnderecoBO(conexao);
	}
		
}
