package br.com.loja.testes;

import br.com.loja.dao.PedidoDao;
import br.com.loja.util.JPAUtil;
import br.com.loja.vo.RelatorioDeVendasVo;

import javax.persistence.EntityManager;
import java.util.List;

public class TestaRelatorioDeVendas {
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        PedidoDao pedidoDao = new PedidoDao(entityManager);

        List<RelatorioDeVendasVo> relatorio = pedidoDao.relatorioDeVendas();

        relatorio.forEach(System.out::println);
    }
}
