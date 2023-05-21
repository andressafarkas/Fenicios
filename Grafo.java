import java.util.ArrayList;

public class Grafo{

    private ArrayList<Integer> listaAdjacencia[];

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
    public void adicionarAresta(int v, int w) {
        this.listaAdjacencia[v].add(w);
        this.numeroArestas++;
    }
    public ArrayList<Integer> verticesAdjacentes(int vertice) {
        return this.listaAdjacencia[vertice];
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
