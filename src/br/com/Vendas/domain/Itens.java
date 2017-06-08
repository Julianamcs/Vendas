package br.com.Vendas.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "tb_itens")
@NamedQueries({
@NamedQuery(name = "Itens.listar", query = "SELECT itens FROM Itens itens"),
@NamedQuery(name = "Itens.buscarItensPorCodigo", query = "SELECT itens FROM Itens itens WHERE itens.codigo = :codigo")
}) 
public class Itens {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@Column(name = "ite_codigo")
	private Long codigo;

	@Column(name = "ite_quantidade",  nullable = false)
	private Integer quantidade;

	@Column(name = "ite_valor_parcial", length = 14, nullable = false, scale = 2, precision = 8)
	private BigDecimal valorParcial;


	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tb_funcionario_fun_codigo", referencedColumnName = "fun_codigo", nullable = false)
	private Funcionario funcionario;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tb_vendas_ven_codigo", referencedColumnName = "ven_codigo", nullable = false)
	private Vendas vendas;


	public Long getCodigo() {
		return codigo;
	}


	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}


	public Integer getQuantidade() {
		return quantidade;
	}


	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}


	public BigDecimal getValorParcial() {
		return valorParcial;
	}


	public void setValorParcial(BigDecimal valorParcial) {
		this.valorParcial = valorParcial;
	}


	public Funcionario getFuncionario() {
		return funcionario;
	}


	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}


	public Vendas getVendas() {
		return vendas;
	}


	public void setVendas(Vendas vendas) {
		this.vendas = vendas;
	}


	@Override
	public String toString() {
		return "Itens [codigo=" + codigo + ", quantidade=" + quantidade + ", valorParcial=" + valorParcial
				+ ", funcionario=" + funcionario + ", vendas=" + vendas + "]";
	}
}
