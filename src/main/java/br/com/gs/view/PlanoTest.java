package br.com.gs.view;

import java.util.List;

import br.com.gs.bo.PlanoBO;
import br.com.gs.to.PlanoTO;

public class PlanoTest {

	public static void main(String[] args) {
		PlanoTO pto = new PlanoTO(1, "Normal", 1000, "10");
		PlanoTO pto2 = new PlanoTO(1, "Normal2", 1000, "10");
		PlanoTO pto3 = new PlanoTO(1, "Premium", 1000, "10");
		PlanoBO pbo = new PlanoBO();
//		pbo.cadastrar(pto);
//		pbo.cadastrar(pto2);
//		pbo.cadastrar(pto3);
//		pbo.atualizar(pto3, 1);
//		List<PlanoTO> planos = pbo.listar();
//		for (PlanoTO plano : planos) {
//			System.out.println(plano.toString());
//		}
//		PlanoTO pto4 = pbo.listar(3);
//		System.out.println(pto4.toString());
		pbo.deletar(4);
		
		
	}

}
