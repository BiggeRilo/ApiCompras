package atom.juice.apicompras.data.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@JsonPropertyOrder({"id","nome","sobreNome", "rg", "cpf","cnpj","dataNascimento", "enderecos"})
public class ClienteDTO extends RepresentationModel<ClienteDTO> implements Serializable {

    private Long id;


    private String nome;


    private String sobreNome;


    private String rg;


    private String cpf;


    private String cnpj;


    private List<EnderecoDTO> enderecos;

    private Date dataNascimento;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClienteDTO that)) return false;
        if (!super.equals(o)) return false;

        if (!id.equals(that.id)) return false;
        if (!nome.equals(that.nome)) return false;
        if (!sobreNome.equals(that.sobreNome)) return false;
        if (!Objects.equals(rg, that.rg)) return false;
        if (!Objects.equals(cpf, that.cpf)) return false;
        if (!Objects.equals(cnpj, that.cnpj)) return false;
        if (!Objects.equals(enderecos, that.enderecos)) return false;
        return dataNascimento.equals(that.dataNascimento);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + id.hashCode();
        result = 31 * result + nome.hashCode();
        result = 31 * result + sobreNome.hashCode();
        result = 31 * result + (rg != null ? rg.hashCode() : 0);
        result = 31 * result + (cpf != null ? cpf.hashCode() : 0);
        result = 31 * result + (cnpj != null ? cnpj.hashCode() : 0);
        result = 31 * result + (enderecos != null ? enderecos.hashCode() : 0);
        result = 31 * result + dataNascimento.hashCode();
        return result;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ClienteDTO{");
        sb.append("id=").append(id);
        sb.append(", nome='").append(nome).append('\'');
        sb.append(", sobreNome='").append(sobreNome).append('\'');
        sb.append(", rg='").append(rg).append('\'');
        sb.append(", cpf='").append(cpf).append('\'');
        sb.append(", cnpj='").append(cnpj).append('\'');
        sb.append(", enderecos=").append(enderecos);
        sb.append(", dataNascimento=").append(dataNascimento);
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
