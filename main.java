import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

public class main {
    public static void main(String[] args) throws IOException
    {
        Grafo grafo = ParseadorDeGrafo.parseToGraph("Mapas/mapa0.txt");
        BuscaLargura bfs = new BuscaLargura(grafo);

        // Encontre todos os portos
        List<Nodo> portos = grafo.getNodos().stream()
            .filter(Nodo::porto)
            .collect(Collectors.toList());

        // Realize uma busca em largura para cada porto e calcule o combustível necessário
        int combustivelNecessario = 0;
        Nodo ultimoPorto = portos.get(0);

        for (int i = 1; i < portos.size(); i++) {
            Nodo portoAtual = portos.get(i);
            bfs.bfs(ultimoPorto);

            // Supondo que cada movimento consome uma unidade de combustível,
            // o combustível necessário é igual à distância entre os portos
            combustivelNecessario += bfs.distancia(portoAtual);
            ultimoPorto = portoAtual;
        }

        // Volte para o primeiro porto
        bfs.bfs(ultimoPorto);
        combustivelNecessario += bfs.distancia(portos.get(0));

        System.out.println("Combustível necessário: " + combustivelNecessario);
    }
};

