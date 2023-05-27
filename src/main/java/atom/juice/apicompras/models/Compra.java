package atom.juice.apicompras.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Table;
import jakarta.persistence.*;
import org.hibernate.annotations.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Compras", schema="comprasdb")
public class Compra implements Serializable {

	/**
	 * Generated serial UUID
	 */
	@Serial
	private static final long serialVersionUID = 6823588219082699682L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="compra_id")
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "cliente_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private Cliente cliente;

	@OneToMany(mappedBy = "compra")
	private List<ItemCompra> itensCompra;

	@Column(name = "valor_total", nullable = false)
	private Double valorTotal;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_abertura", nullable = false)
	private Date dataAbertura;


	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_fechamento", nullable = true)
	private Date dataFechamento;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_criacao", nullable = false)
	@CreationTimestamp
	private Date dataCriacao;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_ultima_modificacao")
	@UpdateTimestamp
	private Date dataUltimaModificacao;

	@Column(name = "status_db", nullable = false)
	private Boolean statusDb;

	public Compra() {

	}

	public Compra(Long id, Cliente cliente, Double valorTotal, Date dataFechamento) {
		this.id = id;
		this.cliente = cliente;
		this.valorTotal = valorTotal;
		this.dataFechamento = dataFechamento;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Compra compra)) return false;

		if (!id.equals(compra.id)) return false;
		if (!cliente.equals(compra.cliente)) return false;
		if (!itensCompra.equals(compra.itensCompra)) return false;
		if (!valorTotal.equals(compra.valorTotal)) return false;
		if (!dataAbertura.equals(compra.dataAbertura)) return false;
		if (!Objects.equals(dataFechamento, compra.dataFechamento))
			return false;
		if (!dataCriacao.equals(compra.dataCriacao)) return false;
		if (!Objects.equals(dataUltimaModificacao, compra.dataUltimaModificacao))
			return false;
		return statusDb.equals(compra.statusDb);
	}

	@Override
	public int hashCode() {
		int result = id.hashCode();
		result = 31 * result + cliente.hashCode();
		result = 31 * result + itensCompra.hashCode();
		result = 31 * result + valorTotal.hashCode();
		result = 31 * result + dataAbertura.hashCode();
		result = 31 * result + (dataFechamento != null ? dataFechamento.hashCode() : 0);
		result = 31 * result + dataCriacao.hashCode();
		result = 31 * result + (dataUltimaModificacao != null ? dataUltimaModificacao.hashCode() : 0);
		result = 31 * result + statusDb.hashCode();
		return result;
	}

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("Compra{");
		sb.append("id=").append(id);
		sb.append(", cliente=").append(cliente);
		sb.append(", itensCompra=").append(itensCompra);
		sb.append(", valorTotal=").append(valorTotal);
		sb.append(", dataAbertura=").append(dataAbertura);
		sb.append(", dataFechamento=").append(dataFechamento);
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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Date getDataFechamento() {
		return dataFechamento;
	}

	public void setDataFechamento(Date dataFechamento) {
		this.dataFechamento = dataFechamento;
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
