import java.io.*;

public class main {
    private BuscaProfundidade busca;
    private static final char NAVEGAVEL = '.';
    private static Porto[] portos;
    private static int[] dx = {-1, 0, 1, 0}; // Norte, Leste, Sul, Oeste
    private static int[] dy = {0, 1, 0, -1}; // Norte, Leste, Sul, Oeste

    public static void main(String[] args) throws IOException {
        // Leitura do arquivo
        BufferedReader br = new BufferedReader(new FileReader("caminho_para_o_arquivo"));
        String[] dimensoes = br.readLine().split(" ");
        int linhas = Integer.parseInt(dimensoes[0]);
        int colunas = Integer.parseInt(dimensoes[1]);
        char[][] mapa = new char[linhas][colunas];
        portos = new Porto[10]; // Portos numerados de 1 a 9
        String linha;
        for (int i = 0; i < linhas; i++) {
            linha = br.readLine();
            for (int j = 0; j < colunas; j++) {
                mapa[i][j] = linha.charAt(j);
                if (Character.isDigit(mapa[i][j])) {
                    portos[Character.getNumericValue(mapa[i][j])] = new Porto(i, j);
                }
            }
        }
        br.close();
    };
};
