package atom.juice.apicompras.models;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "Categoria", schema = "comprasdb")
public class Categoria {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "categoria_id", nullable = false)
    private long categoriaId;

    @Column(name = "nome_categoria", nullable = false, length = -1)
    private String nomeCategoria;

    @Column(name = "descricao", nullable = true, length = -1)
    private String descricao;

    @Column(name = "codigo", nullable = false, length = -1)
    private String codigo;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST,
            CascadeType.MERGE}, mappedBy = "categoria")
    private Set<Produto> produtos;

    @Column(name = "ativo", nullable = true)
    private Boolean ativo;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    @Column(name = "data_criacao", nullable = false)
    private Date dataCriacao;

    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    @Column(name = "data_ultima_modificacao", nullable = false)
    private Date dataUltimaModificacao;

    @Column(name = "usuario_criacao", nullable = true)
    private Long usuarioCriacao;

    @Column(name = "usuario_atualizacao", nullable = true)
    private Long usuarioAtualizacao;

    public long getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(long categoriaId) {
        this.categoriaId = categoriaId;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
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

    public Long getUsuarioCriacao() {
        return usuarioCriacao;
    }

    public void setUsuarioCriacao(Long usuarioCriacao) {
        this.usuarioCriacao = usuarioCriacao;
    }

    public Long getUsuarioAtualizacao() {
        return usuarioAtualizacao;
    }

    public void setUsuarioAtualizacao(Long usuarioAtualizacao) {
        this.usuarioAtualizacao = usuarioAtualizacao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Categoria categoria = (Categoria) o;

        if (categoriaId != categoria.categoriaId) return false;
        if (nomeCategoria != null ? !nomeCategoria.equals(categoria.nomeCategoria) : categoria.nomeCategoria != null)
            return false;
        if (descricao != null ? !descricao.equals(categoria.descricao) : categoria.descricao != null) return false;
        if (codigo != null ? !codigo.equals(categoria.codigo) : categoria.codigo != null) return false;
        if (ativo != null ? !ativo.equals(categoria.ativo) : categoria.ativo != null) return false;
        if (dataCriacao != null ? !dataCriacao.equals(categoria.dataCriacao) : categoria.dataCriacao != null)
            return false;
        if (dataUltimaModificacao != null ? !dataUltimaModificacao.equals(categoria.dataUltimaModificacao) : categoria.dataUltimaModificacao != null)
            return false;
        if (usuarioCriacao != null ? !usuarioCriacao.equals(categoria.usuarioCriacao) : categoria.usuarioCriacao != null)
            return false;
        if (usuarioAtualizacao != null ? !usuarioAtualizacao.equals(categoria.usuarioAtualizacao) : categoria.usuarioAtualizacao != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (categoriaId ^ (categoriaId >>> 32));
        result = 31 * result + (nomeCategoria != null ? nomeCategoria.hashCode() : 0);
        result = 31 * result + (descricao != null ? descricao.hashCode() : 0);
        result = 31 * result + (codigo != null ? codigo.hashCode() : 0);
        result = 31 * result + (ativo != null ? ativo.hashCode() : 0);
        result = 31 * result + (dataCriacao != null ? dataCriacao.hashCode() : 0);
        result = 31 * result + (dataUltimaModificacao != null ? dataUltimaModificacao.hashCode() : 0);
        result = 31 * result + (usuarioCriacao != null ? usuarioCriacao.hashCode() : 0);
        result = 31 * result + (usuarioAtualizacao != null ? usuarioAtualizacao.hashCode() : 0);
        return result;
    }
}
