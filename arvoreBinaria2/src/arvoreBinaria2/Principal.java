package arvoreBinaria2;

public class Principal {

	public static void main(String[] args) {
		        Arvoreb arvore = new Arvoreb();

		        arvore.inserirNo(arvore.noRaiz, 10);
		        arvore.inserirNo(arvore.noRaiz, 5);
		        arvore.inserirNo(arvore.noRaiz, 15);
		        arvore.inserirNo(arvore.noRaiz, 3);
		        arvore.inserirNo(arvore.noRaiz, 7);
		        arvore.inserirNo(arvore.noRaiz, 12);
		        arvore.inserirNo(arvore.noRaiz, 18);

		        arvore.inserirNo(arvore.noRaiz, 15);

		        System.out.println("Árvore binária:");
		        exibir(arvore.noRaiz);

                System.out.println("Busca em ordem:");
                arvore.buscaEmOrdem(arvore.noRaiz);
                System.out.println();

               System.out.println("Busca pré-ordem:");
               arvore.buscaPreOrdem(arvore.noRaiz);
               System.out.println();

               System.out.println("Busca pós-ordem:");
               arvore.buscaPosOrdem(arvore.noRaiz);
              System.out.println();
		    }

		    public static void exibir(NoArvore no) {
		        if (no != null) {
		            exibir(no.getEsquerda());
		            System.out.print(no.getElemento() + " ");
		            exibir(no.getDireita());
		        }
		    }
