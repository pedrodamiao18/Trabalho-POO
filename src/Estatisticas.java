import myinputs.Ler;
import java.util.ArrayList;

public class Estatisticas {

    public static int menu() {
        int opcao;
        System.out.println("Menu de Estatísticas:");
        System.out.println("1 - Quantidade total de produtos");
        System.out.println("2 - Valor total em stock");
        System.out.println("3 - Produto mais caro");
        System.out.println("4 - Produto mais barato");
        System.out.println("5 - Produto mais vendido");
        System.out.println("6 - Produto menos vendido");
        System.out.println("7 - Dia de maior faturação");
        System.out.println("8 - Receita/Balanço do mês");
        System.out.println("9 - Cliente que gastou mais na loja");
        System.out.println("10 - Voltar ao menu principal");
        opcao = Ler.umInt();
        return opcao;
    }


    public static void main(String[] args) {
        int escolha;
        // Carregar as listas a partir dos arquivos
        ArrayList<Produto> produtos = FuncProdutos.lerProdutosDoArquivo(); // Você deve ter uma função para ler os produtos
        ArrayList<Cliente> clientes = FuncCliente.lerClienteDoArquivo(); // Função para ler os clientes
        ArrayList<Fatura> faturas = FuncFatura.lerFaturasdoArquivo(); // Função para ler as faturas


        do{
            escolha = menu();
            switch (escolha){
                case 1:
                    FuncEstatisticas.quantidadeTotal(produtos);
                    break;
                case 2:
                    FuncEstatisticas.valorTotal(produtos);
                    break;
                case 3:
                    FuncEstatisticas.produtoMaisCaro(produtos);
                    break;
                case 4:
                    FuncEstatisticas.produtoMaisBarato(produtos);
                    break;
                case 5:
                    FuncEstatisticas.produtoMaisVendido(produtos);
                    break;
                case 6:
                    FuncEstatisticas.produtoMenosVendido(produtos);
                    break;
                case 7:
                    FuncEstatisticas.diaMaiorFaturacao(faturas);
                    break;
                case 8:
                    FuncEstatisticas.receitaMes(faturas);
                    break;
                case 9:
                    FuncEstatisticas.clienteComMaiorGasto(clientes);
                    break;
                case 10: // Sair
                    System.out.println("Até breve!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while(escolha != 11);
    }
}
