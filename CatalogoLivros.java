import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class CatalogoLivros {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Menu interativo
        while (true) {
            System.out.println("\nBem-vindo ao Catálogo de Livros!");
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Buscar livros por título");
            System.out.println("2 - Buscar livros por autor");
            System.out.println("3 - Ver lista de livros populares");
            System.out.println("4 - Detalhes de um livro");
            System.out.println("5 - Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine();  // Limpar o buffer do scanner

            switch (opcao) {
                case 1:
                    System.out.println("Digite o título do livro:");
                    String titulo = scanner.nextLine();
                    buscarLivrosPorTitulo(titulo);
                    break;
                case 2:
                    System.out.println("Digite o nome do autor:");
                    String autor = scanner.nextLine();
                    buscarLivrosPorAutor(autor);
                    break;
                case 3:
                    System.out.println("Exibindo livros populares...");
                    // Aqui você pode implementar a busca por livros populares, se necessário
                    break;
                case 4:
                    System.out.println("Digite o ID do livro:");
                    String idLivro = scanner.nextLine();
                    detalhesLivro(idLivro);
                    break;
                case 5:
                    System.out.println("Saindo...");
                    return;  // Encerra o programa
                default:
                    System.out.println("Opção inválida, tente novamente.");
            }
        }
    }

    // Função para buscar livros por título
    private static void buscarLivrosPorTitulo(String titulo) {
        try {
            String jsonResposta = fazerRequisicaoAPI("https://gutendex.com/books?search=" + titulo);
            Gson gson = new Gson();
            JsonObject json = gson.fromJson(jsonResposta, JsonObject.class);

            // Exibindo resultados
            JsonArray livros = json.getAsJsonArray("results");
            if (livros.size() == 0) {
                System.out.println("Nenhum livro encontrado.");
            } else {
                for (int i = 0; i < livros.size(); i++) {
                    JsonObject livro = livros.get(i).getAsJsonObject();
                    String nomeLivro = livro.get("title").getAsString();
                    String autor = livro.get("authors").getAsJsonArray().get(0).getAsJsonObject().get("name").getAsString();
                    System.out.println("Livro: " + nomeLivro + " - Autor: " + autor);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Função para buscar livros por autor
    private static void buscarLivrosPorAutor(String autor) {
        try {
            String jsonResposta = fazerRequisicaoAPI("https://gutendex.com/books?search=" + autor);
            Gson gson = new Gson();
            JsonObject json = gson.fromJson(jsonResposta, JsonObject.class);

            // Exibindo resultados
            JsonArray livros = json.getAsJsonArray("results");
            if (livros.size() == 0) {
                System.out.println("Nenhum livro encontrado para o autor.");
            } else {
                for (int i = 0; i < livros.size(); i++) {
                    JsonObject livro = livros.get(i).getAsJsonObject();
                    String nomeLivro = livro.get("title").getAsString();
                    System.out.println("Livro: " + nomeLivro);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Função para obter detalhes de um livro específico
    private static void detalhesLivro(String idLivro) {
        try {
            String jsonResposta = fazerRequisicaoAPI("https://gutendex.com/books/" + idLivro);
            Gson gson = new Gson();
            JsonObject json = gson.fromJson(jsonResposta, JsonObject.class);

            String titulo = json.get("title").getAsString();
            String descricao = json.get("description").getAsString();
            System.out.println("Título: " + titulo);
            System.out.println("Descrição: " + descricao);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Função para fazer a requisição à API
    private static String fazerRequisicaoAPI(String urlString) throws Exception {
        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        return response.toString();
    }
}
