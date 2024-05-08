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

        System.out.println("arvore binária:");
        exibir(arvore.noRaiz);
        System.out.println();

        System.out.println("busca em ordem:");
        arvore.buscaEmOrdem(arvore.noRaiz);
        System.out.println();

        System.out.println("busca pré-ordem:");
        arvore.buscaPreOrdem(arvore.noRaiz);
        System.out.println();

        System.out.println("busca pós-ordem:");
        arvore.buscaPosOrdem(arvore.noRaiz);
        System.out.println();

        int valorBusca = 12;
        System.out.println("busca específica por " + valorBusca + ":");
        NoArvore resultadoBusca = arvore.buscaEspecifica(arvore.noRaiz, valorBusca);
        if (resultadoBusca != null) {
            System.out.println("Valor encontrado na árvore.");
        }
        
        int valorExclusao = 12;
        System.out.println("exclusão do valor " + valorExclusao + ":");
        arvore.deletarNo(valorExclusao);
        System.out.println("arvore após a exclusão:");
        exibir(arvore.noRaiz);

        boolean tipoArvore = arvore.verificarTipoArvore(arvore.noRaiz);
        if (tipoArvore) {
            System.out.println("A árvore é do tipo especificado.");
        } else {
            System.out.println("A árvore não é do tipo especificado.");
        }

        int alturaArvore = arvore.calcularAltura(arvore.noRaiz);
        System.out.println("Altura da árvore: " + alturaArvore);
    } 

    public static void exibir(NoArvore no) {
        if (no != null) {
            exibir(no.getEsquerda());
            System.out.print(no.getElemento() + " ");
            exibir(no.getDireita());
        }
    }
}

