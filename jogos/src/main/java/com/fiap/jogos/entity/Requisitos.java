package com.fiap.jogos.entity;

import com.fiap.jogos.dto.DadosRequisitos;

import jakarta.persistence.Embeddable;

@Embeddable
public class Requisitos {
	
	private String sistemaop;
	private String processador;
	private String memoria;
	private String placavideo;
	private String armazenamento;
	
	public String getSistemaop() {
		return sistemaop;
	}
	public void setSistemaop(String sistemaop) {
		this.sistemaop = sistemaop;
	}
	public String getProcessador() {
		return processador;
	}
	public void setProcessador(String processador) {
		this.processador = processador;
	}
	public String getMemoria() {
		return memoria;
	}
	public void setMemoria(String memoria) {
		this.memoria = memoria;
	}
	public String getPlacavideo() {
		return placavideo;
	}
	public void setPlacavideo(String placavideo) {
		this.placavideo = placavideo;
	}
	public String getArmazenamento() {
		return armazenamento;
	}
	public void setArmazenamento(String armazenamento) {
		this.armazenamento = armazenamento;
	}
	
	public Requisitos() {}
	
	public Requisitos(DadosRequisitos requisitos) {
		this.sistemaop = requisitos.sistemaop();
		this.processador = requisitos.processador();
		this.placavideo = requisitos.placavideo();
		this.memoria = requisitos.memoria();
		this.armazenamento = requisitos.armazenamento();
	}
	public void updateJogo(DadosRequisitos dados) {
		if (dados.sistemaop() != null) {
			this.sistemaop = dados.sistemaop();
		}
		if (dados.processador() != null) {
			this.processador = dados.processador();
		}
		if (dados.placavideo() != null) {
			this.placavideo = dados.placavideo();
		}
		if (dados.memoria() != null) {
			this.memoria = dados.memoria();
		}
		if (dados.armazenamento() != null) {
			this.armazenamento = dados.armazenamento();
		}
	}
}
