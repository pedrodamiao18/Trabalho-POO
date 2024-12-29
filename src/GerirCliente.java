import myinputs.Ler;
import java.io.*;
import java.util.ArrayList;

public class GerirCliente {

	public static int menuPrincipal() {
		int opcao;
		System.out.println("\nMenu Principal");
		System.out.println("1 - Ver produtos");
		System.out.println("2 - Criar lista");
		System.out.println("3 - Verificar total gasto");
		System.out.println("4 - Alterar dados");
		System.out.println("5 - Proceder para o pagamento");
		System.out.println("6 - Sair");
		System.out.print("Qual a sua opção: ");
		opcao = Ler.umInt();
		return opcao;
	}

	public static void main(String args[]) {
		int escolhaInicial, escolhaPrincipal;

		ArrayList<ProdQtd> lista = new ArrayList<>();
		ArrayList<Produto> produtos = FuncProdutos.lerProdutosDoArquivo();
		ArrayList<Fatura> faturas = FuncFatura.lerFaturasdoArquivo();
		ArrayList<Cliente> clientes = FuncCliente.lerClienteDoArquivo();

		Cliente clienteAtual = null;
		do {
			System.out.println("Bem-vindo ao sistema de gestão de clientes!");
			System.out.println("1 - Sou um novo cliente");
			System.out.println("2 - Já sou um cliente existente");
			System.out.print("Qual a sua opção: ");
			escolhaInicial = Ler.umInt();


			switch (escolhaInicial) {
				case 1:
					clienteAtual = FuncCliente.novoCliente(clientes);
					break;

				case 2:
					clienteAtual = FuncCliente.clienteExistente(clientes);
					break;

				default:
					System.out.println("Opção inválida. Encerrando o programa.");
					return;
			}
		} while (clienteAtual == null);

		// Menu principal para clientes já registados
		do {
			escolhaPrincipal = menuPrincipal();
			switch (escolhaPrincipal) {
				case 1: // Ver produtos
					System.out.println(produtos);
					break;
				case 2: // Criar lista
					FuncCliente.criarLista(lista, produtos);
					break;
				case 3: // Verificar total gasto
					System.out.println("Total gasto: " + clienteAtual.getGastoTotal());
					break;
				case 4: // Alterar dados
					FuncCliente.alterarDados(clientes);
					break;
				case 5: // Proceder para pagamento
					FuncFatura.criarFatura(faturas, lista, produtos, clienteAtual);
					break;
				case 6: // Sair
					System.out.println("Até breve!");
					break;
				default:
					System.out.println("Opção inválida. Tente novamente.");
			}
		} while (escolhaPrincipal != 6);
	}
}
