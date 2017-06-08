package br.com.Vendas.main;

import java.math.BigDecimal;
import java.util.List;


import org.junit.Ignore;
import org.junit.Test;

import br.com.Vendas.DAO.FornecedoresDAO;
import br.com.Vendas.DAO.ProdutosDAO;
import br.com.Vendas.domain.Fornecedor;
import br.com.Vendas.domain.Produtos;


public class ProdutosDaoTest {
	
	
	@Ignore
	public void salvar(){
	 
	 FornecedoresDAO fodao = new FornecedoresDAO();
	 
	 Fornecedor fornecedor = fodao.buscarFornecedorPorCodigo(2L);
	 
	 Produtos p1 = new Produtos(); 
		p1.setDescricao("Produto 4");
		p1.setPreco(new BigDecimal(55.00D));
		p1.setQuantidade(80);
		p1.setFornecedor(fornecedor);
		
		ProdutosDAO pdao = new ProdutosDAO();
		
		pdao.salvar(p1);
	}
	
	@Ignore
	public void listar(){
		ProdutosDAO pdao = new ProdutosDAO();
		List<Produtos> produtos = pdao.listar();
		for(Produtos produtos2 : produtos){
			System.out.println(produtos2);
		}	
	}
	
	@Ignore
	public void buscarProdutosPorCodigo(){
		ProdutosDAO pdao = new ProdutosDAO();
		Produtos p1 = pdao.buscarProdutosPorCodigo(1L);
		Produtos p2 = pdao.buscarProdutosPorCodigo(2L);
			System.out.println(p1);
			System.out.println(p2);
		}
	
	
	@Ignore
	public void excluir(){
		ProdutosDAO pdao = new ProdutosDAO();
		Produtos p1 = pdao.buscarProdutosPorCodigo(4L);
		pdao.excluir(p1);
		}

	@Test
	public void editar(){	
		
		FornecedoresDAO fodao = new FornecedoresDAO();
		Fornecedor fornecedor = fodao.buscarFornecedorPorCodigo(2L);
		 
		ProdutosDAO pdao = new ProdutosDAO();
		
		Produtos p1 = pdao.buscarProdutosPorCodigo(1L);
		p1.setDescricao("Produto 1 Editado");
		p1.setPreco(new BigDecimal(75.00D));
	  	p1.setQuantidade(58);
	   	p1.setFornecedor(fornecedor);
	   	
		pdao.editar(p1); 
	}	
	
}
