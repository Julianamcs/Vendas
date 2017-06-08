package br.com.Vendas.main;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;


import br.com.Vendas.DAO.FuncionariosDAO;
import br.com.Vendas.DAO.VendasDAO;
import br.com.Vendas.domain.Funcionario;
import br.com.Vendas.domain.Vendas;

public class VendasDaoTest {
	
	@Ignore
	public void salvar(){
	 
	 FuncionariosDAO fudao = new FuncionariosDAO();
	 
	 Funcionario funcionario = fudao.buscarFuncionarioPorCodigo(2L);
	 
	 Vendas v1 = new Vendas(); 
		v1.setHorario(new Date());
		v1.setValorTotal(new BigDecimal(450.00D));
		v1.setFuncionario(funcionario);
		
		VendasDAO vdao = new VendasDAO();
		
		vdao.salvar(v1);
	}
	

	
	@Ignore
	public void listar(){
		VendasDAO vdao = new VendasDAO();
		List<Vendas> vendas = vdao.listar();
		for(Vendas vendas2 : vendas){
			System.out.println(vendas2);
		}	
	}
	
	@Test
	public void buscarVendasPorCodigo(){
		VendasDAO vdao = new VendasDAO();
		Vendas v1 = vdao.buscarVendasPorCodigo(1L);
		Vendas v2 = vdao.buscarVendasPorCodigo(2L);
			System.out.println(v1);
			System.out.println(v2);
		}
	
	@Test
	public void excluir(){
		VendasDAO vdao = new VendasDAO();
		Vendas v1 = vdao.buscarVendasPorCodigo(4L);
		vdao.excluir(v1);
		}

	@Ignore
	public void editar(){	
		
		FuncionariosDAO fudao = new FuncionariosDAO();
		 
		 Funcionario funcionario = fudao.buscarFuncionarioPorCodigo(1L);
		 
		 VendasDAO vdao = new VendasDAO();
		 Vendas v1 = vdao.buscarVendasPorCodigo(2L);
			v1.setHorario(new Date());
			v1.setValorTotal(new BigDecimal(50.00D));
			v1.setFuncionario(funcionario);
			vdao.editar(v1); 
	}	
	
}
