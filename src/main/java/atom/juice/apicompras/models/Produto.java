package atom.juice.apicompras.models;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.StringJoiner;

@Entity
@Table(name = "Produtos", schema = "comprasdb")
@DynamicInsert
public class Produto implements Serializable {

    /**
     * Generated serial UUID
     */
    @Serial
    private static final long serialVersionUID = -8302922676192319239L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @Column(name = "descricao_curta", nullable = false)
    private String descricao_curta;

    @Column(name = "valor_unitario", nullable = false)
    private Double valorUnitario;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_criacao")
    @CreationTimestamp
    private Date dataCriacao;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_ultima_modificacao")
    @UpdateTimestamp
    private Date dataUltimaModificacao;

    @Column(name = "ativo")
    @ColumnDefault("false")
    private Boolean ativo;

    public Produto() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Produto produto)) return false;

        if (!id.equals(produto.id)) return false;
        if (!descricao.equals(produto.descricao)) return false;
        if (!descricao_curta.equals(produto.descricao_curta)) return false;
        if (!valorUnitario.equals(produto.valorUnitario)) return false;
        if (!Objects.equals(dataCriacao, produto.dataCriacao)) return false;
        if (!Objects.equals(dataUltimaModificacao, produto.dataUltimaModificacao))
            return false;
        return Objects.equals(ativo, produto.ativo);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + descricao.hashCode();
        result = 31 * result + descricao_curta.hashCode();
        result = 31 * result + valorUnitario.hashCode();
        result = 31 * result + (dataCriacao != null ? dataCriacao.hashCode() : 0);
        result = 31 * result + (dataUltimaModificacao != null ? dataUltimaModificacao.hashCode() : 0);
        result = 31 * result + (ativo != null ? ativo.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Produto.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("descricao='" + descricao + "'")
                .add("descricao_curta='" + descricao_curta + "'")
                .add("valorUnitario=" + valorUnitario)
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

    public Boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean statusDb) {
        this.ativo = statusDb;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public String getDescricao_curta() {
        return descricao_curta;
    }

    public void setDescricao_curta(String descricao_curta) {
        this.descricao_curta = descricao_curta;
    }
}
