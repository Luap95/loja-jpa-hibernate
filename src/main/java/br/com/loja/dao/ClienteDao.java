package br.com.loja.dao;

import br.com.loja.modelo.Cliente;
import br.com.loja.modelo.Produto;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class ClienteDao {

    private EntityManager entityManager;

    public ClienteDao(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public void cadastrar(Cliente cliente){
        this.entityManager.persist(cliente);
    }

    public void atualizar(Cliente cliente){
        this.entityManager.merge(cliente);
    }

    public void remover(Cliente cliente){
        //Uma entidade não pode ser removida se ela estiver em datached
        //garantindo que a entidade estará em managed
        cliente = entityManager.merge(cliente);
        this.entityManager.remove(cliente);
    }

    public Cliente buscarPorId(Long id){
        //procurando entidade no banco de dados
        return entityManager.find(Cliente.class, id);
    }

    public List<Cliente> buscarTodos(){
        //Comando JPQL para consulta
        //Ele está referenciando uma entidade e não uma tabela como no SQL
        String jpql = "SELECT c FROM Cliente c";
        //Executando a query e retornando a lista do tipo produto
        return entityManager.createQuery(jpql, Cliente.class).getResultList();
    }
    public List<Cliente> buscarPorNome(String nome){
        //Comando JPQL para consulta com parâmetro
        //Ao definir um parâmetro deve identifica-lo pelo : ou por ?1(2, 3 ...)
        String jpql = "SELECT c FROM Cliente c WHERE c.nome = :nome";
        //Setando a propriedade
        //Em caso da parâmetro estar como ?1, setar como (1, nome)
        return entityManager.createQuery(jpql, Cliente.class)
                .setParameter("nome", nome)
                .getResultList();
    }

}
