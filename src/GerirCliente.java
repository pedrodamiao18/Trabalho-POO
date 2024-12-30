import myinputs.Ler;
import java.io.*;
import java.util.ArrayList;

public class GerirCliente {

	public static int menuPrincipal() {
		int opcao;
		System.out.println("\nMenu Principal");
		System.out.println("1 - Ver produtos");
		System.out.println("2 - Adicionar produtos à lista");
		System.out.println("3 - Verificar total gasto");
		System.out.println("4 - Alterar dados");
		System.out.println("5 - Proceder para o pagamento");
		System.out.println("6 - Voltar ao menu anterior");
		System.out.println("7 - Sair");
		System.out.print("Qual a sua opção: ");
		opcao = Ler.umInt();
		return opcao;
	}

	public static void main(String[] args) {
		int escolhaInicial;

		ArrayList<ProdQtd> lista = new ArrayList<>();
		ArrayList<Produto> produtos = FuncProdutos.lerProdutosDoArquivo();
		ArrayList<Fatura> faturas = FuncFatura.lerFaturasdoArquivo();
		ArrayList<Cliente> clientes = FuncCliente.lerClienteDoArquivo();

		Cliente clienteAtual = null;

		while (true) {
			System.out.println("\nBem-vindo ao sistema de gestão de clientes!");
			System.out.println("1 - Sou um novo cliente");
			System.out.println("2 - Já sou um cliente existente");
			System.out.println("3 - Voltar ao menu inicial");
			System.out.print("Qual a sua opção: ");
			escolhaInicial = Ler.umInt();

			switch (escolhaInicial) {
				case 1://inicia o menu para novos clientes
					clienteAtual = FuncCliente.novoCliente(clientes);
					break;

				case 2://inicia o menu para clientes existentes
					clienteAtual = FuncCliente.clienteExistente(clientes);
					break;

				case 3:
					return; // Volta ao menu inicial do programa
				default:
					System.out.println("Opção inválida. Tente novamente.");
			}

			// Se o cliente foi selecionado corretamente, sai do loop e vai para o menu principal
			if (clienteAtual != null) {
				break;
			}
		}

		// Menu principal para clientes registados
		while (true) {
			int escolhaPrincipal = menuPrincipal();
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

				case 6: // Voltar ao menu anterior
					clienteAtual = null; // Redefine o cliente para voltar ao menu inicial de seleção
					break;

				case 7: // Sair
					System.out.println("Encerrando o programa. Até breve!");
					System.exit(0);
					return;

				default:
					System.out.println("Opção inválida. Tente novamente.");
			}

			if (clienteAtual == null) {
				main(args); // Chama o menu inicial de cliente novamente
				return;
			}
		}
	}
}
