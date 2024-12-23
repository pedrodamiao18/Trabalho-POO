import myinputs.Ler;
import java.io.*;
import java.io.File;
import java.util.ArrayList;

public class GerirCliente {
	
	
	public static int menu() { // função na classe do main
		int opcao;
		System.out.println("1 - Ver produtos");
		System.out.println("2 - Criar lista");
		System.out.println("3 - Verificar total gasto");
		System.out.println("4 - alterar dados");
		System.out.println("5 - Proceder para o pagamento");
		System.out.println("6 - Sair");
		System.out.println("Qual a sua opção:");
		opcao = Ler.umInt();
		return opcao;
	}
	
	public static void main(String args[]) {
		int escolha;
		System.out.println("Introduza o seu nome: ");
		String nome = Ler.umaString();
		System.out.print("Introduza o seu NIF");
		int nif = Ler.umInt();
		System.out.print("Introduza o seu telemovel");
		int telemovel = Ler.umInt();
		Cliente c = new Cliente(nif, nome, telemovel);
		ArrayList<ProdQtd> lista = new ArrayList<>();
		ArrayList<Produto> produtos = FuncProdutos.lerProdutosDoArquivo();
		ArrayList<Fatura> faturas = funcFatura.lerFaturasdoArquivo();
		
		do {
			escolha = menu();
			switch (escolha) {
			case 1:
		        // Imprime os produtos lidos do arquivo
		        for (int i = 0; i<produtos.size(); i++) {
		            System.out.println("Código: " + produtos.get(i).getCod());
		            System.out.println("Preço: " + produtos.get(i).getPreco());
		            System.out.println("Stock: " + produtos.get(i).getStock());
		            System.out.println("--------------------");
		        }
				break;
			case 2:
				funcCliente.criarLista(lista);
				break;
			case 3: 
				System.out.print("Introduza o seu NIF: \n");
				int n = Ler.umInt();
				funcFatura.VerificarTotal(nif);
				break;
			case 4:
				System.out.print("1-Mudar o nome 2-Mudar o NIF 0-Sair");
				int opcao = Ler.umInt();
				if(opcao == 1) {
					String novonome = Ler.umaString();
					c.setNome(novonome);
				}else {if(opcao == 2) {
					int novonif = Ler.umInt();
					c.setNif(novonif);
				}}
				break;
			case 5:
				funcFatura.criarFatura(faturas, lista, produtos, c);
				break;
			}
		} while (escolha != 6);
	}
}
