CREATE DATABASE "Livraria"
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;

CREATE TABLE public."livros"
(
    id serial NOT NULL,
    "Titulo" text NOT NULL,
    "Autor" text NOT NULL,
    PRIMARY KEY (id)
);

ALTER TABLE IF EXISTS public."livros"
    OWNER to postgres;


INSERT INTO public.livros(
	"Titulo", "Autor", id)
	VALUES ('Livro 1', 'Roger', 1);
