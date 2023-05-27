import java.util.*;

public class Grafo{

    private final HashMap<Nodo, ArrayList<Nodo>> listaAdjacencia;
    private final int numeroVertices;
    private int numeroArestas;


    public int getNumeroVertices()
    {
        return numeroVertices;
    }


    public Grafo(int numeroVertices) {
        this.numeroVertices = numeroVertices;
        this.numeroArestas = 0;
        listaAdjacencia = new HashMap<>(numeroVertices);
    }

    public void adicionarAresta(Nodo v, Nodo w) {
        this.listaAdjacencia.get(v).add(w);
        this.numeroArestas++;
    }

    public int getNumeroArestas()
    {
        return numeroArestas;
    }

    public void adicionarNodo(int x, int y, boolean porto)
    {
        Nodo nodo = new Nodo(x, y, porto);
        listaAdjacencia.put(nodo, new ArrayList<>());
    }

    /*
    public String toDot() {
        String resultado = "digraph G { " + System.lineSeparator();
        for (int i = 0; i < numeroVertices; i++) {
            resultado = resultado + "\t" + i + ";" + System.lineSeparator();
        }
        for (int i = 0; i < numeroVertices; i++) {
            for (int j = 0; j < listaAdjacencia.keySet().size(); j++) {
                resultado += "\t" + i + "->" + listaAdjacencia[i].get(j) + ";" + System.lineSeparator();
            }
        }
        resultado += "}";
        return resultado;
    }
    */

    public List<Nodo> getNodos()
    {
        return new LinkedList<>(listaAdjacencia.keySet());
    }

    public ArrayList<Nodo> verticesAdjacentes(int x, int y)
    {
        return listaAdjacencia.get(new Nodo(x, y, false));
    }
}
