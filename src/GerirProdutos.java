import java.io.*;
import myinputs.Ler;
import java.util.ArrayList;

public class GerirProdutos {
    public static int menu() { // Função para o menu de gestão de produtos
        int opcao;
        System.out.println("\nMenu para Gestão de Produtos");
        System.out.println("1 - Novo produto");
        System.out.println("2 - Listar produtos");
        System.out.println("3 - Apagar produto");
        System.out.println("4 - Alterar preço de um produto");
        System.out.println("5 - Listar produtos por categoria");
        System.out.println("6 – Adicionar stock");
        System.out.println("7 - Procurar fatura");
        System.out.println("8 - Voltar ao menu anterior");
        System.out.println("9 - Sair");
        System.out.print("Qual a sua opção: ");
        opcao = Ler.umInt();
        return opcao;
    }

    public static void main(String[] args) {
        int escolha;
        // Lista que vai conter todos os produtos e faturas
        ArrayList<Produto> produtos = FuncProdutos.lerProdutosDoArquivo();
        ArrayList<Fatura> faturas = FuncFatura.lerFaturasdoArquivo();

        // Loop para o menu de gestão de produtos
        do {
            escolha = menu();
            switch (escolha) {
                case 1:// função usada para adicionar um produto à loja
                    FuncProdutos.adicionarProduto(produtos);
                    break;
                case 2://imprime todos os produtos existentes
                    System.out.println(produtos);
                    break;
                case 3://permite apagar um produto pelo seu código
                    FuncProdutos.apagarProduto(produtos);
                    break;
                case 4://alterar o preço de um produto
                    FuncProdutos.alterarPrecoProduto(produtos);
                    break;
                case 5://lista os produtos tendo em conta a categoria escolhida
                    FuncProdutos.listarProdutosCategoria(produtos);
                    break;
                case 6://função usada para adicionar stock na loja
                    FuncProdutos.adicionarStock(produtos);
                    break;
                case 7://permite mostrar as faturas de um determinado cliente
                    FuncProdutos.imprimeFaturasCliente(faturas);
                    break;
                case 8://volta ao menu anterior
                    return;
                case 9: // Sair
                    System.out.println("Encerrando o programa. Até breve!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (escolha != 9);
    }
}
