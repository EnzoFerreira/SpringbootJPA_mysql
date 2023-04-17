package com.fiap.jogos.dto;

import com.fiap.jogos.entity.Genero;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroJogos(
		
		@NotBlank
		String titulo,
		@NotBlank
		String desenvolvedora,
		String distribuidora,
		String idiomas,
		@NotBlank
		@Max(value = 4)@Min(value =1)
		String jogadores,
		@NotBlank
		@Pattern(regexp="\\d{4}")
		String lancamento,
		@NotNull
		Genero genero,
		@NotNull
		@Valid
		DadosRequisitos requisitos
	) {
	
}
