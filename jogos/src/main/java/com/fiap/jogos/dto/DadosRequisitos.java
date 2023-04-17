package com.fiap.jogos.dto;

import jakarta.validation.constraints.NotBlank;

public record DadosRequisitos(
		String sistemaop,
		@NotBlank
		String processador,
		@NotBlank
		String memoria,
		@NotBlank
		String placavideo,
		@NotBlank
		String armazenamento
	) {

}
