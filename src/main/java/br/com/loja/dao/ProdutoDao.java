package br.com.loja.dao;

import br.com.loja.modelo.Produto;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class ProdutoDao {

    private EntityManager entityManager;

    public ProdutoDao(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public void cadastrar(Produto produto){
        this.entityManager.persist(produto);
    }

    public void atualizar(Produto produto){
        this.entityManager.merge(produto);
    }

    public void remover(Produto produto){
        //Uma entidade não pode ser removida se ela estiver em datached
        //garantindo que a entidade estará em managed
        produto = entityManager.merge(produto);
        this.entityManager.remove(produto);
    }

    public Produto buscarPorId(Long id){
        //procurando entidade no banco de dados
        return entityManager.find(Produto.class, id);
    }

    public List<Produto> buscarTodos(){
        //Comando JPQL para consulta
        //Ele está referenciando uma entidade e não uma tabela como no SQL
        String jpql = "SELECT p FROM Produto p";
        //Executando a query e retornando a lista do tipo produto
        return entityManager.createQuery(jpql, Produto.class).getResultList();
    }
    public List<Produto> buscarPorNome(String nome){
        //Comando JPQL para consulta com parâmetro
        //Ao definir um parâmetro deve identifica-lo pelo : ou por ?1(2, 3 ...)
        String jpql = "SELECT p FROM Produto p WHERE p.nome = :nome";
        //Setando a propriedade
        //Em caso da parâmetro estar como ?1, setar como (1, nome)
        return entityManager.createQuery(jpql, Produto.class)
                .setParameter("nome", nome)
                .getResultList();
    }
    public List<Produto> buscarPorNomeDaCategoria(String nomeCategoria){
        //Comando JPQL para consulta com parâmetro com Join
        //Ao definir um parâmetro deve identifica-lo pelo : ou por ?1(2, 3 ...)
        String jpql = "SELECT p FROM Produto p WHERE p.categoria.categoria = :nome";
        //Setando a propriedade
        //Em caso da parâmetro estar como ?1, setar como (1, nome)
        return entityManager.createQuery(jpql, Produto.class)
                .setParameter("nome", nomeCategoria)
                .getResultList();
    }
    public BigDecimal buscarPrecoPorNome(String nome){
        //Comando JPQL para consulta com parâmetro
        //Ao definir um parâmetro deve identifica-lo pelo : ou por ?1(2, 3 ...)
        String jpql = "SELECT p.preco FROM Produto p WHERE p.nome = :nome";
        //Setando a propriedade
        //Em caso da parâmetro estar como ?1, setar como (1, nome)
        return entityManager.createQuery(jpql, BigDecimal.class)
                .setParameter("nome", nome)
                .getSingleResult();
        //getSingleResult é usado quando é retornado somente 1 resultado
    }
}
