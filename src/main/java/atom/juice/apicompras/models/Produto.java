package atom.juice.apicompras.models;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "PRODUTO")
public class Produto implements Serializable {

	/**
	 * Generated serial UUID
	 */
	private static final long serialVersionUID = -8302922676192319239L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "descricao", nullable = false)
	private String descricao;

	@Column(name = "valor_unitario", nullable = false)
	private Double valorUnitario;

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

	public Produto() {
	}

	public Produto(Long id, String descricao, Double valorUnitario, Date dataCriacao, Date dataUltimaModificacao,
			Boolean statusDb) {
		this.id = id;
		this.descricao = descricao;
		this.valorUnitario = valorUnitario;
		this.dataCriacao = dataCriacao;
		this.dataUltimaModificacao = dataUltimaModificacao;
		this.statusDb = statusDb;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dataCriacao, dataUltimaModificacao, descricao, id, statusDb, valorUnitario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		return Objects.equals(dataCriacao, other.dataCriacao)
				&& Objects.equals(dataUltimaModificacao, other.dataUltimaModificacao)
				&& Objects.equals(descricao, other.descricao) && Objects.equals(id, other.id)
				&& Objects.equals(statusDb, other.statusDb) && Objects.equals(valorUnitario, other.valorUnitario);
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", descricao=" + descricao + ", valor Unitario=" + valorUnitario + ", dataCriacao="
				+ dataCriacao + ", dataUltimaModificacao=" + dataUltimaModificacao + ", statusDb=" + statusDb + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(Double valorUnitario) {
		this.valorUnitario = valorUnitario;
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
