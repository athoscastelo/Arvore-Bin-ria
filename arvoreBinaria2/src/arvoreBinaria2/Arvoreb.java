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
			//esquerda
		} else if (elemento < noArvore.getElemento()) {
			if (noArvore.getEsquerda() == null) {
				NoArvore novoNo = new NoArvore(elemento, null, null);
				noArvore.setEsquerda(novoNo);
				System.out.println(elemento);

			} else {
				noArvore = noArvore.getEsquerda();
				inserirNo(noArvore.getEsquerda(), elemento);
			}
			//direita
		} else if (elemento > noArvore.getElemento()) {
			if (noArvore.getDireita() == null) {
				NoArvore novoNo = new NoArvore(elemento, null, null);
				noArvore.setDireita(novoNo);
				System.out.println(elemento);

			} else {
				noArvore = noArvore.getDireita();
				inserirNo(noArvore.getDireita(), elemento);
			}
		}
		else {
	        System.out.println("Elemento já existe na árvore: " + elemento);

		}
	}

}
