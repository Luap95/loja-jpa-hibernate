package br.com.loja.testes;

import br.com.loja.dao.CategoriaDao;
import br.com.loja.dao.ProdutoDao;
import br.com.loja.modelo.Categoria;
import br.com.loja.modelo.Produto;
import br.com.loja.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class UpdateProduto {
    public static void main(String[] args) {
        Categoria categoria = new Categoria("INFORMATICA", "TECNOLOGIA");

        Produto produto = new Produto("Teclado mecânico", "Teclado",
                new BigDecimal("300.99"), categoria);

        EntityManager entityManager = JPAUtil.getEntityManager();

        ProdutoDao produtoDao = new ProdutoDao(entityManager);
        CategoriaDao categoriaDao = new CategoriaDao(entityManager);

        entityManager.getTransaction().begin();

        categoriaDao.cadastrar(categoria);
        produtoDao.cadastrar(produto);

        entityManager.flush();
        entityManager.clear();

        produto.setDescricao("Teclado com luzes RGB");

        produtoDao.atualizar(produto);

        entityManager.flush();

    }
}
