package com.fiap.catalogo.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import com.fiap.catalogo.model.dto.DadosCadastroFilme;

import jakarta.persistence.Embedded;
import jakarta.persistence.Table;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;


@Table(name="filmes")
@Entity(name="Filme")
public class Filme {
	@Id @GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	private String ator;
	private String duracao;
	private String lancamento;
	private String pais;

	@Enumerated(EnumType.STRING)
	private Genero genero;
	
	@Embedded
	private Ficha ficha;
	private Boolean ativo;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAtor() {
		return ator;
	}
	public void setAtor(String ator) {
		this.ator = ator;
	}
	public String getDuracao() {
		return duracao;
	}
	public void setDuracao(String duracao) {
		this.duracao = duracao;
	}
	public String getLancamento() {
		return lancamento;
	}
	public void setLancamento(String lancamento) {
		this.lancamento = lancamento;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public Genero getGenero() {
		return genero;
	}
	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	public Ficha getFicha() {
		return ficha;
	}
	public void setFicha(Ficha ficha) {
		this.ficha = ficha;
	}
	public Boolean getAtivo() {
		return ativo;
	}
	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
	
	public Filme() {}
	public Filme(DadosCadastroFilme dados) {
		this.ativo = true;
		this.titulo = dados.titulo();
		this.ator = dados.ator();
		this.duracao = dados.duracao();
		this.lancamento = dados.lancamento();
		this.pais = dados.pais();
		this.genero = dados.genero();
		this.ficha = new Ficha(dados.ficha());

	}
	
	
}
