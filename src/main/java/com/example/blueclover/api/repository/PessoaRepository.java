package com.example.blueclover.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.blueclover.api.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

}
