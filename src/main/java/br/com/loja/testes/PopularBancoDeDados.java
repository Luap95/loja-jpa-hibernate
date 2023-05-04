package br.com.loja.testes;

import br.com.loja.dao.CategoriaDao;
import br.com.loja.dao.ClienteDao;
import br.com.loja.dao.ProdutoDao;
import br.com.loja.modelo.Categoria;
import br.com.loja.modelo.Cliente;
import br.com.loja.modelo.Produto;
import br.com.loja.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public abstract class PopularBancoDeDados {

    public static void cadastroProduto(){
        Categoria categoria = new Categoria("LIVROS");

        Produto produto = new Produto("As crônicas de Narnia", "Fantasia",
                new BigDecimal("120.45"), categoria);

        Cliente cliente = new Cliente("Lucas", "123456789");


        EntityManager entityManager = JPAUtil.getEntityManager();

        ProdutoDao produtoDao = new ProdutoDao(entityManager);
        CategoriaDao categoriaDao = new CategoriaDao(entityManager);
        ClienteDao clienteDao = new ClienteDao(entityManager);

        entityManager.getTransaction().begin();
        categoriaDao.cadastrar(categoria);
        produtoDao.cadastrar(produto);
        clienteDao.cadastrar(cliente);
        entityManager.getTransaction().commit();

        entityManager.close();
    }

}
