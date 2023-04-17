package com.fiap.jogos.entity;


import com.fiap.jogos.dto.DadosCadastroJogos;
import com.fiap.jogos.dto.DadosId;
import com.fiap.jogos.dto.DadosUpdateJogos;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "jogos")
@Entity(name = "Jogos")
public class Jogo {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	private String desenvolvedora;
	private String distribuidora;
	private String idiomas;
	private String jogadores;
	private String lancamento;
	
	@Enumerated(EnumType.STRING)
	private Genero genero;
	
	@Embedded
	private Requisitos requisitos;
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
	public String getDesenvolvedora() {
		return desenvolvedora;
	}
	public void setDesenvolvedora(String desenvolvedora) {
		this.desenvolvedora = desenvolvedora;
	}
	public String getDistribuidora() {
		return distribuidora;
	}
	public void setDistribuidora(String distribuidora) {
		this.distribuidora = distribuidora;
	}
	public String getIdiomas() {
		return idiomas;
	}
	public void setIdiomas(String idiomas) {
		this.idiomas = idiomas;
	}
	public String getJogadores() {
		return jogadores;
	}
	public void setJogadores(String jogadores) {
		this.jogadores = jogadores;
	}
	public String getLancamento() {
		return lancamento;
	}
	public void setLancamento(String lancamento) {
		this.lancamento = lancamento;
	}
	public Genero getGenero() {
		return genero;
	}
	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	public Requisitos getRequisitos() {
		return requisitos;
	}
	public void setRequisitos(Requisitos requisitos) {
		this.requisitos = requisitos;
	}
	public Boolean getAtivo() {
		return ativo;
	}
	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
	
	public Jogo() {}
	
	public Jogo(DadosCadastroJogos dados) {
		this.ativo = true;
		this.titulo = dados.titulo();
		this.desenvolvedora = dados.desenvolvedora();
		this.distribuidora = dados.distribuidora();
		this.idiomas = dados.idiomas();
		this.jogadores = dados.jogadores();
		this.lancamento = dados.lancamento();
		this.genero = dados.genero();
		this.requisitos = new Requisitos(dados.requisitos());
	}
	
	public void updateJogo(DadosUpdateJogos dados) {
		if(dados.titulo() != null) {
			this.titulo = dados.titulo();
		}
		if(dados.desenvolvedora() != null) {
			this.desenvolvedora = dados.desenvolvedora();
		}
		if(dados.jogadores() != null) {
			this.jogadores = dados.jogadores();
		}
		if(dados.genero() != null) {
			this.genero = dados.genero();
		}
		if(dados.requisitos() != null) {
			this.requisitos.updateJogo(dados.requisitos());
		}
	}
	public void deleteJogo(DadosId dados) {
	if(dados.id() != 0) {
		this.ativo = false;
	}
	else if(dados.id() != 1) {
		this.ativo = true;
	}
	}
}
	

