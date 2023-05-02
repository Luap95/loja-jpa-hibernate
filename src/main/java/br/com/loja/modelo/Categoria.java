package br.com.loja.modelo;

import javax.persistence.*;

@Entity
@Table(name = "categorias")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String categoria;

    public Categoria(){}
    public Categoria(String categoria){
        this.categoria = categoria;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "id=" + id +
                ", categoria='" + categoria + '\'' +
                '}';
    }
}
