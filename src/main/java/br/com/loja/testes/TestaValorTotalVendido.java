package br.com.loja.testes;

import br.com.loja.dao.PedidoDao;
import br.com.loja.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class TestaValorTotalVendido {
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        PedidoDao pedidoDao = new PedidoDao(entityManager);
        BigDecimal valorTotalVendido = pedidoDao.valorTotalVendido();

        System.out.println("O valor total vendido é: " + valorTotalVendido);
    }
}
