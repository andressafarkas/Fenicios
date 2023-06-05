import java.util.*;

public class BuscaLargura {
    private Grafo grafo;
    private HashSet<Nodo> visitado;
    private HashMap<Nodo, Integer> distancias;

    public BuscaLargura(Grafo grafo) {
        this.grafo = grafo;
        this.visitado = new HashSet<>();
        this.distancias = new HashMap<>();
    }

    public void bfs(Nodo nodoInicial) {
        // Limpe os conjuntos visitados e as distâncias antes de cada BFS
        visitado.clear();
        distancias.clear();
        
        Queue<Nodo> fila = new LinkedList<>();
        visitado.add(nodoInicial);
        fila.add(nodoInicial);
        distancias.put(nodoInicial, 0);

        while (!fila.isEmpty()) {
            Nodo nodoAtual = fila.poll();

            ArrayList<Nodo> adjacentes = grafo.verticesAdjacentes(nodoAtual);
            for (Nodo nodoAdjacente : adjacentes) {
                if (!visitado.contains(nodoAdjacente)) {
                    visitado.add(nodoAdjacente);
                    fila.add(nodoAdjacente);
                    distancias.put(nodoAdjacente, distancias.get(nodoAtual) + 1);
                }
            }
        }
    }

    public int distancia(Nodo nodo) {
        return distancias.getOrDefault(nodo, 0);
    }
}
