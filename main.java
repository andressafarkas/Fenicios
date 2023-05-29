import java.io.*;

public class main {
    private BuscaLargura busca;
    private static final char NAVEGAVEL = '.';
    private static Porto[] portos;

    public static void main(String[] args) throws IOException
    {

        Grafo grafo = ParseadorDeGrafo.parseToGraph("Mapas/mapa0.txt");
        LerArquivo ler = new LerArquivo();
    };
};
