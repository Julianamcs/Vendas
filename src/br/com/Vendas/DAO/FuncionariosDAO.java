package br.com.Vendas.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.Vendas.domain.Funcionario;
import br.com.Vendas.util.HibernateUtil;

public class FuncionariosDAO {

	public void salvar(Funcionario funcionario){

		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		Transaction transacao = null;
		
		try {
			transacao = sessao.beginTransaction(); //abrir a transa��o
			
			sessao.save(funcionario); 
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
	public List<Funcionario> listar(){
		Session session = HibernateUtil.getSessionFactory().openSession(); 
		
		List<Funcionario> funcionario = null;
		
		try {
			
			Query consulta = session.getNamedQuery("Funcionario.listar");
			funcionario = consulta.list();
			
		} catch (RuntimeException ex) {
			throw ex;
		}
		return funcionario;
	}
	
	
	public Funcionario buscarFuncionarioPorCodigo(Long codigo){
		Session session = HibernateUtil.getSessionFactory().openSession(); 
		
		Funcionario funcionario = null;
		
		try {
			
			Query consulta = session.getNamedQuery("Funcionario.buscarFuncionarioPorCodigo");
			consulta.setLong("codigo", codigo);
			
			funcionario = (Funcionario) consulta.uniqueResult();
			
		} catch (RuntimeException ex) {
			throw ex;
		}
		return funcionario;
	}


	public void excluir(Funcionario funcionario){

		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		Transaction transacao = null;
		
		try {
			transacao = sessao.beginTransaction(); //abrir a transa��o
			
			sessao.delete(funcionario); 
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
	
	
	public void editar(Funcionario funcionario){

		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		Transaction transacao = null;
		
		try {
			transacao = sessao.beginTransaction(); //abrir a transa��o
			Funcionario funcionarioEditar = buscarFuncionarioPorCodigo(funcionario.getCodigo());
			funcionarioEditar.setNome(funcionario.getNome());
			funcionarioEditar.setCpf(funcionario.getCpf());
			funcionarioEditar.setSenha(funcionario.getSenha());
			funcionarioEditar.setFuncao(funcionario.getFuncao());
			sessao.update(funcionarioEditar); 
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
