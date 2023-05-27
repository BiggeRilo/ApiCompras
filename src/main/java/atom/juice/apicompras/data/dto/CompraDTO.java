package atom.juice.apicompras.data.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class CompraDTO extends RepresentationModel<CompraDTO> implements Serializable {

    @JsonProperty("id")
    private Long id;


    @JsonProperty("valorTotal")
    private Double valorTotal;

    @JsonProperty("cliente")
    private ClienteDTO cliente;

    @JsonProperty("itens")
    private List<ItemCompraDTO> itensCompra;


    @JsonProperty("dataFechamento")
    private Date dataFechamento;

    @JsonProperty("dataAbertura")
    private Date dataAbertura;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CompraDTO compraDTO)) return false;
        if (!super.equals(o)) return false;

        if (!id.equals(compraDTO.id)) return false;
        if (!valorTotal.equals(compraDTO.valorTotal)) return false;
        if (!cliente.equals(compraDTO.cliente)) return false;
        if (!itensCompra.equals(compraDTO.itensCompra)) return false;
        if (!Objects.equals(dataFechamento, compraDTO.dataFechamento))
            return false;
        return dataAbertura.equals(compraDTO.dataAbertura);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + id.hashCode();
        result = 31 * result + valorTotal.hashCode();
        result = 31 * result + cliente.hashCode();
        result = 31 * result + itensCompra.hashCode();
        result = 31 * result + (dataFechamento != null ? dataFechamento.hashCode() : 0);
        result = 31 * result + dataAbertura.hashCode();
        return result;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("CompraDTO{");
        sb.append("id=").append(id);
        sb.append(", valorTotal=").append(valorTotal);
        sb.append(", cliente=").append(cliente);
        sb.append(", itensCompra=").append(itensCompra);
        sb.append(", dataFechamento=").append(dataFechamento);
        sb.append(", dataAbertura=").append(dataAbertura);
        sb.append('}');
        return sb.toString();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ClienteDTO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteDTO cliente) {
        this.cliente = cliente;
    }

    public List<ItemCompraDTO> getItensCompra() {
        return itensCompra;
    }

    public void setItensCompra(List<ItemCompraDTO> itensCompra) {
        this.itensCompra = itensCompra;
    }

    public Date getDataFechamento() {
        return dataFechamento;
    }

    public void setDataFechamento(Date dataFechamento) {
        this.dataFechamento = dataFechamento;
    }

    public Date getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(Date dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }
}
