package com.example.blueclover.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.blueclover.api.model.Lancamento;
import com.example.blueclover.api.repository.lancamento.LancamentoRepositoryQuery;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long>,  LancamentoRepositoryQuery {

}
