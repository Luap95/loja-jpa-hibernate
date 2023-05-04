package br.com.loja.modelo;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pedidos")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate data = LocalDate.now();
    @ManyToOne
    private Cliente cliente;
    //Anotação de relacionamento bidirecional entre pedido e item
    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private List<ItemPedido> itens = new ArrayList<>();
    @Column(name = "valor_total")
    private BigDecimal valorTotal;

    public Pedido(Cliente cliente) {
        this.cliente = cliente;
    }
    public Pedido(){}

    public void adicionaItem(ItemPedido item){
        //método que faz a ligação bidirecional de pedido e item
        //item conhece pedido e pedido conhece item
        item.setPedido(this);
        this.itens.add(item);
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }
}
