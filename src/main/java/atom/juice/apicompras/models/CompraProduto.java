package atom.juice.apicompras.models;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "COMPRA_PRODUTO")
public class CompraProduto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2821647161928568083L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "valor_total")
	private Double valorTotal;

	@Column(name = "valor_produto_unitario_criacao")
	private Double valorProdutoUnitarioCriacao;

	@Column(name = "quantidade_produto")
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

	@Column(name = "status_db", nullable = false)
	@ColumnDefault("false")
	private Boolean statusDb;

	public CompraProduto() {

	}

	public CompraProduto(Long id, Double valorTotal, Double valorProdutoUnitarioCriacao, int quantidadeProduto,
			Produto produto, Compra compra) {
		this.id = id;
		this.valorTotal = valorTotal;
		this.valorProdutoUnitarioCriacao = valorProdutoUnitarioCriacao;
		this.quantidadeProduto = quantidadeProduto;
		this.produto = produto;
		this.compra = compra;
	}

	@Override
	public int hashCode() {
		return Objects.hash(compra, dataCriacao, dataUltimaModificacao, id, produto, quantidadeProduto, statusDb,
				valorProdutoUnitarioCriacao, valorTotal);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CompraProduto other = (CompraProduto) obj;
		return Objects.equals(compra, other.compra) && Objects.equals(dataCriacao, other.dataCriacao)
				&& Objects.equals(dataUltimaModificacao, other.dataUltimaModificacao) && Objects.equals(id, other.id)
				&& Objects.equals(produto, other.produto) && quantidadeProduto == other.quantidadeProduto
				&& Objects.equals(statusDb, other.statusDb)
				&& Objects.equals(valorProdutoUnitarioCriacao, other.valorProdutoUnitarioCriacao)
				&& Objects.equals(valorTotal, other.valorTotal);
	}

	@Override
	public String toString() {
		return "CompraProduto [id=" + id + ", valorTotal=" + valorTotal + ", valorProdutoUnitarioCriacao="
				+ valorProdutoUnitarioCriacao + ", quantidadeProduto=" + quantidadeProduto + ", produto=" + produto
				+ ", compra=" + compra + ", dataCriacao=" + dataCriacao + ", dataUltimaModificacao="
				+ dataUltimaModificacao + ", statusDb=" + statusDb + "]";
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
