package com.example.blueclover.api.repository.lancamento;

import java.awt.print.Pageable;

import org.springframework.data.domain.Page;

import com.example.blueclover.api.model.Lancamento;
import com.example.blueclover.api.repository.filter.LancamentoFilter;
import com.example.blueclover.api.repository.projection.ResumoLancamento;

public interface LancamentoRepositoryQuery {

	public Page<Lancamento> filtrar(LancamentoFilter lancamentoFilter, org.springframework.data.domain.Pageable pageable);
	
	public Page<ResumoLancamento> resumir(LancamentoFilter lancamentoFilter, org.springframework.data.domain.Pageable pageable);


}