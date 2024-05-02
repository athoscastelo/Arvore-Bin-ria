
package arvoreBinaria2;

public class Arvoreb {

	public NoArvore noRaiz;

	public Arvoreb() {
		this.noRaiz = null;
	}

	public void inserirNo(NoArvore noArvore, int elemento) {
		if (noRaiz == null) {
			noRaiz = new NoArvore(elemento, null, null);
			System.out.println(elemento);
		}
		// esquerda

		else if (elemento < noArvore.getElemento()) {
			if (noArvore.getEsquerda() == null) {
				NoArvore novoNo = new NoArvore(elemento, null, null);
				noArvore.setEsquerda(novoNo);
				System.out.println(elemento);
			} else {
				inserirNo(noArvore.getEsquerda(), elemento);
																
			}
		}
		// direita
		else if (elemento > noArvore.getElemento()) {
			if (noArvore.getDireita() == null) {
				NoArvore novoNo = new NoArvore(elemento, null, null);
				noArvore.setDireita(novoNo);
				System.out.println(elemento);
			} else {
				inserirNo(noArvore.getDireita(), elemento); 
															
			}
		}

		else {
			System.out.println("Elemento já existe na árvore: " + elemento);

		}
	}

	public void buscaEmOrdem(NoArvore no) {
		if (no != null) {
			buscaEmOrdem(no.getEsquerda());
			System.out.print(no.getElemento() + " ");
			buscaEmOrdem(no.getDireita());
		}
	}

	public void buscaPreOrdem(NoArvore no) {
		if (no != null) {
			System.out.print(no.getElemento() + " ");
			buscaPreOrdem(no.getEsquerda());
			buscaPreOrdem(no.getDireita());
		}
	}

	public void buscaPosOrdem(NoArvore no) {
		if (no != null) {
			buscaPosOrdem(no.getEsquerda());
			buscaPosOrdem(no.getDireita());
			System.out.print(no.getElemento() + " ");
		}

	}

	public NoArvore buscaEspecifica(NoArvore no, int valor) {
		if (no.getElemento() == valor || no == null) {
			return no;
		}
		if (valor < no.getElemento()) {
			return buscaEspecifica(no.getEsquerda(), valor);
		} else {
			return buscaEspecifica(no.getDireita(), valor);
		}

	}

	public void deletarNo(int valor) {
		noRaiz = deletarRecursivo(noRaiz, valor);
	}

	private NoArvore deletarRecursivo(NoArvore no, int valor) {
		if (no == null) {
			return null;
		}

		if (valor < no.getElemento()) {
			no.setEsquerda(deletarRecursivo(no.getEsquerda(), valor));
		} else if (valor > no.getElemento()) {
			no.setDireita(deletarRecursivo(no.getDireita(), valor));
		} else {
			if (no.getEsquerda() == null) {
				return no.getDireita();
			} else if (no.getDireita() == null) {
				return no.getEsquerda();
			}

			no.setElemento(minValor(no.getDireita()));

			no.setDireita(deletarRecursivo(no.getDireita(), no.getElemento()));
		}
		return no;
	}

	private int minValor(NoArvore no) {
		int min = no.getElemento();
		while (no.getEsquerda() != null) {
			min = no.getEsquerda().getElemento();
			no = no.getEsquerda();
		}
		return min;
	}

}
