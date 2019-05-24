package com.example.blueclover.api.repository.pessoa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import com.example.blueclover.api.model.Lancamento;
import com.example.blueclover.api.model.Pessoa;
import com.example.blueclover.api.model.Pessoa_;
import com.example.blueclover.api.repository.filter.LancamentoFilter;
import com.example.blueclover.api.repository.filter.PessoaFilter;
import com.example.blueclover.api.repository.projection.ResumoLancamento;
import com.example.blueclover.api.repository.projection.ResumoPessoa;

public class PessoaRepositoryImpl implements PessoaRepositoryQuery {
	
	@PersistenceContext
	private EntityManager manager;
		
	
	public Page<Pessoa> filtrar(PessoaFilter pessoaFilter, Pageable pageable){
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Pessoa> criteria = builder.createQuery(Pessoa.class);
		Root<Pessoa> root = criteria.from(Pessoa.class);
		
		Predicate[] predicates = criarRestricoes(pessoaFilter, builder, root);
		criteria.where(predicates);
		
		TypedQuery<Pessoa> query = manager.createQuery(criteria);
		adicionarRestricoesDePaginacao(query, pageable);
		
		return new PageImpl<>(query.getResultList(), pageable, total(pessoaFilter));
	}
	
	private Predicate[] criarRestricoes(PessoaFilter pessoaFilter, CriteriaBuilder builder,
			Root<Pessoa> root) {
		List<Predicate> predicates = new ArrayList<>();
		
		if (!StringUtils.isEmpty(pessoaFilter.getNome())) {
			predicates.add(builder.like(
					builder.lower(root.get(Pessoa_.nome)), "%" + pessoaFilter.getNome().toLowerCase() + "%"));
		}
		
		return predicates.toArray(new Predicate[predicates.size()]);
	}
	
	public Page<ResumoPessoa> resumir(PessoaFilter pessoaFilter, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<ResumoPessoa> criteria = builder.createQuery(ResumoPessoa.class);
		Root<Pessoa> root = criteria.from(Pessoa.class);
		
		criteria.multiselect(builder.construct(ResumoLancamento.class
				, root.get(Pessoa_.codigo), root.get(Pessoa_.nome)));
				
		
		Predicate[] predicates = criarRestricoes(pessoaFilter, builder, root);
		criteria.where(predicates);
		
		TypedQuery<ResumoPessoa> query = manager.createQuery(criteria);
		adicionarRestricoesDePaginacao(query, (Pageable) pageable);
		return new PageImpl<>(query.getResultList(), pageable, total(pessoaFilter));
		
		}
	
	private void adicionarRestricoesDePaginacao(TypedQuery<?> query, Pageable pageable) {
		int paginaAtual = pageable.getPageNumber();
		int totalRegistrosPorPagina = pageable.getPageSize();
		int primeiroRegistroDaPagina = paginaAtual * totalRegistrosPorPagina;
		
		query.setFirstResult(primeiroRegistroDaPagina);
		query.setMaxResults(totalRegistrosPorPagina);
	}
	
	private Long total(PessoaFilter pessoaFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<Pessoa> root = criteria.from(Pessoa.class);
		
		Predicate[] predicates = criarRestricoes(pessoaFilter, builder, root);
		criteria.where(predicates);
		
		criteria.select(builder.count(root));
		return manager.createQuery(criteria).getSingleResult();
	}
	
}
