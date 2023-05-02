package br.com.loja.testes;

import br.com.loja.dao.CategoriaDao;
import br.com.loja.dao.ProdutoDao;
import br.com.loja.modelo.Categoria;
import br.com.loja.modelo.Produto;
import br.com.loja.util.JPAUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class SelectProduto {
    public static void main(String[] args) {

        //Instanciando gerenciador de entidades do JPA
        EntityManager entityManager = JPAUtil.getEntityManager();

        //Instaciando as DAO
        ProdutoDao produtoDao = new ProdutoDao(entityManager);
        CategoriaDao categoriaDao = new CategoriaDao(entityManager);

        //Fazendo a consulta por Id e instaciando classes modelo
        Produto produto = produtoDao.buscarPorId(3l);
        Categoria categoria = categoriaDao.buscarPorId(3l);

        //Imprimindo resultado das consultas
        System.out.println(produto);
        System.out.println(categoria);

        //Buscar todos os Produtos salvos;
        List<Produto> produtos = produtoDao.buscarTodos();
        //Imprimindo produtos da lista
        produtos.forEach(p -> System.out.println(p));

        //Buscar todas as categorias salvas;
        List<Categoria> categorias = categoriaDao.buscarTodos();
        //Imprimindo categorias da lista
        categorias.forEach(c -> System.out.println(c));
    }
}
