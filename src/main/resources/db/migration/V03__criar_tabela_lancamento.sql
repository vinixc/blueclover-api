CREATE TABLE lancamento(
	codigo INTEGER DEFAULT NEXTVAL('sequence_lancamento') primary key,
	descicrao VARCHAR(50) NOT NULL,
	data_vencimento DATE NOT NULL,
	data_pagamento DATE,
	valor DECIMAL(10,2) NOT NULL,
	observacao VARCHAR(100),
	tipo VARCHAR(20) NOT NULL,
	codigo_categoria BIGINT NOT NULL,
	codigo_pessoa BIGINT NOT NULL,
	CONSTRAINT codigo_categoria_fk FOREIGN KEY (codigo_categoria) REFERENCES categoria(codigo),
	CONSTRAINT codigo_pessoa_fk FOREIGN KEY (codigo_pessoa) REFERENCES pessoa(codigo)
);