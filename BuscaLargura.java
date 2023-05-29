import java.util.*;

public class BuscaLargura {
    private Grafo grafo;
    private HashSet<Nodo> visitado;

    public BuscaLargura(Grafo grafo) {
        this.grafo = grafo;
        this.visitado = new HashSet<>();
    }

    public void bfs(Nodo nodoInicial) {
        Queue<Nodo> fila = new LinkedList<>();
        visitado.add(nodoInicial);
        fila.add(nodoInicial);

        while (!fila.isEmpty()) {
            Nodo nodoAtual = fila.poll(); 
            System.out.println("Visitando o nodo: " + nodoAtual);

            ArrayList<Nodo> adjacentes = grafo.verticesAdjacentes(nodoAtual);

            for (Nodo nodoAdjacente : adjacentes) {
                if (!visitado.contains(nodoAdjacente)) {
                    visitado.add(nodoAdjacente);
                    fila.add(nodoAdjacente);
                }
            }
        }
    }
}
