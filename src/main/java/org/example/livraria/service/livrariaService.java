package org.example.livraria.service;

import org.example.livraria.entity.livrariaEntity;
import org.example.livraria.request.livrariaRequest;
import org.example.livraria.response.livrariaResponse;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class livrariaService {

    private static final String DB_URL = "jdbc:postgresql://localhost:5432/livraria";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "1234";


    public List<livrariaEntity> returnLivros() {
        List<livrariaEntity> livrosList = new ArrayList<>();
        /*
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String query = "SELECT * FROM public.livros ORDER BY id ASC LIMIT 100";
            PreparedStatement statement = connection.prepareStatement(query);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String titulo = resultSet.getString("Titulo");
                String autor = resultSet.getString("Autor");
                livrariaEntity livroEntity = new livrariaEntity();
                livroEntity.setId((long) id);
                livroEntity.setTitulo(titulo);
                livroEntity.setAutor(autor);

                livrosList.add(livroEntity);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } */
        livrariaEntity livroEntity = new livrariaEntity();
        livroEntity.setId((long) 1);
        livroEntity.setTitulo("Livro 1");
        livroEntity.setAutor("Autor 1");

        livrosList.add(livroEntity);
        System.out.println(livrosList);
        return livrosList;
    }
        public List<livrariaEntity> returnLivrosID ( int id){
            List<livrariaEntity> livrosList = new ArrayList<>();

            try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
                String query = "SELECT Titulo, Autor FROM public.livros WHERE id = ?";
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setInt(1, id);
                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    String titulo = resultSet.getString("Titulo");
                    String autor = resultSet.getString("Autor");

                    livrariaEntity livroEntity = new livrariaEntity();
                    livroEntity.setTitulo(titulo);
                    livroEntity.setAutor(autor);
                    livrosList.add(livroEntity);
                }
                resultSet.close();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return livrosList;
        }

        public void deleteLivros ( int id){
            try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
                String query = "DELETE FROM products WHERE id = ?";
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setInt(1, id);

                int rowsDeleted = statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public void putLivros ( int id, livrariaRequest request){
            try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
                String query = "UPDATE livros SET Titulo = ?, Autor = ? WHERE id = ?";
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setString(1, request.getTitulo());
                statement.setString(2, request.getAutor());
                statement.setInt(3, id);

                int rowsUpdated = statement.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        public void postLivros (livrariaRequest livrariaRequest){
            try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
                String query = "INSERT INTO livros (Titulo, Autor) VALUES (?, ?)";
                PreparedStatement statement = connection.prepareStatement(query);

                statement.setString(1, livrariaRequest.getTitulo());
                statement.setString(2, livrariaRequest.getAutor());

                int rowsInserted = statement.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public livrariaEntity getTitulos () {
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
