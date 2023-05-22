USE livraria;

CREATE TABLE livros (
    id INT AUTO_INCREMENT PRIMARY KEY,
    Titulo VARCHAR(50) NOT NULL,
    Autor VARCHAR(50) NOT NULL,
    data_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO livros (Titulo, Autor)
VALUES ('Livro1', 'Pedro Pascal'),
	   ('Livro2', 'Jorge Freitas'),
       ('Livro3', 'Maria dos Santos');
