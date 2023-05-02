package br.com.loja.testes;

import br.com.loja.dao.CategoriaDao;
import br.com.loja.dao.ProdutoDao;
import br.com.loja.modelo.Produto;
import br.com.loja.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class SelectProdutoComParametro {
    public static void main(String[] args) {
        //Instanciando gerenciador de entidades do JPA
        EntityManager entityManager = JPAUtil.getEntityManager();

        //Instaciando as DAO
        ProdutoDao produtoDao = new ProdutoDao(entityManager);
        CategoriaDao categoriaDao = new CategoriaDao(entityManager);

        //Buscar produtos por nome
        List<Produto> produtos = produtoDao.buscarPorNome("Xiaomi Redmi Note 9");
        //Listando produtos
        produtos.forEach(p -> System.out.println(p));

        //Buscar produtos por categoria
            List<Produto> produtoList = produtoDao.buscarPorNomeDaCategoria("Celulares");
        //Listando produtos
        produtoList.forEach(p -> System.out.println(p));

        //Buscar preço produtos por nome
        BigDecimal precoProduto = produtoDao.buscarPrecoPorNome("Xiaomi Redmi Note 9");
        //Imprimindo preço
        System.out.println("O preço do produto é: " + precoProduto);
    }
}
