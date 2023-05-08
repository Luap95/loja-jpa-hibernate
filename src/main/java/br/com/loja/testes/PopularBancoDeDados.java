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
        Categoria livros = new Categoria("LIVRO", "LIVRARIA");
        Categoria celular = new Categoria("CELULAR", "COMUNICACAO");
        Categoria eletronico = new Categoria("ELETRONICO", "TECNOLOGIA");

        Produto narnia = new Produto("As crônicas de Narnia", "Fantasia",
                new BigDecimal("120.45"), livros);
        Produto xiaomi = new Produto("Xiaomi Redmi Note 9", "Smartphone",
                new BigDecimal("848.99"), celular);
        Produto nintendo = new Produto("Nintendo Switch", "Video game",
                new BigDecimal("2500.00"), eletronico);

        Cliente lucas = new Cliente("Lucas", "123456789");
        Cliente fabiola = new Cliente("Fabíola", "44445555411");
        Cliente michael = new Cliente("Michael", "44555123321");


        EntityManager entityManager = JPAUtil.getEntityManager();

        ProdutoDao produtoDao = new ProdutoDao(entityManager);
        CategoriaDao categoriaDao = new CategoriaDao(entityManager);
        ClienteDao clienteDao = new ClienteDao(entityManager);

        entityManager.getTransaction().begin();
        categoriaDao.cadastrar(livros);
        categoriaDao.cadastrar(celular);
        categoriaDao.cadastrar(eletronico);

        produtoDao.cadastrar(narnia);
        produtoDao.cadastrar(xiaomi);
        produtoDao.cadastrar(nintendo);

        clienteDao.cadastrar(lucas);
        clienteDao.cadastrar(fabiola);
        clienteDao.cadastrar(michael);

        entityManager.getTransaction().commit();

        entityManager.close();
    }

}
