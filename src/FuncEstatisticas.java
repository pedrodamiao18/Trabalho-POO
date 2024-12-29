import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Map;
import java.util.HashMap;
import myinputs.Ler;

public class FuncEstatisticas {

    //quantidade de produtos em stock6
    public static void quantidadeTotal(ArrayList<Produto> produtos) {
        int total = 0;

        for (Produto produto : produtos) {
            total += produto.getStock();
        }
        System.out.println("Quantidade total de produtos no stock: " + total + " produtos");
    }

    // Valor total em stock
    public static void valorTotal(ArrayList<Produto> produtos) {
        double valorTotal = 0;

        for (Produto produto : produtos) {
            valorTotal += produto.getPreco() * produto.getStock();
        }
        System.out.println("Valor total em stock: " + valorTotal + "€");
    }

    // Produto mais caro
    public static void produtoMaisCaro(ArrayList<Produto> produtos) {
        if (produtos == null) {
            System.out.println("A lista de produtos está vazia.");
            return;
        }

        Produto maisCaro = produtos.get(0);

        for (Produto produto : produtos) {
            if (produto.getPreco() > maisCaro.getPreco()) {
                maisCaro = produto;
            }
        }
        System.out.println("Produto mais caro: " + maisCaro);
    }


    // Produto mais barato
    public static void produtoMaisBarato(ArrayList<Produto> produtos) {
        if (produtos == null) {
            System.out.println("A lista de produtos está vazia.");
            return;
        }

        Produto maisBarato = produtos.get(0);

        for (Produto produto : produtos) {
            if (produto.getPreco() < maisBarato.getPreco()) {
                maisBarato = produto;
            }
        }

        System.out.println("Produto mais barato: " + maisBarato);
    }


    // Produto mais vendido
    public static void produtoMaisVendido(ArrayList<Produto> produtos) {
        if (produtos == null) {
            System.out.println("A lista de produtos está vazia.");
            return;
        }
        Produto maisVendido = produtos.get(0);
        for (Produto produto : produtos) {
            if (produto.getQuantidadeVendida() > maisVendido.getQuantidadeVendida()) {
                maisVendido = produto;
            }
        }

        System.out.println("Produto mais vendido: " + maisVendido);
    }


    // Produto menos vendido
    public static void produtoMenosVendido(ArrayList<Produto> produtos) {
        if (produtos == null) {
            System.out.println("A lista de produtos está vazia.");
            return;
        }
        Produto menosVendido = produtos.get(0);
        for (Produto produto : produtos) {
            if (produto.getQuantidadeVendida() < menosVendido.getQuantidadeVendida()) {
                menosVendido = produto;
            }
        }

        System.out.println("Produto menos vendido: " + menosVendido );
    }


    // Função para determinar o dia de maior faturação
    public static void diaMaiorFaturacao(ArrayList<Fatura> faturas) {
        if (faturas == null) {
            System.out.println("Não há faturas registradas.");
            return;
        }

        // Mapa para armazenar o total de faturação por dia
        Map<LocalDate, Double> faturacaoPorDia = new HashMap<>();

        for (Fatura fatura : faturas) {
            LocalDate data = fatura.getData();
            double totalFatura = fatura.getTotal();
            // Atualizar o total de faturação para o dia específico
            faturacaoPorDia.put(data, faturacaoPorDia.getOrDefault(data, 0.0) + totalFatura);
        }

        // Encontrar o dia de maior faturação
        LocalDate diaMaiorFaturacao = null;
        double maiorFaturacao = 0;

        for (Map.Entry<LocalDate, Double> entry : faturacaoPorDia.entrySet()) {
            if (entry.getValue() > maiorFaturacao) {
                maiorFaturacao = entry.getValue();
                diaMaiorFaturacao = entry.getKey();
            }
        }

        // Exibir o resultado
        System.out.println("O dia de maior faturação foi " + diaMaiorFaturacao + " com um total de " + maiorFaturacao);
    }


    // Receita do mês
    public static void receitaMes(ArrayList<Fatura> faturas) {

        System.out.println("Insira o mês:");
        int mes = Ler.umInt();

        System.out.println("Insira o ano:");
        int ano = Ler.umInt();

        double receitaTotal = 0;

        for (Fatura fatura : faturas) {
            LocalDate dataFatura = fatura.getData();

            if (dataFatura.getMonthValue() == mes && dataFatura.getYear() == ano) {
                receitaTotal += fatura.getTotal();  // Soma o valor da fatura
            }
        }

        System.out.println("A receita total do mês " + mes + "/" + ano + " é: " + receitaTotal);
    }

    //cliente com maior gasto
    public static void clienteComMaiorGasto(ArrayList<Cliente> clientes) {
        Cliente clienteMaiorGasto = null;
        double maiorGasto = 0;

        for (Cliente c : clientes) {
            double gastoAtual = c.getGastoTotal();
            if (gastoAtual > maiorGasto) {
                maiorGasto = gastoAtual;
                clienteMaiorGasto = c;
            }
        }

        if (clienteMaiorGasto != null) {
            System.out.println("O cliente com maior gasto é: " + clienteMaiorGasto.getNome());
            System.out.println("Total gasto: " + maiorGasto);
        } else {
            System.out.println("Não há clientes registrados.");
        }
    }
}
