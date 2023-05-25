package atom.juice.apicompras.data.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class ClienteDTO extends RepresentationModel<ClienteDTO> implements Serializable {

    private Long id;

    @JsonProperty("Nome")
    private String nome;

    @JsonProperty("Sobrenome")
    private String sobreNome;

    @JsonProperty("RG")
    private String rg;

    @JsonProperty("CPF")
    private String cpf;

    @JsonProperty("CNPJ")
    private String cnpj;

    @JsonProperty("Enderecos")
    private List<EnderecoDTO> enderecos;
    @JsonProperty("DataNascimento")
    private Date dataNascimento;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        ClienteDTO that = (ClienteDTO) o;

        if (!id.equals(that.id)) return false;
        if (!Objects.equals(nome, that.nome)) return false;
        if (!Objects.equals(sobreNome, that.sobreNome)) return false;
        if (!Objects.equals(rg, that.rg)) return false;
        if (!Objects.equals(cpf, that.cpf)) return false;
        if (!Objects.equals(cnpj, that.cnpj)) return false;
        return Objects.equals(enderecos, that.enderecos);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + id.hashCode();
        result = 31 * result + nome.hashCode();
        result = 31 * result + sobreNome.hashCode();
        result = 31 * result + rg.hashCode();
        result = 31 * result + cpf.hashCode();
        result = 31 * result + cnpj.hashCode();
        result = 31 * result + (enderecos != null ? enderecos.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ClienteVO{" +
                "key=" + id +
                ", nome='" + nome + '\'' +
                ", sobreNome='" + sobreNome + '\'' +
                ", rg='" + rg + '\'' +
                ", cpf='" + cpf + '\'' +
                ", cnpj='" + cnpj + '\'' +
                ", enderecos=" + enderecos +
                '}';
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


    public List<EnderecoDTO> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<EnderecoDTO> enderecos) {
        this.enderecos = enderecos;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
