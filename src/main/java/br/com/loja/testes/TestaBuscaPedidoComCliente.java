package br.com.loja.testes;

import br.com.loja.dao.PedidoDao;
import br.com.loja.modelo.Cliente;
import br.com.loja.modelo.Pedido;
import br.com.loja.util.JPAUtil;

import javax.persistence.EntityManager;

public class TestaBuscaPedidoComCliente {
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        PedidoDao pedidoDao = new PedidoDao(entityManager);

        Pedido pedido = pedidoDao.buscarPedidoComCliente(2l);

        System.out.println(pedido.getCliente());
    }
}
