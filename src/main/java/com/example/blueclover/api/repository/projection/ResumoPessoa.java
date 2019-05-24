package com.example.blueclover.api.repository.projection;

public class ResumoPessoa {
	
	public ResumoPessoa(Long codigo, String nome) {
		this.codigo = codigo;
		this.nome = nome;
	}
	
	private Long codigo;
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	private String nome;
}
