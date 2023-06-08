import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class main {
    private static int resposta;
    private static String mapa = "Mapas/mapa0.txt";
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        do {
            exibirMenu();
            resposta = input.nextInt();
            processarResposta();
        } 
        while (resposta >= 0 && resposta <= 5);
    }

    private static void exibirMenu() {
        System.out.println("Digite o número do mapa que deseja resolver: ");
        System.out.println("0 - Mapa 0");
        System.out.println("1 - Mapa 1");
        System.out.println("2 - Mapa 2");
        System.out.println("3 - Mapa 3");
        System.out.println("4 - Mapa 500_1000");
        System.out.println("5 - Outro nome de arquivo");
        System.out.println("Outras entradas - Sair");
    }

    private static void processarResposta() {
        switch (resposta) {
            case 0 -> mapa = "Mapas/mapa0.txt";
            case 1 -> mapa = "Mapas/mapa1.txt";
            case 2 -> mapa = "Mapas/mapa2.txt";
            case 3 -> mapa = "Mapas/mapa3.txt";
            case 4 -> mapa = "Mapas/mapa_500_1000.txt";
            case 5 -> {
                System.out.println("Digite o nome do arquivo: ");
                mapa = String.format("Mapas/%s.txt", input.next());
            }
            default -> {
                System.out.println("Saindo...");
                return;
            }
        }
        calcularCombustivelNecessario();
    }

    private static void calcularCombustivelNecessario() {
        Grafo grafo = ParseadorDeGrafo.parseParaGrafo(mapa);
        BuscaLargura bfs = new BuscaLargura(grafo);

        List<Nodo> portos = grafo.getNodos().stream()
                .filter(Nodo::isPorto)
                .sorted(Comparator.comparingInt(Nodo::getPortoId))
                .toList();

        int combustivelNecessario = 0;
        Nodo ultimoPorto = portos.get(0);

        for (int i = 1; i < portos.size(); i++)
        {
            Nodo portoAtual = portos.get(i);
            if (grafo.getAdjacentes(portoAtual).isEmpty())
            {
                continue;
            }
            bfs.bfs(ultimoPorto);
            int distancia = bfs.distancia(portoAtual);
            combustivelNecessario += distancia;
            if (distancia < 1)
            {
                System.out.println("Porto " + portoAtual.getPortoId() + " está obstruído");
                continue;
            }
            System.out.println("Distância entre porto " + ultimoPorto.getPortoId() + " e porto " + portoAtual.getPortoId() + ": " + distancia);
            ultimoPorto = portoAtual;
        }

        bfs.bfs(ultimoPorto);
        combustivelNecessario += bfs.distancia(portos.get(0));
        System.out.println("Combustível mínimo necessário: " + combustivelNecessario);
    }
}
