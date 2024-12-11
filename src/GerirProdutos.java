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
        System.out.println("5 - ");
        System.out.println("6 – ");
        System.out.println("7 - Sair");
        System.out.println("Qual a sua opção:");
        opcao = Ler.umInt();
        return opcao;

    }

    public static void main (String[] args){
        int escolha;
        // Lista que vai conter todos os livros;
        ArrayList<Produto> produtos = new ArrayList<>();
        // Ler ficheiro
        try {
            ObjectInputStream is = new ObjectInputStream( new FileInputStream("produtos.dat"));
            produtos = (ArrayList<Produto>) is.readObject();
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
        catch ( ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        do{
            escolha = menu();
            switch (escolha){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
            }
        } while(escolha != 7);
    }
}
