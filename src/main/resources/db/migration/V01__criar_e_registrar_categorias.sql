CREATE TABLE categoria(
codigo INTEGER DEFAULT NEXTVAL('codigo') primary key,
nome VARCHAR(50) NOT NULL
);

INSERT INTO categoria (nome) values('Lazer');
INSERT INTO categoria (nome) values ('Alimentação');
INSERT INTO categoria (nome) values ('Supermercado');
INSERT INTO categoria (nome) values ('Farmacia');
INSERT INTO categoria (nome) values ('Outros');