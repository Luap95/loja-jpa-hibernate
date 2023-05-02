package br.com.loja.dao;

import br.com.loja.modelo.Categoria;

import javax.persistence.EntityManager;
import java.util.List;

public class CategoriaDao {

    private EntityManager entityManager;

    public CategoriaDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void cadastrar(Categoria categoria){
        this.entityManager.persist(categoria);
    }
    public void alterar(Categoria categoria){
        this.entityManager.merge(categoria);
    }
    public void remover(Categoria categoria){
        categoria = entityManager.merge(categoria);
        this.entityManager.remove(categoria);
    }
    public Categoria buscarPorId(Long id){
        return entityManager.find(Categoria.class, id);
    }
    public List<Categoria> buscarTodos(){
        //Comando JPQL para consulta
        //Ele está referenciando uma entidade e não uma tabela como no SQL
        String jpql = "SELECT c FROM Categoria c";
        //Executando a query e retornando a lista do tipo produto
        return entityManager.createQuery(jpql, Categoria.class).getResultList();
    }
}
