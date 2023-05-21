package atom.juice.apicompras.models;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import org.hibernate.annotations.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "ENDERECO")
@DynamicInsert
public class Endereco implements Serializable {

	/**
	 * Generated serial UUID
	 */
	private static final long serialVersionUID = 6823588219082699682L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne()
	@JoinColumn(name = "cliente_id", nullable = false)
	@JsonIgnore
	private Cliente cliente;

	@Column(name = "cep", nullable = false)
	private String cep;

	@Column(name = "logradouro", nullable = false)
	private String logradouro;

	@Column(name = "numero", nullable = false)
	private String numero;

	@Column(name = "estado", nullable = false)
	private String estado;

	@Column(name = "cidade", nullable = false)
	private String cidade;

	@Column(name = "complemento", nullable = false)
	private String complemento;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_criacao", nullable = false)
	@CreationTimestamp
	private Date dataCriacao;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_ultima_modificacao")
	@UpdateTimestamp
	private Date dataUltimaModificacao;

	@Column(name = "status_db")
	@ColumnDefault("false")
	private Boolean statusDb;

	@Override
	public int hashCode() {
		return Objects.hash(cep, cidade, cliente, complemento, dataCriacao, dataUltimaModificacao, estado, id,
				logradouro, numero, statusDb);
	}

	public Endereco() {
	}

	public Endereco(Long id, Cliente cliente, String cep, String logradouro, String numero, String estado,
			String cidade, String complemento) {
		this.id = id;
		this.cliente = cliente;
		this.cep = cep;
		this.logradouro = logradouro;
		this.numero = numero;
		this.estado = estado;
		this.cidade = cidade;
		this.complemento = complemento;
		this.statusDb = false;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Endereco other = (Endereco) obj;
		return Objects.equals(cep, other.cep) && Objects.equals(cidade, other.cidade)
				&& Objects.equals(cliente, other.cliente) && Objects.equals(complemento, other.complemento)
				&& Objects.equals(dataCriacao, other.dataCriacao)
				&& Objects.equals(dataUltimaModificacao, other.dataUltimaModificacao)
				&& Objects.equals(estado, other.estado) && Objects.equals(id, other.id)
				&& Objects.equals(logradouro, other.logradouro) && Objects.equals(numero, other.numero)
				&& Objects.equals(statusDb, other.statusDb);
	}

	@Override
	public String toString() {
		return "Endereco [id=" + id + ", cliente=" + cliente + ", cep=" + cep + ", logradouro=" + logradouro
				+ ", numero=" + numero + ", estado=" + estado + ", cidade=" + cidade + ", complemento=" + complemento
				+ ", dataCriacao=" + dataCriacao + ", dataUltimaModificacao=" + dataUltimaModificacao + ", statusDb="
				+ statusDb + "]";
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

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
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
