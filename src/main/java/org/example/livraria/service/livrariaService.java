package org.example.livraria.service;

import org.example.livraria.entity.livrariaEntity;
import org.example.livraria.request.livrariaRequest;
import org.example.livraria.response.livrariaResponse;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class livrariaService {
    public String returnLivros(String titulo) {
        livrariaResponse livrosResponse = new livrariaResponse();
        livrosResponse.setTitulo(new StringBuilder()
                .append("Receive: ")
                .append(titulo)
                .toString());
        return livrosResponse.toString();
    }

    public void postLivros(livrariaRequest livrariaRequest) {
        livrariaEntity livroEntity = new livrariaEntity();
        EntityManager entityManager = Persistence
                .createEntityManagerFactory("Trabalho_jax_rs")
                .createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            livroEntity.setId(1L);
            livroEntity.setTitulo(livrariaRequest.getTitulo());
            entityManager.persist(livroEntity);
            transaction.commit();
        } catch (Exception e) {
            throw e;
        } finally {
            entityManager.clear();
            entityManager.close();
        }
    }

    public livrariaEntity getTitulos() {
        livrariaEntity livroEntity = new livrariaEntity();
        EntityManager entityManager = Persistence
                .createEntityManagerFactory("Trabalho_jax_rs")
                .createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();

            livroEntity = entityManager.find(livrariaEntity.class, 1L);
            transaction.commit();
            return livroEntity;
        } catch (Exception e) {
            throw e;
        } finally {
            entityManager.clear();
            entityManager.close();
        }
    }
}
