import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;

public class ParseadorDeGrafo {
    public static final char NAVEGAVEL = '.';
    public static final char OBSTACULO = '*';
    public static int numLinhas;
    public static int numColunas;
    public static char[][] mapa;

    public static Grafo parseParaGrafo(String filename) {
        Grafo grafo = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String primeiraLinha = reader.readLine();
            numLinhas = Integer.parseInt(primeiraLinha.split(" ")[0]);
            numColunas = Integer.parseInt(primeiraLinha.split(" ")[1]);
            grafo = new Grafo(numLinhas * numColunas);
            mapa = new char[numLinhas][numColunas];
            List<String> linhas = reader.lines().toList();
            for (int i = 0; i < numLinhas; i++) {
                for (int j = 0; j < numColunas; j++) {
                    char c = linhas.get(i).charAt(j);
                    mapa[i][j] = c;
                    if (c == OBSTACULO) {
                        continue;
                    }
                    if (isPorto(c)) {
                        grafo.adicionarNodoInt(i, j, true, Character.getNumericValue(c));
                    }
                    else {
                        grafo.adicionarNodoInt(i, j, false);
                    }
                }
            }
            ligarNodos(grafo);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return grafo;
    }

    public static boolean isPorto(char c) {
        return Character.isDigit(c);
    }

    private static void ligarNodos(Grafo grafo) {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        for (Nodo nodo : grafo.getNodos()) {
            for (int i = 0; i < 4; i++) {
                int x = nodo.getX() + dx[i];
                int y = nodo.getY() + dy[i];
                if (x < 0 || x >= numLinhas || y < 0 || y >= numColunas) {
                    continue;
                }
                Nodo vizinho = grafo.getNodo(x, y);
                if (vizinho != null && mapa[x][y] != OBSTACULO) {
                    grafo.adicionarAresta(nodo, vizinho);
                }
            }
        }   
    }
}
