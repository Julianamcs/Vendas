package br.com.Vendas.domain;

import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tb_vendas")
@NamedQueries({
@NamedQuery(name = "Vendas.listar", query = "SELECT vendas FROM Vendas vendas"),
@NamedQuery(name = "Vendas.buscarVendasPorCodigo", query = "SELECT vendas FROM Vendas vendas WHERE vendas.codigo = :codigo")
}) 
public class Vendas {


	@GeneratedValue(strategy = GenerationType.AUTO )
	@Id
	@Column(name = "ven_codigo" )
	private Long codigo; 
	
	@Temporal(value=TemporalType.TIMESTAMP )
	@Column(name = "ven_horario", nullable = false )
	private Date horario;

	@Column(name = "ven_valor_total", length = 14, nullable = false, scale = 2, precision = 8 )
	private BigDecimal valorTotal;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tb_tb_funcionario_fun_codigo", referencedColumnName = "fun_codigo", nullable = false )
	private Funcionario funcionario;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Date getHorario() {
		return horario;
	}

	public void setHorario(Date horario) {
		this.horario = horario;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	@Override
	public String toString() {
		return "Vendas [codigo=" + codigo + ", horario=" + horario + ", valorTotal=" + valorTotal + ", funcionario="
				+ funcionario + "]";
	}
}
