package modelo;

import java.io.Serializable;

public class Monstro implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4939644970032703130L;

	protected int _ataque;
	protected Posicao _posicao;
	protected boolean _ja_moveu;
	protected boolean _ja_atacou;
	protected int _custoInvocacao;
	protected int _custo_movimento;
	protected int _custo_ataque;
	protected Jogador _invocador;
	protected static int id_i= 0;
	protected int id;
	protected int monstro;

	public Monstro(int _ataque, Posicao _posicao, int _custoInvocacao,
			int _custo_movimento, int _custo_ataque, Jogador _invocador,
			int monstro) {
		this._ataque = _ataque;
		this._posicao = _posicao;
		this._custoInvocacao = _custoInvocacao;
		this._custo_movimento = _custo_movimento;
		this._custo_ataque = _custo_ataque;
		this._invocador = _invocador;
		this.id = id_i;
		this.monstro = monstro;
		++id_i;
	}

	public void reiniciaMonstro() {
		this.setJa_atacou(false);
		this.setJaMoveu(false);
	}
	
	public int getAtaque() {
		return this._ataque;
	}
	
	public Posicao getPosicao() {
		return this._posicao;
	}
	
	public boolean getJaMoveu() {
		return _ja_moveu;
	}
	
	public boolean getJa_atacou() {
		return this._ja_atacou;
	}
	
	public int estrelasParaInvocacao() {
		return this._custoInvocacao;
	}

	public int estrelasParaMovimento() {
		return this._custo_movimento;
	}

	public int estrelasParaAtaque() {
		return this._custo_ataque;
	}

	public Jogador getInvocador() {
		return this._invocador;
	}
	
	public int getId() {
		return this.id;
	}

	public int getTipoMonstro() {
		return this.monstro;
	}
	
	public void setPosicao(Posicao posicao) {
		this._posicao = posicao;
	}

	public void setJaMoveu(boolean aMoveu) {
		this._ja_moveu = aMoveu;
	}

	public void setJa_atacou(boolean aM_ja_atacou) {
		this._ja_atacou = aM_ja_atacou;
	}	

	public void setInvocador(Jogador jogador) {
		this._invocador = jogador;
	}
	
}