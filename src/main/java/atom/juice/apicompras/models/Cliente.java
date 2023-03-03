package atom.juice.apicompras.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "CLIENTE")
@DynamicInsert
public class Cliente implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nome", nullable = false)
	private String nome;

	@Column(name = "sobrenome", nullable = false)
	private String sobreNome;

	@Column(name = "rg", unique = true)
	private String rg;

	@Column(name = "cpf", length = 11, unique = true)
	private String cpf;

	@Column(name = "cnpj", length = 14, unique = true)
	private String cnpj;

	@Temporal(TemporalType.DATE)
	@Column(name = "data_nascimento", nullable = false)
	private Date dataNascimento;

	@OneToMany(mappedBy = "cliente", fetch = FetchType.EAGER)
	private List<Endereco> enderecos;

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

	public Cliente() {

	}

	public Cliente(Long id, String nome, String sobreNome, String rg, String cpf, String cnpj, Date dataNascimento) {
		this.id = id;
		this.nome = nome;
		this.sobreNome = sobreNome;
		this.rg = rg;
		this.cpf = cpf;
		this.cnpj = cnpj;
		this.dataNascimento = dataNascimento;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", sobreNome=" + sobreNome + ", rg=" + rg + ", cpf=" + cpf
				+ ", cnpj=" + cnpj + ", dataNascimento=" + dataNascimento + ", dataCriacao=" + dataCriacao
				+ ", dataUltimaModificacao=" + dataUltimaModificacao + ", statusDb=" + statusDb + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cnpj, cpf, dataCriacao, dataNascimento, dataUltimaModificacao, id, nome, rg, sobreNome,
				statusDb);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(cnpj, other.cnpj) && Objects.equals(cpf, other.cpf)
				&& Objects.equals(dataCriacao, other.dataCriacao)
				&& Objects.equals(dataNascimento, other.dataNascimento)
				&& Objects.equals(dataUltimaModificacao, other.dataUltimaModificacao) && Objects.equals(id, other.id)
				&& Objects.equals(nome, other.nome) && Objects.equals(rg, other.rg)
				&& Objects.equals(sobreNome, other.sobreNome) && Objects.equals(statusDb, other.statusDb);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobreNome() {
		return sobreNome;
	}

	public void setSobreNome(String sobreNome) {
		this.sobreNome = sobreNome;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
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
}
