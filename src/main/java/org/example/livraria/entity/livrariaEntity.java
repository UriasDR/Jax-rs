package org.example.livraria.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "livros")
public class livrariaEntity implements Serializable {
    @Id
    private Long id;

    @Column(name = "Titulo")
    private String Titulo;

    @Column(name = "Autor")
    private String Autor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        this.Titulo = titulo;
    }

    public String getAutor() {
        return Autor;
    }

    public void setAutor(String autor) {
        this.Autor = autor;
    }

}
