package br.com.Vendas.Test;

import br.com.Vendas.util.HibernateUtil;

public class GerarTestes {

	public static void main(String[] args) {
		HibernateUtil.getSessionFactory();
		HibernateUtil.getSessionFactory().close();
		
	}

}
