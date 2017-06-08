package br.com.Vendas.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.Vendas.domain.Produtos;
import br.com.Vendas.util.HibernateUtil;

public class ProdutosDAO {
	
	public void salvar(Produtos  produto){

		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		Transaction transacao = null;
		
		try {
			transacao = sessao.beginTransaction(); //abrir a transa��o
			
			sessao.save(produto); 
			transacao.commit(); //confirmando a transa��o
		
			
		} catch (RuntimeException ex) {
			if(transacao != null){
				transacao.rollback(); //desfaz a transa��o
				sessao.close();
			}
			throw ex;	
			}
		
		finally {
			sessao.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Produtos> listar(){
		Session session = HibernateUtil.getSessionFactory().openSession(); 
		
		List<Produtos> produto = null;
		
		try {
			
			Query consulta = session.getNamedQuery("Produtos.listar");
			produto = consulta.list();
			
		} catch (RuntimeException ex) {
			throw ex;
		}
		return produto;
	}
	
	
	public Produtos buscarProdutosPorCodigo(Long codigo){
		Session session = HibernateUtil.getSessionFactory().openSession(); 
		
		Produtos produto = null;
		
		try {
			
			Query consulta = session.getNamedQuery("Produtos.buscarProdutosPorCodigo");
			consulta.setLong("codigo", codigo);
			
			produto = (Produtos) consulta.uniqueResult();
			
		} catch (RuntimeException ex) {
			throw ex;
		}
		return produto;
	}
	
	
	public void excluir(Produtos produto){

		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		Transaction transacao = null;
		
		try {
			transacao = sessao.beginTransaction(); //abrir a transa��o
			
			sessao.delete(produto); 
			transacao.commit(); //confirmando a transa��o
		
			
		} catch (RuntimeException ex) {
			if(transacao != null){
				transacao.rollback(); //desfaz a transa��o
				sessao.close();
			}
			throw ex;	
			}
		
		finally {
			sessao.close();
		}
	}
	
	public void editar(Produtos produto){

		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		Transaction transacao = null;
		
		try {
			transacao = sessao.beginTransaction(); //abrir a transa��o
			sessao.update(produto); 
			transacao.commit(); //confirmando a transa��o
		
			
		} catch (RuntimeException ex) {
			if(transacao != null){
				transacao.rollback(); //desfaz a transa��o
				sessao.close();
			}
			throw ex;	
			}
		
		finally {
			sessao.close();
		}
	}
	
	

}
