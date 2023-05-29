import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LerArquivo {
    
    public Grafo lerArquivo(String nomeArquivo) throws FileNotFoundException {
        File arquivo = new File(nomeArquivo);
        Scanner scanner = new Scanner(arquivo);
    
        int numeroVertices = scanner.nextInt();
        Grafo grafo = new Grafo(numeroVertices);
        
        while (scanner.hasNextLine()) {
            String linha = scanner.nextLine();
            String[] partes = linha.split(" ");
            int x = Integer.parseInt(partes[0]);
            int y = Integer.parseInt(partes[1]);
            boolean isPorto = Boolean.parseBoolean(partes[2]);
            Nodo nodo = new Nodo(x, y, isPorto);
            grafo.adicionarNodo(nodo);
    
            if (partes.length > 3) {
                for (int i = 3; i < partes.length; i+=3) {
                    int x2 = Integer.parseInt(partes[i]);
                    int y2 = Integer.parseInt(partes[i+1]);
                    boolean isPorto2 = Boolean.parseBoolean(partes[i+2]);
                    Nodo nodo2 = new Nodo(x2, y2, isPorto2);
    
                    grafo.adicionarAresta(nodo, nodo2);
                }
            }
        }
        
        scanner.close();
        return grafo;
    } 
}
