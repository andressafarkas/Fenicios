import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Grafo {
    private final HashMap<Nodo, ArrayList<Nodo>> listaAdjacencia;
    private final int numeroVertices;
    private int numeroArestas;

    public int getNumeroVertices() {
        return numeroVertices;
    }

    public Grafo(int numeroVertices) {
        this.numeroVertices = numeroVertices;
        this.numeroArestas = 0;
        this.listaAdjacencia = new HashMap<>();
    }

    public void adicionarAresta(Nodo v, Nodo w) {
        if (listaAdjacencia.containsKey(v)) {
            this.listaAdjacencia.get(v).add(w);
        } else {
            ArrayList<Nodo> novaLista = new ArrayList<>();
            novaLista.add(w);
            this.listaAdjacencia.put(v, novaLista);
        }
        this.numeroArestas++;
    }

    public int getNumeroArestas() {
        return numeroArestas;
    }

    public Nodo getNodo(int x, int y) {
        for (Nodo nodo : listaAdjacencia.keySet()) {
            if (nodo.x() == x && nodo.y() == y) {
                return nodo;
            }
        }
        return null;
    }

    public void adicionarNodo(Nodo nodo) {
        listaAdjacencia.putIfAbsent(nodo, new ArrayList<>());
    }

    public List<Nodo> getNodos() {
        return new LinkedList<>(listaAdjacencia.keySet());
    }

    public ArrayList<Nodo> verticesAdjacentes(Nodo nodo) {
        return listaAdjacencia.getOrDefault(nodo, new ArrayList<>());
    }

    public void adicionarNodoInt(int x, int y, boolean porto)
    {
        Nodo nodo = new Nodo(x, y, porto);
        listaAdjacencia.put(nodo, new ArrayList<>());
    }
}
