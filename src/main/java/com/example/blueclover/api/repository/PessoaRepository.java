package com.example.blueclover.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.blueclover.api.model.Pessoa;
import com.example.blueclover.api.repository.pessoa.PessoaRepositoryQuery;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>, PessoaRepositoryQuery{
	public Page<Pessoa> findByNomeContaining(String nome, Pageable pageable);
}
