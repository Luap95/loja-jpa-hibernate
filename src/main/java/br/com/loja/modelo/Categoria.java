package br.com.loja.modelo;

import javax.persistence.*;

@Entity
@Table(name = "categorias")
public class Categoria {
    @EmbeddedId
    private CategoriaId id;

    public Categoria(){}

    public Categoria(String nome, String tipo){
        this.id = new CategoriaId(nome, tipo);
    }

    public void setNome(String nome){
        this.id = new CategoriaId(nome, "venda");
    }
    public String getNome(){
        return this.id.getNome();
    }
}
