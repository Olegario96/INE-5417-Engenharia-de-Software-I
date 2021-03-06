package modelo;

import java.io.Serializable;
import java.util.ArrayList;

public class Jogador implements Serializable {

	private static final long serialVersionUID = -6464342001908889999L;

	private String _nome;
	private int id;
	private boolean _seu_turno;
	private boolean _vencedor;
	private ArrayList<Monstro> _monstros;
	private boolean _ja_rolou_dados;
	private int _numEstrelas;
	private int _monstrosDestruidos;
	private int pontos_de_vida;

	public Jogador(String _nome, int id) {
		this._nome = _nome;
		this.pontos_de_vida = 3;
		this._monstrosDestruidos = 0;
		this._numEstrelas = 0;
		this._monstros = new ArrayList<Monstro>();
		this.id = id;
		this._seu_turno = false;
		this._ja_rolou_dados = false;
		this._vencedor = false;
	}

	public TipoJogada darAVez() {
		this.resetarMonstros();
		this.setDados(false);
		this.desabilitaJogador();
		return TipoJogada.DAR_VEZ;
	}

	public void resetarMonstros() {
		for (Monstro m : _monstros) {
			m.reiniciaMonstro();
		}
	}

	public void adicionaMonstro(Monstro aEscolha) {
		this._monstros.add(aEscolha);
	}

	public void desabilitaJogador() {
		this._seu_turno = false;
	}

	public void adicionaEstrelas(int estrelas) {
		this._numEstrelas += estrelas;
	}

	public void diminuiEstrelas(int aEstrelas) {
		this._numEstrelas = this._numEstrelas - aEstrelas;
	}

	public void adicionarMonstroDestruido(Monstro monstro) {
		this._monstros.remove(monstro);
		_monstrosDestruidos++;
		this.avaliaPontosDeVida();
	}

	public void avaliaPontosDeVida() {
		if (this._monstrosDestruidos % 3 == 0) {
			--pontos_de_vida;
		}
	}

	public boolean compara(Jogador jogador) {
		return this.getId() == jogador.getId();
	}

	public boolean possuiMonstro() {
		return (_monstros.size() > 0);
	}

	public boolean possui_monstro_com_habilidade() {
		for (Monstro monstro : _monstros) {
			if (monstro instanceof Monstro_Com_Habilidade) {
				return true;
			}
		}
		return false;
	}

	public String getNome() {
		return this._nome;
	}

	public int getId() {
		return this.id;
	}

	public boolean getSeuTurno() {
		return this._seu_turno;
	}
	
	public boolean getVencedor() {
		return this._vencedor;
	}

	public boolean getJaRolou() {
		return this._ja_rolou_dados;
	}

	public int getEstrelas() {
		return this._numEstrelas;
	}

	public int getPontosDeVida() {
		return this.pontos_de_vida;
	}

	public void setName(String nome) {
		this._nome = nome;
	}

	public void setSeu_turno(boolean aM_seu_turno) {
		this._seu_turno = aM_seu_turno;
	}
	
	public void setVencedor() {
		this._vencedor = true;
	}
	
	public void setDados(boolean dados) {
		this._ja_rolou_dados = dados;
	}
}