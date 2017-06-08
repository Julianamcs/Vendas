package br.com.Vendas.domain;

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
import java.math.BigDecimal;

@Entity
@Table(name = "tb_produtos")
@NamedQueries({
@NamedQuery(name = "Produtos.listar", query = "SELECT produtos FROM Produtos produtos"),
@NamedQuery(name = "Produtos.buscarProdutosPorCodigo", query = "SELECT produtos FROM Produtos produtos WHERE produtos.codigo = :codigo")
}) 
public class Produtos {
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@Column(name = "pro_codigo")
	private Long codigo;

	@Column(name = "pro_descricao", length = 50, nullable = false)
	private String descricao;

	@Column(name = "pro_preco", length = 14, nullable = false, scale = 2, precision = 8)
	private BigDecimal preco;

	@Column(name = "pro_quantidade", length = 50, nullable = false)
	private Integer quantidade;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tb_fornecedores_for_codigo", referencedColumnName = "for_codigo", nullable = false)
	private Fornecedor fornecedor;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	@Override
	public String toString() {
		return "Produtos [codigo=" + codigo + ", descricao=" + descricao + ", preco=" + preco + ", quantidade="
				+ quantidade + ", fornecedor=" + fornecedor + "]";
	}
}
