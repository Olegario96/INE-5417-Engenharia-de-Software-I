package modelo;

import java.util.Vector;

public class Tabuleiro {
	private Jogador _jogador1;
	private Jogador _jogador2;
	private boolean _partida_em_andamento;
	private boolean _conectado;
	private Dado _dados[];
	private Posicao posicoes[][];

	public Tabuleiro(Jogador _jogador1, Jogador _jogador2) {
		this._jogador1 = _jogador1;
		this._jogador2 = _jogador2;
		iniciaizarTabuleiro();
	}

	public boolean conectar() {
		throw new UnsupportedOperationException();
	}

	public boolean desconectar() {
		throw new UnsupportedOperationException();
	}

	public void encerraPartida() {
		this._jogador1.desabilitaJogador();
		this._jogador2.desabilitaJogador();
		this._partida_em_andamento = false;
		// monstrarFuckingVencedor();
	}

	public Jogador identificaVencedor() {
		if (_jogador1.getPontosDeVida() == 0) {
			_jogador2.setVencedor();
			return _jogador2;
		} else if (_jogador2.getPontosDeVida() == 0) {
			_jogador1.setVencedor();
			this.encerraPartida();
			return _jogador1;
		} else {
			return null;
		}
	}

	public Dado[] getDados() {
		return this._dados;
	}

	public boolean verificaPosicao(Posicao posicao) {
		for (int i = 0; i < 8; ++i) {
			for (int j = 0; j < 8; ++j) {
				if (posicoes[i][j].equals(posicao)) {
					return posicoes[i][j].casaVazia();
				}
			}
		}
		return false;
	}

	public Jogada invocaMonstro(Monstro aMonstro, Posicao posicao) {
		for (int i = 0; i < posicoes.length; i++) {
			for (int j = 0; j < posicoes.length; j++) {
				if ((posicoes[i][j].equals(posicao))) {
					posicoes[i][j].setOcupante(aMonstro);
					break;
				}
			}
		}
		return (new Jogada(posicao.getLinha(), posicao.getColuna(),
				TipoJogada._invocarMonstro, aMonstro, null, null));
	}

	public TipoJogada mudaJogador() {
		if (_jogador1.getSeuTurno()) {
			return _jogador1.darAVez();
		} else {
			return _jogador2.darAVez();
		}
	}

	public Jogada movimentaMonstro(Monstro aMonstro, Posicao posicao) {
		aMonstro.getPosicao().setOcupante(null);
		posicao.setOcupante(aMonstro);
		
		return (new Jogada(posicao.getLinha(), posicao.getColuna(), 
				TipoJogada._moverMonstro, aMonstro, null, null));
	}

	public boolean getConectado() {
		return this._conectado;
	}

	public void reproduzirJogada(Jogada aJogada, int aTipoJogada) {
		TipoJogada jogada = aJogada.getTipoJogada();
		switch (jogada) {
		case _rolar_dados:
			break;
		
		case _atacar:
			
			break;

		case _moverMonstro:
			break;
			
		case _usarHabilidade:
		}
	}

	public void iniciaizarTabuleiro() {
		this._dados = new Dado[3];
		for (int i = 0; i < 3; i++) {
			_dados[i] = new Dado();
		}

		this.posicoes = new Posicao[8][8];
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				posicoes[i][j] = new Posicao(null, i, i);
			}
		}
		this._partida_em_andamento = true;
		this._conectado = true;
	}

	public Jogador getJogador1() {
		return this._jogador1;
	}

	public Jogador getJogador2() {
		return this._jogador2;
	}

	public void usarHabilidade(Monstro_Com_Habilidade aMonstro) {
		throw new UnsupportedOperationException();
	}

	public void avaliaContinuidade() {
		if (_jogador1.getPontosDeVida() == 0
				|| _jogador2.getPontosDeVida() == 0) {
			this.identificaVencedor();
		}
	}
	
	public boolean partidaEmAndamento() {
		return this._partida_em_andamento;
	}
}