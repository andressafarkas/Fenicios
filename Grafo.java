import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Grafo{

    private final ArrayList<Nodo>[] listaAdjacencia;

    private HashMap<Nodo, Integer> nodos;

    public int getNumeroVertices() {
        return numeroVertices;
    }

    private int numeroVertices;
    private int numeroArestas;

    public Grafo(int numeroVertices) {
        this.numeroVertices = numeroVertices;
        this.numeroArestas = 0;
        listaAdjacencia = new ArrayList[numeroVertices];
        for (int i = 0; i < numeroVertices; i++) {
            listaAdjacencia[i] = new ArrayList<>();
        }
    }

    private class Nodo
    {
        public int x;
        public int y;

        public boolean porto;

        public Nodo(int x, int y, boolean porto)
        {
            this.x = x;
            this.y = y;
            this.porto = porto;
        }
    }
    public void adicionarAresta(Nodo v, Nodo w) {
        this.listaAdjacencia[nodos.get(v)].add(w);
        this.numeroArestas++;
    }

    public void adicionarNodo(int x, int y, boolean porto)
    {
        Nodo nodo = new Nodo(x, y, porto);
        nodos.put(nodo, nodos.size());
    }
    
    public String toDot() {
        String resultado = "digraph G { " + System.lineSeparator();
        for (int i = 0; i < numeroVertices; i++) {
            resultado = resultado + "\t" + i + ";" + System.lineSeparator();
        }
        for (int i = 0; i < numeroVertices; i++) {
            for (int j = 0; j < listaAdjacencia[i].size(); j++) {
                resultado += "\t" + i + "->" + listaAdjacencia[i].get(j) + ";" + System.lineSeparator();
            }
        }
        resultado += "}";
        return resultado;
    }
}
