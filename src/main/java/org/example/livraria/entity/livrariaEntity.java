package org.example.livraria.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "livro")
public class livrariaEntity implements Serializable {
    @Id
    private Long id;

    @Column
    private String Titulo;

    private String Autor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = this.id;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        Titulo = this.Titulo;
    }

    public String getAutor() {
        return Autor;
    }

    public void setAutor(String autor) {
        Autor = this.Autor;
    }
}
