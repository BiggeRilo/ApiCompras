package atom.juice.apicompras.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "Enderecos",  schema="comprasdb")
@DynamicInsert
public class Endereco implements Serializable {

    /**
     * Generated serial UUID
     */@Serial
    private static final long serialVersionUID = 6823588219082699682L;

    @Id
    @Column(name="endereco_id")
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


    public Endereco() {
    }

    public Endereco(Long id) {
        this.id = id;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Endereco endereco = (Endereco) o;

        if (!id.equals(endereco.id)) return false;
        if (!Objects.equals(cliente, endereco.cliente)) return false;
        if (!Objects.equals(cep, endereco.cep)) return false;
        if (!Objects.equals(logradouro, endereco.logradouro)) return false;
        if (!Objects.equals(numero, endereco.numero)) return false;
        if (!Objects.equals(estado, endereco.estado)) return false;
        if (!Objects.equals(cidade, endereco.cidade)) return false;
        if (!Objects.equals(complemento, endereco.complemento))
            return false;
        if (!Objects.equals(dataCriacao, endereco.dataCriacao))
            return false;
        if (!Objects.equals(dataUltimaModificacao, endereco.dataUltimaModificacao))
            return false;
        return Objects.equals(statusDb, endereco.statusDb);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + cliente.hashCode();
        result = 31 * result + cep.hashCode();
        result = 31 * result + logradouro.hashCode();
        result = 31 * result + numero.hashCode();
        result = 31 * result + estado.hashCode();
        result = 31 * result + cidade.hashCode();
        result = 31 * result + complemento.hashCode();
        result = 31 * result + dataCriacao.hashCode();
        result = 31 * result + dataUltimaModificacao.hashCode();
        result = 31 * result + statusDb.hashCode();
        return result;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Endereco{");
        sb.append("id=").append(id);
        sb.append(", cliente=").append(cliente);
        sb.append(", cep='").append(cep).append('\'');
        sb.append(", logradouro='").append(logradouro).append('\'');
        sb.append(", numero='").append(numero).append('\'');
        sb.append(", estado='").append(estado).append('\'');
        sb.append(", cidade='").append(cidade).append('\'');
        sb.append(", complemento='").append(complemento).append('\'');
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


}
