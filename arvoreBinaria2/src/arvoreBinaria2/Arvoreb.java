
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
	    public boolean arvoreEstritamenteBinaria(NoArvore no) {
        if (no == null)
            return true;

        if (no.getEsquerda() == null && no.getDireita() == null)
            return true;

        if (no.getEsquerda() != null && no.getDireita() != null)
            return arvoreEstritamenteBinaria(no.getEsquerda()) && arvoreEstritamenteBinaria(no.getDireita());

        return false;
    }

    public boolean arvoreBinariaCompleta(NoArvore no, int id, int qtdNos) {
        if (no == null)
            return true;

        if (id >= qtdNos)
            return false;

        return (arvoreBinariaCompleta(no.getEsquerda(), 2 * id + 1, qtdNos) && 
                arvoreBinariaCompleta(no.getDireita(), 2 * id + 2, qtdNos));
    }

    public int contarNos(NoArvore no) {
        if (no == null)
            return 0;

        return 1 + contarNos(no.getEsquerda()) + contarNos(no.getDireita());
    }

    public boolean arvoreBinariaCheia(NoArvore no, int id, int qtdNos) {
        if (no == null)
            return true;

        if (id >= qtdNos)
            return false;

        return (arvoreBinariaCheia(no.getEsquerda(), 2 * id + 1, qtdNos) && 
                arvoreBinariaCheia(no.getDireita(), 2 * id + 2, qtdNos));
    }

    public boolean verificarTipoArvore(NoArvore no) {
        int qtdNos = contarNos(no);
        if (arvoreEstritamenteBinaria(no)) {
            if (arvoreBinariaCompleta(no, 0, qtdNos))
                return true;
            else
                return false;
        } else {
            if (arvoreBinariaCheia(no, 0, qtdNos))
                return true;
            else
                return false;
        }
    }
}
    public int calcularAltura(NoArvore no) {
        if (no == null) {
            return -1; 
        } else {
            int alturaEsquerda = calcularAltura(no.getEsquerda());
            int alturaDireita = calcularAltura(no.getDireita());

            if (alturaEsquerda > alturaDireita) {
                return alturaEsquerda + 1;
            } else {
                return alturaDireita + 1;
            }
        }
    }
}
