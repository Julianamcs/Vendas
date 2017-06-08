package br.com.Vendas.main;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;


import br.com.Vendas.DAO.FuncionariosDAO;
import br.com.Vendas.DAO.ItensDAO;
import br.com.Vendas.DAO.VendasDAO;
import br.com.Vendas.domain.Funcionario;
import br.com.Vendas.domain.Itens;
import br.com.Vendas.domain.Vendas;



public class ItensDaoTest {
	
	@Ignore
	public void salvar(){
		FuncionariosDAO fudao = new FuncionariosDAO();
		 
		 Funcionario funcionario = fudao.buscarFuncionarioPorCodigo(1L);
		 
		 VendasDAO vdao = new VendasDAO();
		 Vendas vendas = vdao.buscarVendasPorCodigo(2L);
		 
		 Itens i1 = new Itens(); 
			i1.setQuantidade(80);
			i1.setValorParcial(new BigDecimal(15.00D));
			i1.setVendas(vendas);
			i1.setFuncionario(funcionario);
			
			ItensDAO idao = new ItensDAO();
			
			idao.salvar(i1);
		}
	
	
	@Ignore
	public void listar(){
		ItensDAO idao = new ItensDAO();
		List<Itens> itens = idao.listar();
		for(Itens itens2 : itens){
			System.out.println(itens2);
		}	
	}
	
	
	@Ignore
	public void buscarItensPorCodigo(){
		ItensDAO idao = new ItensDAO();
		Itens i1 = idao.buscarItensPorCodigo(1L);
		Itens i2 = idao.buscarItensPorCodigo(2L);
			System.out.println(i1);
			System.out.println(i2);
		}
	
	
	
	@Ignore
	public void excluir(){
		ItensDAO idao = new ItensDAO();
		Itens i1 = idao.buscarItensPorCodigo(4L);
		idao.excluir(i1);
		}

	@Test
	public void editar(){	
		
		FuncionariosDAO fudao = new FuncionariosDAO();
		 
		 Funcionario funcionario = fudao.buscarFuncionarioPorCodigo(1L);
		 
		 VendasDAO vdao = new VendasDAO();
		 Vendas vendas = vdao.buscarVendasPorCodigo(2L);
		 
		 
		ItensDAO idao = new ItensDAO();
		
		Itens i1 = idao.buscarItensPorCodigo(1L);
		i1.setQuantidade(150);
		i1.setValorParcial(new BigDecimal(80.00D));
		i1.setVendas(vendas);
		i1.setFuncionario(funcionario);
	   	
		idao.editar(i1); 
	}	
}
