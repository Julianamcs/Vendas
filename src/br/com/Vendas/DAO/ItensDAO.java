package br.com.Vendas.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.Vendas.domain.Itens;
import br.com.Vendas.util.HibernateUtil;

public class ItensDAO {
	
	public void salvar(Itens  itens){

		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		Transaction transacao = null;
		
		try {
			transacao = sessao.beginTransaction(); //abrir a transação
			
			sessao.save(itens); 
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
	public List<Itens> listar(){
		Session session = HibernateUtil.getSessionFactory().openSession(); 
		
		List<Itens> itens = null;
		
		try {
			
			Query consulta = session.getNamedQuery("Itens.listar");
			itens = consulta.list();
			
		} catch (RuntimeException ex) {
			throw ex;
		}
		return itens;
	}
	
	
	public Itens buscarItensPorCodigo(Long codigo){
		Session session = HibernateUtil.getSessionFactory().openSession(); 
		
		Itens itens = null;
		
		try {
			
			Query consulta = session.getNamedQuery("Itens.buscarItensPorCodigo");
			consulta.setLong("codigo", codigo);
			
			itens = (Itens) consulta.uniqueResult();
			
		} catch (RuntimeException ex) {
			throw ex;
		}
		return itens;
	}
	
	public void excluir(Itens itens){

		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		Transaction transacao = null;
		
		try {
			transacao = sessao.beginTransaction(); //abrir a transação
			
			sessao.delete(itens); 
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
	
	public void editar(Itens itens){

		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		Transaction transacao = null;
		
		try {
			transacao = sessao.beginTransaction(); //abrir a transação
			sessao.update(itens); 
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
