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
import java.util.StringJoiner;

@Entity
@Table(name = "compras", schema = "comprasdb")
@DynamicInsert
public class Compra implements Serializable {

    /**
     * Generated serial UUID
     */
    @Serial
    private static final long serialVersionUID = 6823588219082699682L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "compra_id")
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
    @Column(name = "data_fechamento")
    private Date dataFechamento;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_criacao")
    @CreationTimestamp
    private Date dataCriacao;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_ultima_modificacao")
    @UpdateTimestamp
    private Date dataUltimaModificacao;

    @Column(name = "ativo")
    @ColumnDefault("FALSE")
    private Boolean ativo;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Compra compra)) return false;

        if (!id.equals(compra.id)) return false;
        if (!cliente.equals(compra.cliente)) return false;
        if (!Objects.equals(itensCompra, compra.itensCompra)) return false;
        if (!valorTotal.equals(compra.valorTotal)) return false;
        if (!dataAbertura.equals(compra.dataAbertura)) return false;
        if (!Objects.equals(dataFechamento, compra.dataFechamento))
            return false;
        if (!Objects.equals(dataCriacao, compra.dataCriacao)) return false;
        if (!Objects.equals(dataUltimaModificacao, compra.dataUltimaModificacao))
            return false;
        return Objects.equals(ativo, compra.ativo);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + cliente.hashCode();
        result = 31 * result + (itensCompra != null ? itensCompra.hashCode() : 0);
        result = 31 * result + valorTotal.hashCode();
        result = 31 * result + dataAbertura.hashCode();
        result = 31 * result + (dataFechamento != null ? dataFechamento.hashCode() : 0);
        result = 31 * result + (dataCriacao != null ? dataCriacao.hashCode() : 0);
        result = 31 * result + (dataUltimaModificacao != null ? dataUltimaModificacao.hashCode() : 0);
        result = 31 * result + (ativo != null ? ativo.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Compra.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("cliente=" + cliente)
                .add("itensCompra=" + itensCompra)
                .add("valorTotal=" + valorTotal)
                .add("dataAbertura=" + dataAbertura)
                .add("dataFechamento=" + dataFechamento)
                .add("dataCriacao=" + dataCriacao)
                .add("dataUltimaModificacao=" + dataUltimaModificacao)
                .add("ativo=" + ativo)
                .toString();
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

    public Boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean statusDb) {
        this.ativo = statusDb;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

}
