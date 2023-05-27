package atom.juice.apicompras.data.dto;

public class ItemCompraDTO {

    private Long id;

    private Double valorTotal;

    private Double valorProdutoUnitarioCriacao;

    private int quantidadeProduto;

    private ProdutoDTO produto;

    private CompraDTO compra;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ItemCompraDTO that)) return false;

        if (quantidadeProduto != that.quantidadeProduto) return false;
        if (!id.equals(that.id)) return false;
        if (!valorTotal.equals(that.valorTotal)) return false;
        if (!valorProdutoUnitarioCriacao.equals(that.valorProdutoUnitarioCriacao)) return false;
        if (!produto.equals(that.produto)) return false;
        return compra.equals(that.compra);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + valorTotal.hashCode();
        result = 31 * result + valorProdutoUnitarioCriacao.hashCode();
        result = 31 * result + quantidadeProduto;
        result = 31 * result + produto.hashCode();
        result = 31 * result + compra.hashCode();
        return result;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ItemCompraDTO{");
        sb.append("id=").append(id);
        sb.append(", valorTotal=").append(valorTotal);
        sb.append(", valorProdutoUnitarioCriacao=").append(valorProdutoUnitarioCriacao);
        sb.append(", quantidadeProduto=").append(quantidadeProduto);
        sb.append(", produto=").append(produto);
        sb.append(", compra=").append(compra);
        sb.append('}');
        return sb.toString();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Double getValorProdutoUnitarioCriacao() {
        return valorProdutoUnitarioCriacao;
    }

    public void setValorProdutoUnitarioCriacao(Double valorProdutoUnitarioCriacao) {
        this.valorProdutoUnitarioCriacao = valorProdutoUnitarioCriacao;
    }

    public int getQuantidadeProduto() {
        return quantidadeProduto;
    }

    public void setQuantidadeProduto(int quantidadeProduto) {
        this.quantidadeProduto = quantidadeProduto;
    }

    public ProdutoDTO getProduto() {
        return produto;
    }

    public void setProduto(ProdutoDTO produto) {
        this.produto = produto;
    }

    public CompraDTO getCompra() {
        return compra;
    }

    public void setCompra(CompraDTO compra) {
        this.compra = compra;
    }
}
