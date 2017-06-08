package br.com.Vendas.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


import br.com.Vendas.domain.Vendas;
import br.com.Vendas.util.HibernateUtil;

public class VendasDAO {

	
	public void salvar(Vendas  vendas){

		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		Transaction transacao = null;
		
		try {
			transacao = sessao.beginTransaction(); //abrir a transação
			
			sessao.save(vendas); 
			transacao.commit(); //confirmando a transação
		
			
		} catch (RuntimeException ex) {
			if(transacao != null){
				transacao.rollback(); //desfaz a transação
				sessao.close();
			}
			throw ex;	
			}
		
		finally {
			sessao.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Vendas> listar(){
		Session session = HibernateUtil.getSessionFactory().openSession(); 
		
		List<Vendas> vendas = null;
		
		try {
			
			Query consulta = session.getNamedQuery("Vendas.listar");
			vendas = consulta.list();
			
		} catch (RuntimeException ex) {
			throw ex;
		}
		return vendas;
	}
	
	
	public Vendas buscarVendasPorCodigo(Long codigo){
		Session session = HibernateUtil.getSessionFactory().openSession(); 
		
		Vendas vendas = null;
		
		try {
			
			Query consulta = session.getNamedQuery("Vendas.buscarVendasPorCodigo");
			consulta.setLong("codigo", codigo);
			
			vendas = (Vendas) consulta.uniqueResult();
			
		} catch (RuntimeException ex) {
			throw ex;
		}
		return vendas;
	}
	
	
	public void excluir(Vendas vendas){

		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		Transaction transacao = null;
		
		try {
			transacao = sessao.beginTransaction(); //abrir a transação
			
			sessao.delete(vendas); 
			transacao.commit(); //confirmando a transação
		
			
		} catch (RuntimeException ex) {
			if(transacao != null){
				transacao.rollback(); //desfaz a transação
				sessao.close();
			}
			throw ex;	
			}
		
		finally {
			sessao.close();
		}
	}
	
	public void editar(Vendas vendas){

		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		Transaction transacao = null;
		
		try {
			transacao = sessao.beginTransaction(); //abrir a transação
			sessao.update(vendas); 
			transacao.commit(); //confirmando a transação
		
			
		} catch (RuntimeException ex) {
			if(transacao != null){
				transacao.rollback(); //desfaz a transação
				sessao.close();
			}
			throw ex;	
			}
		
		finally {
			sessao.close();
		}
	}
	
	
}
