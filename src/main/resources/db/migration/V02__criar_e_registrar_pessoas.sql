create table pessoa(
codigo INTEGER DEFAULT NEXTVAL('pessoas') primary key,
nome VARCHAR(60) NOT NULL,
ativo BOOLEAN,
logradouro VARCHAR(60),
numero VARCHAR(10),
complemento VARCHAR(40),
bairro VARCHAR(40),
cep VARCHAR(10),
cidade VARCHAR(40),
estado VARCHAR(20));
