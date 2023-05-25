package atom.juice.apicompras.data.vo;

import atom.juice.apicompras.models.Cliente;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.Objects;

public class EnderecoDTO extends RepresentationModel<EnderecoDTO> implements Serializable {


    private Long id;

    @JsonProperty("CEP")
    private String cep;
    @JsonProperty("Logradouro")
    private String logradouro;
    @JsonProperty("Numero")
    private String numero;
    @JsonProperty("Estado")
    private String estado;
    @JsonProperty("Cidade")
    private String cidade;
    @JsonProperty("Complemento")
    private String complemento;

    public EnderecoDTO() {
    }

    public EnderecoDTO(Long id, Cliente cliente, String cep, String logradouro, String numero, String estado, String cidade, String complemento) {
        this.id = id;
        this.cep = cep;
        this.logradouro = logradouro;
        this.numero = numero;
        this.estado = estado;
        this.cidade = cidade;
        this.complemento = complemento;
    }

    public EnderecoDTO(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        EnderecoDTO that = (EnderecoDTO) o;

        if (!id.equals(that.id)) return false;
        if (!Objects.equals(cep, that.cep)) return false;
        if (!Objects.equals(logradouro, that.logradouro)) return false;
        if (!Objects.equals(numero, that.numero)) return false;
        if (!Objects.equals(estado, that.estado)) return false;
        if (!Objects.equals(cidade, that.cidade)) return false;
        return Objects.equals(complemento, that.complemento);
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
