package com.fiap.jogos.dto;

import com.fiap.jogos.entity.Genero;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record DadosUpdateJogos(
		
		@NotNull 
		Long id,
		@NotNull 
		String titulo,
		@NotNull 
		String desenvolvedora,
		@NotNull
		@Max(value = 4)@Min(value =1)
		String jogadores,
		@NotNull 
		Genero genero,
		@NotNull 
		DadosRequisitos requisitos
		
		) {

}
