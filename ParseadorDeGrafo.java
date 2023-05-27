import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class ParseadorDeGrafo
{
    public static final char NAVEGAVEL = '.';
    public static final char OBSTACULO = '*';

    public static int numLinhas;

    public static int numColunas;

    public static char[][] mapa;

    public static Grafo parseToGraph(String filename)
    {
        Grafo grafo = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(filename)))
        {
            String primeiraLinha = reader.readLine();

            numLinhas = Integer.parseInt(primeiraLinha.split(" ")[0]);
            numColunas = Integer.parseInt(primeiraLinha.split(" ")[1]);
            grafo = new Grafo(numLinhas * numColunas);
            mapa = new char[numLinhas][numColunas];

            List<String> linhas = reader.lines().toList();

            for (int i = 1; i < numLinhas; i++)
            {
                for (int j = 1; j < numColunas; j++)
                {
                    char c = linhas.get(i).charAt(j);

                    mapa[i][j] = c;

                    if (c == OBSTACULO)
                    {
                        continue;
                    }

                    grafo.adicionarNodo(i, j, isPorto(c));
                }
            }

            ligarNodos(grafo);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

        return grafo;
    }

    public static boolean isPorto(char c)
    {
        return Character.isDigit(c);
    }

    private static void ligarNodos(Grafo grafo)
    {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        //A ideia é chamar esse aqui depois de popular o HashMap de nodos, aí junta tudo e depois é só buscar \o/

        for (Nodo nodo: grafo.getNodos())
        {
            for (int i = 0; i < 4; i++)
            {
                int x = nodo.x() + dx[i];
                int y = nodo.y() + dy[i];

                if (x < 0 || x >= numLinhas || y < 0 || y >= numColunas)
                {
                    continue;
                }

                Nodo vizinho = new Nodo(x, y, isPorto(mapa[x][y]));

                grafo.adicionarAresta(nodo, vizinho);
            }
        }
    }
}
