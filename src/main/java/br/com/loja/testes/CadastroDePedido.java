package br.com.loja.testes;

import br.com.loja.dao.ClienteDao;
import br.com.loja.dao.PedidoDao;
import br.com.loja.dao.ProdutoDao;
import br.com.loja.modelo.Cliente;
import br.com.loja.modelo.ItemPedido;
import br.com.loja.modelo.Pedido;
import br.com.loja.modelo.Produto;
import br.com.loja.util.JPAUtil;

import javax.persistence.EntityManager;

public class CadastroDePedido {

    public static void main(String[] args) {

        PopularBancoDeDados.cadastroProduto();

        EntityManager entityManager = JPAUtil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(entityManager);
        ClienteDao clienteDao = new ClienteDao(entityManager);

        Produto produto = produtoDao.buscarPorId(2l);
        Cliente cliente = clienteDao.buscarPorId(2l);

        entityManager.getTransaction().begin();


        Pedido pedido = new Pedido(cliente);
        pedido.adicionaItem(new ItemPedido(2, produto, pedido));

        PedidoDao pedidoDao = new PedidoDao(entityManager);
        pedidoDao.cadastrar(pedido);

        entityManager.getTransaction().commit();
        entityManager.close();

    }

}
