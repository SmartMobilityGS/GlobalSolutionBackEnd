package br.com.gs.bo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gs.dao.PlanoDAO;
import br.com.gs.factory.ConnectionFactory;
import br.com.gs.to.PlanoTO;

public class PlanoBO {
	private PlanoDAO pdao;
	
	/**
	 * Cadastra um novo plano ao banco de dados
	 * @param pto PlanoTO
	 * @return boolean
	 */
	public boolean cadastrar(PlanoTO pto) {
		try {
			new ConnectionFactory();
			pdao = new PlanoDAO(ConnectionFactory.getConnection());
			pdao.insert(pto);
			return true;
		} catch (ClassNotFoundException e) {
			System.out.println("Erro ao encontrar o driver de conexão...");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Erro ao se conectar ao banco...");
			e.printStackTrace();
		}
		
		return false;
		
	}
	
	/**
	 * Retorna um planoTO de caso ele exista no banco
	 * GET BY ID
	 * @param idPlano int
	 * @return pto PlanoTO
	 */
	public PlanoTO listar(int idPlano) {
		try {
			new ConnectionFactory();
			pdao = new PlanoDAO(ConnectionFactory.getConnection());
			PlanoTO pto = pdao.select(idPlano);
			return pto;
		} catch (ClassNotFoundException e) {
			System.out.println("Erro ao encontrar o driver de conexão...");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Erro ao se conectar ao banco...");
			e.printStackTrace();
		}
		
		return null;
	}
	
	public List<PlanoTO> listar() {
		try {
			new ConnectionFactory();
			pdao = new PlanoDAO(ConnectionFactory.getConnection());
			List<PlanoTO> planos = new ArrayList<PlanoTO>();
			planos = pdao.select();
			return planos;
		} catch (ClassNotFoundException e) {
			System.out.println("Erro ao encontrar o driver de conexão...");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Erro ao se conectar ao banco...");
			e.printStackTrace();
		}
		
		return null;
	}
	
	public boolean atualizar(PlanoTO pto, int idPlano) {
		try {
			new ConnectionFactory();
			pdao = new PlanoDAO(ConnectionFactory.getConnection());
			pdao.update(pto, idPlano);
			return true;
		} catch (ClassNotFoundException e) {
			System.out.println("Erro ao encontrar o driver de conexão...");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Erro ao se conectar ao banco...");
			e.printStackTrace();
		}
		
		return false;
	}
	
	public boolean deletar(int idPlano) {
		try {
			new ConnectionFactory();
			pdao = new PlanoDAO(ConnectionFactory.getConnection());
			pdao.delete(idPlano);
			return true;
		} catch (ClassNotFoundException e) {
			System.out.println("Erro ao encontrar o driver de conexão...");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Erro ao se conectar ao banco...");
			e.printStackTrace();
		}
		return false;
	}
	

}
