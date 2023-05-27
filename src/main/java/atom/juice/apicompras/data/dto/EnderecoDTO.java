package atom.juice.apicompras.data.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;

public class EnderecoDTO extends RepresentationModel<EnderecoDTO> implements Serializable {


    private Long id;


    private String cep;

    private String logradouro;

    private String numero;

    private String estado;

    private String cidade;

    private String complemento;

    public EnderecoDTO() {
    }

    public EnderecoDTO(long i) {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EnderecoDTO that)) return false;
        if (!super.equals(o)) return false;

        if (!id.equals(that.id)) return false;
        if (!cep.equals(that.cep)) return false;
        if (!logradouro.equals(that.logradouro)) return false;
        if (!numero.equals(that.numero)) return false;
        if (!estado.equals(that.estado)) return false;
        if (!cidade.equals(that.cidade)) return false;
        return complemento.equals(that.complemento);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + id.hashCode();
        result = 31 * result + cep.hashCode();
        result = 31 * result + logradouro.hashCode();
        result = 31 * result + numero.hashCode();
        result = 31 * result + estado.hashCode();
        result = 31 * result + cidade.hashCode();
        result = 31 * result + complemento.hashCode();
        return result;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("EnderecoDTO{");
        sb.append("id=").append(id);
        sb.append(", cep='").append(cep).append('\'');
        sb.append(", logradouro='").append(logradouro).append('\'');
        sb.append(", numero='").append(numero).append('\'');
        sb.append(", estado='").append(estado).append('\'');
        sb.append(", cidade='").append(cidade).append('\'');
        sb.append(", complemento='").append(complemento).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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


}
