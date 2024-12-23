import myinputs.Ler;

public class Inicio {
	
	public static int menu() { 
		int opcao;
		System.out.println("1 - Cliente");
		System.out.println("2 - Funcionario");
		opcao = Ler.umInt();
		return opcao;
	}

	public static void main(String[] args) {
		int escolha;
			escolha = menu();
			switch(escolha) {
			case 1:
				GerirCliente.main(args);
				break;
			case 2:
				GerirProdutos.main(args);
				break;
			default:
				System.out.println("Opção inválida");
			}
		}

	}


