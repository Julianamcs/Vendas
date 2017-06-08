package br.com.Vendas.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.Vendas.domain.Fornecedor;
import br.com.Vendas.util.HibernateUtil;

public class FornecedoresDAO {
	public void salvar(Fornecedor fornecedor){

		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		Transaction transacao = null;
		
		try {
			transacao = sessao.beginTransaction(); //abrir a transa��o
			
			sessao.save(fornecedor); 
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
	public List<Fornecedor> listar(){
		Session session = HibernateUtil.getSessionFactory().openSession(); 
		
		List<Fornecedor> fornecedores = null;
		
		try {
			
			Query consulta = session.getNamedQuery("Fornecedor.listar");
			fornecedores = consulta.list();
			
		} catch (RuntimeException ex) {
			throw ex;
		}
		return fornecedores;
	}
	
	
	public Fornecedor buscarFornecedorPorCodigo(Long codigo){
		Session session = HibernateUtil.getSessionFactory().openSession(); 
		
		Fornecedor fornecedores = null;
		
		try {
			
			Query consulta = session.getNamedQuery("Fornecedor.buscarFornecedorPorCodigo");
			consulta.setLong("codigo", codigo);
			
			fornecedores = (Fornecedor) consulta.uniqueResult();
			
		} catch (RuntimeException ex) {
			throw ex;
		}
		return fornecedores;
	}


	public void excluir(Fornecedor fornecedor){

		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		Transaction transacao = null;
		
		try {
			transacao = sessao.beginTransaction(); //abrir a transa��o
			
			sessao.delete(fornecedor); 
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
	
	
	public void editar(Fornecedor fornecedor){

		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		Transaction transacao = null;
		
		try {
			transacao = sessao.beginTransaction(); //abrir a transa��o
			Fornecedor fornecedorEditar = buscarFornecedorPorCodigo(fornecedor.getCodigo());
			fornecedorEditar.setDescricao(fornecedor.getDescricao());
			sessao.update(fornecedorEditar); 
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
