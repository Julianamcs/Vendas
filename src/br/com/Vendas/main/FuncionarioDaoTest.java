package br.com.Vendas.main;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.Vendas.DAO.FuncionariosDAO;
import br.com.Vendas.domain.Funcionario;

public class FuncionarioDaoTest {

	@Ignore
	public void salvar(){
	   Funcionario f1 = new Funcionario(); 
	  			
	    f1.setNome("Funcionario 4");
	  	f1.setCpf("56984378957");
	  	f1.setSenha("123");
	   	f1.setFuncao("Aux Administrativo 3");
	 
	   	FuncionariosDAO fodao = new FuncionariosDAO();
		fodao.salvar(f1);
 }


	@Ignore
	public void listar(){
		FuncionariosDAO fodao = new FuncionariosDAO();
		List<Funcionario> funcionarios = fodao.listar();
		for(Funcionario funcionario : funcionarios){
			System.out.println(funcionario);
		}	
	}
	
	@Ignore
	public void buscarFornecedorPorCodigo(){
		FuncionariosDAO fodao = new FuncionariosDAO();
		Funcionario f1 = fodao.buscarFuncionarioPorCodigo(1L);
		Funcionario f2 = fodao.buscarFuncionarioPorCodigo(2L);
			System.out.println(f1);
			System.out.println(f2);
		}
		
	
	
	@Ignore
	public void excluir(){
		FuncionariosDAO fodao = new FuncionariosDAO();
		Funcionario f1 = fodao.buscarFuncionarioPorCodigo(3L);
		fodao.excluir(f1);
		}
		

	
	@Test
	@Ignore
	public void editar(){	
		FuncionariosDAO fodao = new FuncionariosDAO();
		
		Funcionario f1 = fodao.buscarFuncionarioPorCodigo(4L);
		f1.setNome("Funcionario feito Editado");
	  	f1.setCpf("02056785789");
	  	f1.setSenha("12300");
	   	f1.setFuncao("Gerente de Unidade");
	   	
		fodao.editar(f1); 
	}	
}
