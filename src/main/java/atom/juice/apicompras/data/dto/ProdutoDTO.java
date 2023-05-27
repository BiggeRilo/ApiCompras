package atom.juice.apicompras.data.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serial;

public class ProdutoDTO {


    private Long id;


    private String descricao;


    private Double valorUnitario;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProdutoDTO that)) return false;

        if (!id.equals(that.id)) return false;
        if (!descricao.equals(that.descricao)) return false;
        return valorUnitario.equals(that.valorUnitario);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + descricao.hashCode();
        result = 31 * result + valorUnitario.hashCode();
        return result;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ProdutoDTO{");
        sb.append("id=").append(id);
        sb.append(", descricao='").append(descricao).append('\'');
        sb.append(", valorUnitario=").append(valorUnitario);
        sb.append('}');
        return sb.toString();
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
}
