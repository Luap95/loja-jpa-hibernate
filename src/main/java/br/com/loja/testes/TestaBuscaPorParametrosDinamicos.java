package br.com.loja.testes;

import br.com.loja.dao.ProdutoDao;
import br.com.loja.modelo.Produto;
import br.com.loja.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class TestaBuscaPorParametrosDinamicos {
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(entityManager);

        List<Produto> produtos = produtoDao.buscarPorParametros
                ("Xiaomi Redmi Note 9", null, null);

        produtos.forEach(produto -> System.out.println(produto));

        produtos = produtoDao.buscarPorParametros(null, new BigDecimal("2500.00"), null);

        produtos.forEach(produto -> System.out.println(produto));

        produtos = produtoDao.buscarPorParametros(null, null, LocalDate.parse("2023-05-05"));

        produtos.forEach(produto -> System.out.println(produto));

    }
}
