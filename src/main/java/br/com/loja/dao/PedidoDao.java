package br.com.loja.dao;

import br.com.loja.modelo.Pedido;
import br.com.loja.vo.RelatorioDeVendasVo;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class PedidoDao {

    private EntityManager entityManager;

    public PedidoDao(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public void cadastrar(Pedido pedido){
        this.entityManager.persist(pedido);
    }

    public void atualizar(Pedido pedido){
        this.entityManager.merge(pedido);
    }

    public void remover(Pedido pedido){
        //Uma entidade não pode ser removida se ela estiver em datached
        //garantindo que a entidade estará em managed
        pedido = entityManager.merge(pedido);
        this.entityManager.remove(pedido);
    }

    public Pedido buscarPorId(Long id){
        //procurando entidade no banco de dados
        return entityManager.find(Pedido.class, id);
    }

    public List<Pedido> buscarTodos(){
        //Comando JPQL para consulta
        //Ele está referenciando uma entidade e não uma tabela como no SQL
        String jpql = "SELECT p FROM Pedido p";
        //Executando a query e retornando a lista do tipo produto
        return entityManager.createQuery(jpql, Pedido.class).getResultList();
    }

    public BigDecimal valorTotalVendido(){
        //Consulta com função de agregação
        String jpql = "SELECT SUM(p.valorTotal) FROM Pedido p";
        return entityManager.createQuery(jpql, BigDecimal.class).getSingleResult();
    }

    public List<RelatorioDeVendasVo> relatorioDeVendas(){
        String jpql = "SELECT new br.com.loja.vo.RelatorioDeVendasVo("
                + "produto.nome, "
                + "SUM(item.quantidade), "
                + "MAX(pedido.data)) "
                + "FROM Pedido pedido "
                + "JOIN pedido.itens item "
                + "JOIN item.produto produto "
                + "GROUP BY produto.nome "
                + "ORDER BY item.quantidade DESC";

        return entityManager.createQuery(jpql, RelatorioDeVendasVo.class).getResultList();
    }
}
