package br.com.Vendas.main;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.Vendas.DAO.FornecedoresDAO;
import br.com.Vendas.domain.Fornecedor;

public class FornecedorDaoTeste {
	
		@Ignore
		public void salvar(){
			Fornecedor f1 = new Fornecedor(); 
			f1.setDescricao("Fornecedor novo 4");
			
			FornecedoresDAO fodao = new FornecedoresDAO();
			
			fodao.salvar(f1);
		}

		@Ignore
		public void listar(){
			FornecedoresDAO fodao = new FornecedoresDAO();
			List<Fornecedor> fornecedores = fodao.listar();
			for(Fornecedor fornecedor : fornecedores){
				System.out.println(fornecedor);
			}	
		}
		
		@Ignore
		public void buscarFornecedorPorCodigo(){
			FornecedoresDAO fodao = new FornecedoresDAO();
			Fornecedor f1 = fodao.buscarFornecedorPorCodigo(3L);
			Fornecedor f2 = fodao.buscarFornecedorPorCodigo(4L);
				System.out.println(f1);
				System.out.println(f2);
			
			}
			
		@Ignore
		public void excluir(){
			FornecedoresDAO fodao = new FornecedoresDAO();
			Fornecedor f1 = fodao.buscarFornecedorPorCodigo(4L);
			fodao.excluir(f1);
			}
			

	    @Test
	    @Ignore
		public void editar(){	
			FornecedoresDAO fodao = new FornecedoresDAO();
	        Fornecedor f1 = fodao.buscarFornecedorPorCodigo(3L);
	        f1.setDescricao("Fornecedor Editado");
			fodao.editar(f1); 
			}

}
