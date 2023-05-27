import java.util.*;

public class BuscaLargura {
    private Grafo grafo;
    private boolean[] visitado;

    public BuscaLargura(Grafo grafo) {
        this.grafo = grafo;
        this.visitado = new boolean[grafo.getNumeroVertices()];
    }

    /*
    public void BuscaEmLargura(Grafo g, int vertice) {
        Queue<Integer> fila = new LinkedList<>();
        visitado[vertice] = true;
        fila.add(vertice);

        while (!fila.isEmpty()) {
            int v = fila.poll();
            visitado[v] = true;

            ArrayList<Integer> adjacentes = grafo.verticesAdjacentes(v);

            for (int w : adjacentes) {
                if (!visitado[w]) {
                    visitado[w] = true;
                    fila.add(w);
                }
            }
        }
    }

     */
}
