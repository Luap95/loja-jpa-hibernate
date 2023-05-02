package br.com.loja.testes;

import br.com.loja.dao.CategoriaDao;
import br.com.loja.dao.ProdutoDao;
import br.com.loja.modelo.Categoria;
import br.com.loja.modelo.Produto;
import br.com.loja.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class RemoveProdutos {
    public static void main(String[] args) {
        //Instaciando produto e categoria
        Categoria categoria = new Categoria("LIVRO");
        Produto produto = new Produto("As cronicas de Narnia", "Livro de fantasia",
                new BigDecimal("99.99"), categoria);
        //Instanciando gerenciador de entidades do JPA
        EntityManager entityManager = JPAUtil.getEntityManager();
        //Instaciando as DAO
        ProdutoDao produtoDao = new ProdutoDao(entityManager);
        CategoriaDao categoriaDao = new CategoriaDao(entityManager);
        //iniciando transação
        entityManager.getTransaction().begin();
        //preparando inserts
        categoriaDao.cadastrar(categoria);
        produtoDao.cadastrar(produto);
        //executando transação
        entityManager.flush();
        //preparando delete
        produtoDao.remover(produto);
        categoriaDao.remover(categoria);
        //executando transação
        entityManager.flush();
        //fechando transação
        entityManager.close();

    }
}
