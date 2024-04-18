package arvoreBinaria2;

public class NoArvore {

	private int elemento;
	private NoArvore direita;
	private NoArvore esquerda;
	
	public NoArvore() {
		
	}

	public NoArvore(int elemento, NoArvore direita, NoArvore esquerda) {
		super();
		this.elemento = elemento;
		this.direita = null;
		this.esquerda = null;
	}

	
	public int getElemento() {
		return elemento;
	}

	public void setElemento(int elemento) {
		this.elemento = elemento;
	}

	public NoArvore getDireita() {
		return direita;
	}

	public void setDireita(NoArvore direita) {
		this.direita = direita;
	}

	public NoArvore getEsquerda() {
		return esquerda;
	}

	public void setEsquerda(NoArvore esquerda) {
		this.esquerda = esquerda;
	}
}
