public class ManipuladorDaFila {
    Fila criar() {
        Fila f = new Fila();
        f.inicio = null;
        f.fim = null;
        return f;
    }

    public No insereNoFim(No fim, Palavra valor) {
        No novoNo = new No(valor);
        novoNo.setProximo(null);

        if (fim != null) {
            fim.setProximo(novoNo);
        }
        return novoNo; // Return new node so caller can update `fim`
    }

    public void adicionarPalavra(Fila fila, Palavra valor) {
        fila.fim = insereNoFim(fila.fim, valor);
        if (fila.inicio == null) {
            fila.inicio = fila.fim;
        }
    }

    public Palavra retirarPalavra(Fila fila) {
        if (fila.inicio == null) {
            System.out.println("fila vazia");
            System.exit(1);
        }
        Palavra palavraRetirada = fila.inicio.getValor();
        fila.inicio = fila.inicio.getProximo();
        if (fila.inicio == null) {
            fila.fim = null;
        }

        return palavraRetirada;
    }

    public void display(Fila fila) {
        if (fila.inicio == null) {
            System.out.println("fila vazia.");
            return;
        }

        System.out.println();
        No elementoAtual = fila.inicio;
        while (elementoAtual != null) {
            System.out.println(elementoAtual.getValor().getPalavra() + " "
                    + elementoAtual.getValor().getLinhas().toString().replace("[", "").replace("]", ""));
            elementoAtual = elementoAtual.getProximo();
        }
        System.out.println("\n");
    }
}
