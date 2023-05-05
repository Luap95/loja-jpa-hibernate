package br.com.loja.modelo;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "itens_pedido")
//classe que representa Tabela Join de produtos e pedidos
public class ItemPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "preco_unitario")
    private BigDecimal precoUnitario;
    private int quantidade;
    @ManyToOne
    private Produto produto;
    @ManyToOne
    private Pedido pedido;

    public ItemPedido(int quantidade, Produto produto, Pedido pedido) {
        this.quantidade = quantidade;
        this.precoUnitario = produto.getPreco();
        this.produto = produto;
        this.pedido = pedido;
    }
    public ItemPedido(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(BigDecimal precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public BigDecimal getValor(){
        return this.precoUnitario.multiply(new BigDecimal(this.quantidade));
    }
}
