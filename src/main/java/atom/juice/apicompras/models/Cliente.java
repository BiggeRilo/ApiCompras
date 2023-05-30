package atom.juice.apicompras.models;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Clientes",  schema="comprasdb")
@DynamicInsert
public class Cliente implements Serializable {

    /**
     * Generated serial UUID
     */
    @Serial
    private static final long serialVersionUID = 2821647161928568849L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cliente_id")
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


    @OneToMany(mappedBy = "cliente")
    private List<Endereco> enderecos;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_criacao", nullable = false)
    @CreationTimestamp
    private Date dataCriacao;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_ultima_modificacao")
    @UpdateTimestamp
    private Date dataUltimaModificacao;


    @Column(name="status_db")
    @ColumnDefault("FALSE")
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
        this.statusDb = Boolean.FALSE;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + nome.hashCode();
        result = 31 * result + sobreNome.hashCode();
        result = 31 * result + (rg != null ? rg.hashCode() : 0);
        result = 31 * result + (cpf != null ? cpf.hashCode() : 0);
        result = 31 * result + (cnpj != null ? cnpj.hashCode() : 0);
        result = 31 * result + dataNascimento.hashCode();
        result = 31 * result + (enderecos != null ? enderecos.hashCode() : 0);
        result = 31 * result + dataCriacao.hashCode();
        result = 31 * result + dataUltimaModificacao.hashCode();
        result = 31 * result + statusDb.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cliente cliente = (Cliente) o;

        if (!id.equals(cliente.id)) return false;
        if (!Objects.equals(nome, cliente.nome)) return false;
        if (!Objects.equals(sobreNome, cliente.sobreNome)) return false;
        if (!Objects.equals(rg, cliente.rg)) return false;
        if (!Objects.equals(cpf, cliente.cpf)) return false;
        if (!Objects.equals(cnpj, cliente.cnpj)) return false;
        if (!Objects.equals(dataNascimento, cliente.dataNascimento))
            return false;
        if (!Objects.equals(enderecos, cliente.enderecos)) return false;
        if (!Objects.equals(dataCriacao, cliente.dataCriacao)) return false;
        if (!Objects.equals(dataUltimaModificacao, cliente.dataUltimaModificacao))
            return false;
        return Objects.equals(statusDb, cliente.statusDb);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Cliente{");
        sb.append("id=").append(id);
        sb.append(", nome='").append(nome).append('\'');
        sb.append(", sobreNome='").append(sobreNome).append('\'');
        sb.append(", rg='").append(rg).append('\'');
        sb.append(", cpf='").append(cpf).append('\'');
        sb.append(", cnpj='").append(cnpj).append('\'');
        sb.append(", dataNascimento=").append(dataNascimento);
        sb.append(", enderecos=").append(enderecos);
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

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }
}
