import myinputs.Ler;

public class Inicio {
	
	public static int menu() { 
		int opcao;
		System.out.println("1 - Cliente");
		System.out.println("2 - Funcionario");
		opcao = Ler.umInt();
		return opcao;
	}

	public static int menuFuncionario(){
		int opcao;
		System.out.println("1 - Gerir Produtos");
		System.out.println("2 - Estatisticas");
		opcao = Ler.umInt();
		return opcao;
	}

	public static void main(String[] args) {
		System.out.println("Bem vindo à nossa loja!");
		System.out.println("Selecione o seu peril:");
		int escolha;
			escolha = menu();
			switch(escolha) {
			case 1:
				GerirCliente.main(args);
				break;
			case 2:
				System.out.println("\nÁrea do Funcionário");
				int escolhaFuncionario;
				escolhaFuncionario = menuFuncionario();
				switch(escolhaFuncionario) {
				case 1:
					GerirProdutos.main(args);
					break;
				case 2:
					Estatisticas.main(args);
					break;
				default:
					System.out.println("Opção inválida");
				}
				break;
			default:
				System.out.println("Opção inválida");
			}
		}

	}


