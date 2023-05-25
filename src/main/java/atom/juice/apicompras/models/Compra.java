package atom.juice.apicompras.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Table;
import jakarta.persistence.*;
import org.hibernate.annotations.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "COMPRA")
public class Compra implements Serializable {

	/**
	 * Generated serial UUID
	 */
	private static final long serialVersionUID = 6823588219082699682L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "cliente_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private Cliente cliente;

	@OneToMany(mappedBy = "compra")
	private List<ItemCompra> itemCompra;

	@Column(name = "valor_total", nullable = false)
	private Double valorTotal;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_fechamento", nullable = false)
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
	@ColumnDefault("false")
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
	public int hashCode() {
		return Objects.hash(cliente, dataCriacao, dataFechamento, dataUltimaModificacao, id, statusDb, valorTotal);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Compra other = (Compra) obj;
		return Objects.equals(cliente, other.cliente) && Objects.equals(dataCriacao, other.dataCriacao)
				&& Objects.equals(dataFechamento, other.dataFechamento)
				&& Objects.equals(dataUltimaModificacao, other.dataUltimaModificacao) && Objects.equals(id, other.id)
				&& Objects.equals(statusDb, other.statusDb) && Objects.equals(valorTotal, other.valorTotal);
	}

	@Override
	public String toString() {
		return "Compra [id=" + id + ", cliente=" + cliente + ", valorTotal=" + valorTotal + ", dataFechamento="
				+ dataFechamento + ", dataCriacao=" + dataCriacao + ", dataUltimaModificacao=" + dataUltimaModificacao
				+ ", statusDb=" + statusDb + "]";
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
