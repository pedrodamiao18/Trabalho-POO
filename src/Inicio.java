import myinputs.Ler;

public class Inicio {

	public static int menu() {
		int opcao;
		System.out.println("1 - Cliente");
		System.out.println("2 - Funcionario");
		System.out.println("3 - Sair");
		System.out.print("Qual a sua opção: ");
		opcao = Ler.umInt();
		return opcao;
	}

	public static int menuFuncionario() {
		int opcao;
		System.out.println("\nÁrea do Funcionário");
		System.out.println("1 - Gerir Produtos");
		System.out.println("2 - Estatísticas");
		System.out.println("3 - Voltar ao menu inicial");
		System.out.print("Qual a sua opção: ");
		opcao = Ler.umInt();
		return opcao;
	}

	public static void main(String[] args) {
		boolean continuar = true;

		while (continuar) {
			System.out.println("\nBem vindo à nossa loja!");
			System.out.println("Selecione o seu perfil:");
			int escolha = menu();

			switch (escolha) {
				case 1: // Cliente
					GerirCliente.main(args); // Chama o menu de cliente
					break;

				case 2: // Funcionario
					int escolhaFuncionario;
					do {
						escolhaFuncionario = menuFuncionario(); // Obtém a escolha do funcionário
						switch (escolhaFuncionario) {
							case 1: // Gerir Produtos
								GerirProdutos.main(args);
								break;

							case 2: // Estatísticas
								Estatisticas.main(args);
								break;

							case 3: // Voltar ao menu inicial
								break;

							default:
								System.out.println("Opção inválida. Tente novamente.");
						}
					} while (escolhaFuncionario != 3);
					break;

				case 3: // Sair
					System.out.println("Encerrando o programa. Até breve!");
					continuar = false;
					break;

				default:
					System.out.println("Opção inválida. Tente novamente.");
			}
		}
	}
}
