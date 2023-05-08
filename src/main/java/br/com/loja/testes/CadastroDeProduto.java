package br.com.loja.testes;

import br.com.loja.dao.CategoriaDao;
import br.com.loja.dao.ProdutoDao;
import br.com.loja.modelo.Categoria;
import br.com.loja.modelo.Produto;
import br.com.loja.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class CadastroDeProduto {
    public static void main(String[] args) {
        Categoria celulares = new Categoria("CELULARES", "COMUNICAÇÃO");

        Produto celular = new Produto("Xiaomi Redmi Note 9", "Smartphone Xiaomi",
                new BigDecimal("980.54"), celulares);


        EntityManager entityManager = JPAUtil.getEntityManager();

        ProdutoDao produtoDao = new ProdutoDao(entityManager);
        CategoriaDao categoriaDao = new CategoriaDao(entityManager);

        entityManager.getTransaction().begin();
        categoriaDao.cadastrar(celulares);
        produtoDao.cadastrar(celular);
        entityManager.getTransaction().commit();

        entityManager.close();
    }
}
