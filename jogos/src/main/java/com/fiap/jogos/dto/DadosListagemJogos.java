package com.fiap.jogos.dto;

import com.fiap.jogos.entity.Genero;
import com.fiap.jogos.entity.Jogo;

public record DadosListagemJogos(
		
		Long id,
		String titulo,
		String desenvolvedora,
		String jogadores,
		Genero genero,
		String armazenamento
		) {
	public DadosListagemJogos(Jogo jogo) {
		this(
				jogo.getId(),
				jogo.getTitulo(),
				jogo.getDesenvolvedora(),
				jogo.getJogadores(),
				jogo.getGenero(),
				jogo.getRequisitos().getArmazenamento()
				);
	}
}
