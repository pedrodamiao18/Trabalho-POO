import java.io.*;
import myinputs.Ler;
import java.util.ArrayList;

public class GerirProdutos {
    public static int menu(){ // função na classe do main
        int opcao;
        System.out.println("1 - Novo produto");
        System.out.println("2 - Listar produtos");
        System.out.println("3 - Apagar produto");
        System.out.println("4 - Alterar preço de um produto");
        System.out.println("5 - Listar produtos por categoria");
        System.out.println("6 – Adicionar stock");
        System.out.println("7 - Menu de Estatísticas");
        System.out.println("8 - Procurar fatura");
        System.out.println("9 - Sair");
        System.out.println("Qual a sua opção:");
        opcao = Ler.umInt();
        return opcao;

    }

    public static void main (String[] args){
        int escolha;
        // Lista que vai conter todos os livros;
        ArrayList<Produto> produtos = new ArrayList<>();
        ArrayList<Fatura> faturas = new ArrayList<>();
        // Ler ficheiro
        try {
            ObjectInputStream is = new ObjectInputStream( new FileInputStream("src/produtos.dat"));
            produtos = (ArrayList<Produto>) is.readObject();
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
        catch ( ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try{
            ObjectInputStream fr = new ObjectInputStream(new FileInputStream("src/faturas.dat"));
            faturas = (ArrayList<Fatura>) fr.readObject();
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
        catch ( ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        do{
            escolha = menu();
            switch (escolha){
                case 1:
                    FuncProdutos.adicionarProduto(produtos);
                    break;
                case 2:
                    System.out.println(produtos);
                    break;
                case 3:
                    FuncProdutos.apagarProduto(produtos);
                    break;
                case 4:
                    FuncProdutos.alterarPrecoProduto(produtos);
                    break;
                case 5:
                    FuncProdutos.listarProdutosCategoria(produtos);
                    break;
                case 6:
                    FuncProdutos.adicionarStock(produtos);
                    break;
                case 7:
                    Estatisticas.main(args);
                    break;
                case 8:
                    FuncProdutos.imprimeFaturasCliente(faturas);
            }
        } while(escolha != 9);
    }
}
