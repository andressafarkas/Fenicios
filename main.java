import java.io.*;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class main {
    public static void main(String[] args) throws IOException
    {
        Grafo grafo = ParseadorDeGrafo.parseToGraph("Mapas/mapa0.txt");
        BuscaLargura bfs = new BuscaLargura(grafo);

        // Encontre todos os portos
        List<Nodo> portos = grafo.getNodos().stream()
            .filter(Nodo::isPorto)
            .sorted(Comparator.comparingInt(Nodo::getPortoId))
            .toList();

        // Realize uma busca em largura para cada porto e calcule o combustível necessário
                // Realize uma busca em largura para cada porto e calcule o combustível necessário
                int combustivelNecessario = 0;
                Nodo ultimoNodo = portos.get(0);
        
                for (int i = 1; i < portos.size(); i++) {
                    Nodo portoAtual = portos.get(i);
        
                    // Verifique se o porto atual existe no grafo
                    if (grafo.getNodos().contains(portoAtual)) {
                        bfs.bfs(ultimoNodo);
        
                        // Supondo que cada movimento consome uma unidade de combustível,
                        // o combustível necessário é igual à distância entre os portos
                        combustivelNecessario += bfs.distancia(portoAtual);
                        ultimoNodo = portoAtual;
                    }
                }
        
                // Volte para o primeiro porto
                if (grafo.getNodos().contains(portos.get(0))) {
                    bfs.bfs(ultimoNodo);
                    combustivelNecessario += bfs.distancia(portos.get(0));
                }
        
                System.out.println("Combustível mínimo necessário: " + combustivelNecessario);
    }
};

