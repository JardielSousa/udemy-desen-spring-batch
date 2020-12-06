-- File configs for init databases

CREATE DATABASE spring_batch;
CREATE DATABASE spring_batch_app;
CREATE DATABASE par_impar_jobs;

\c spring_batch_app

CREATE TABLE cliente (
	nome TEXT,
	sobrenome TEXT,
	idade TEXT,
	email TEXT
);

INSERT INTO cliente VALUES ('Joao', 'Silva', '30', 'joao@test.com');
INSERT INTO cliente VALUES ('Maria', 'Silva', '30', 'maria@test.com');