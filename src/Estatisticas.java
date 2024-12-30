import myinputs.Ler;
import java.util.ArrayList;

public class Estatisticas {

    public static int menu() {
        int opcao;
        System.out.println("\nMenu de Estatísticas:");
        System.out.println("1 - Quantidade total de produtos");
        System.out.println("2 - Valor total em stock");
        System.out.println("3 - Produto mais caro");
        System.out.println("4 - Produto mais barato");
        System.out.println("5 - Produto mais vendido");
        System.out.println("6 - Produto menos vendido");
        System.out.println("7 - Dia de maior faturação");
        System.out.println("8 - Receita/Balanço do mês");
        System.out.println("9 - Cliente que gastou mais na loja");
        System.out.println("10 - Voltar ao menu anterior");
        System.out.println("11 - Sair");
        System.out.print("Qual a sua opção: ");
        opcao = Ler.umInt();
        return opcao;
    }

    public static void main(String[] args) {
        int escolha;

        // Carregar as listas a partir dos arquivos
        ArrayList<Produto> produtos = FuncProdutos.lerProdutosDoArquivo();
        ArrayList<Cliente> clientes = FuncCliente.lerClienteDoArquivo();
        ArrayList<Fatura> faturas = FuncFatura.lerFaturasdoArquivo();

        while (true) {
            escolha = menu();
            switch (escolha) {
                case 1://mostra a quantidade total de produtos
                    FuncEstatisticas.quantidadeTotal(produtos);
                    break;
                case 2://mostra o total de produtos existentes na loja
                    FuncEstatisticas.valorTotal(produtos);
                    break;
                case 3://apresenta o produto mais caro da loja
                    FuncEstatisticas.produtoMaisCaro(produtos);
                    break;
                case 4://apresenta o produto mais barato
                    FuncEstatisticas.produtoMaisBarato(produtos);
                    break;
                case 5://apresenta o produto mais vendido da loja
                    FuncEstatisticas.produtoMaisVendido(produtos);
                    break;
                case 6:// apresenta o produto menos vendido
                    FuncEstatisticas.produtoMenosVendido(produtos);
                    break;
                case 7://apresenta o dia de maior faturação na loja
                    FuncEstatisticas.diaMaiorFaturacao(faturas);
                    break;
                case 8://lê  mês do teclado e indica a sua receita
                    FuncEstatisticas.receitaMes(faturas);
                    break;
                case 9://apresenta o cliente com maior gasto na loja
                    FuncEstatisticas.clienteComMaiorGasto(clientes);
                    break;
                case 10://voltar ao menu anterior
                    return;
                case 11: // Sai e encerra o programa
                    System.out.println("Encerrando o programa. Até breve!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
