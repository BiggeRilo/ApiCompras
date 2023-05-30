package atom.juice.apicompras.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import org.hibernate.annotations.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
@Entity
@Table(name = "ItemCompra", schema="comprasdb")
@DynamicInsert
public class ItemCompra implements Serializable {

	/**
	 * Generated serial UUID
	 */
	@Serial
	private static final long serialVersionUID = 2821647161928568083L;

	@Id
	@Column(name="item_compra_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "valorTotal")
	private Double valorTotal;

	@Column(name = "valorProdutoUnitarioCriacao")
	private Double valorProdutoUnitarioCriacao;

	@Column(name = "quantidadeProduto")
	private int quantidadeProduto;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "produto_id", nullable = false)
	@OnDelete(action = OnDeleteAction.NO_ACTION)
	@JsonIgnore
	private Produto produto;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "compra_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private Compra compra;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_criacao", nullable = false)
	@CreationTimestamp
	private Date dataCriacao;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_ultima_modificacao")
	@UpdateTimestamp
	private Date dataUltimaModificacao;

	@Column(name = "status_db")
	@ColumnDefault("FALSE")
	private Boolean statusDb;

	public ItemCompra() {

	}

	public ItemCompra(Long id, Double valorTotal, Double valorProdutoUnitarioCriacao, int quantidadeProduto,
					  Produto produto, Compra compra) {
		this.id = id;
		this.valorTotal = valorTotal;
		this.valorProdutoUnitarioCriacao = valorProdutoUnitarioCriacao;
		this.quantidadeProduto = quantidadeProduto;
		this.produto = produto;
		this.compra = compra;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof ItemCompra that)) return false;

		if (quantidadeProduto != that.quantidadeProduto) return false;
		if (!id.equals(that.id)) return false;
		if (!valorTotal.equals(that.valorTotal)) return false;
		if (!valorProdutoUnitarioCriacao.equals(that.valorProdutoUnitarioCriacao)) return false;
		if (!produto.equals(that.produto)) return false;
		if (!compra.equals(that.compra)) return false;
		if (!dataCriacao.equals(that.dataCriacao)) return false;
		if (!dataUltimaModificacao.equals(that.dataUltimaModificacao)) return false;
		return statusDb.equals(that.statusDb);
	}

	@Override
	public int hashCode() {
		int result = id.hashCode();
		result = 31 * result + valorTotal.hashCode();
		result = 31 * result + valorProdutoUnitarioCriacao.hashCode();
		result = 31 * result + quantidadeProduto;
		result = 31 * result + produto.hashCode();
		result = 31 * result + compra.hashCode();
		result = 31 * result + dataCriacao.hashCode();
		result = 31 * result + dataUltimaModificacao.hashCode();
		result = 31 * result + statusDb.hashCode();
		return result;
	}

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("ItemCompra{");
		sb.append("id=").append(id);
		sb.append(", valorTotal=").append(valorTotal);
		sb.append(", valorProdutoUnitarioCriacao=").append(valorProdutoUnitarioCriacao);
		sb.append(", quantidadeProduto=").append(quantidadeProduto);
		sb.append(", produto=").append(produto);
		sb.append(", compra=").append(compra);
		sb.append(", dataCriacao=").append(dataCriacao);
		sb.append(", dataUltimaModificacao=").append(dataUltimaModificacao);
		sb.append(", statusDb=").append(statusDb);
		sb.append('}');
		return sb.toString();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Double getValorProdutoUnitarioCriacao() {
		return valorProdutoUnitarioCriacao;
	}

	public void setValorProdutoUnitarioCriacao(Double valorProdutoUnitarioCriacao) {
		this.valorProdutoUnitarioCriacao = valorProdutoUnitarioCriacao;
	}

	public int getQuantidadeProduto() {
		return quantidadeProduto;
	}

	public void setQuantidadeProduto(int quantidadeProduto) {
		this.quantidadeProduto = quantidadeProduto;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Compra getCompra() {
		return compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Date getDataUltimaModificacao() {
		return dataUltimaModificacao;
	}

	public void setDataUltimaModificacao(Date dataUltimaModificacao) {
		this.dataUltimaModificacao = dataUltimaModificacao;
	}

	public Boolean isStatusDb() {
		return statusDb;
	}

	public void setStatusDb(Boolean statusDb) {
		this.statusDb = statusDb;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
