package br.com.Vendas.main;

import org.junit.Test;

import br.com.Vendas.util.HibernateUtil;

public class GerarTabela {
	
	@Test 
	public void gerar() {
		HibernateUtil.getSessionFactory();
		HibernateUtil.getSessionFactory().close();
		
	}


}
