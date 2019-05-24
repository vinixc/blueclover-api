package com.example.blueclover.api.repository.pessoa;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.blueclover.api.model.Pessoa;
import com.example.blueclover.api.repository.filter.LancamentoFilter;
import com.example.blueclover.api.repository.filter.PessoaFilter;
import com.example.blueclover.api.repository.projection.ResumoLancamento;
import com.example.blueclover.api.repository.projection.ResumoPessoa;

public interface PessoaRepositoryQuery {
	public Page<Pessoa> filtrar(PessoaFilter pessoaFilter, Pageable pageable);
	public Page<ResumoPessoa> resumir(PessoaFilter pessoaFilter, org.springframework.data.domain.Pageable pageable);

}
