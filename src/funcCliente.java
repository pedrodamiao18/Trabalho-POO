import java.util.ArrayList;
import myinputs.Ler;

public class funcCliente {
	public static void criarLista(ArrayList<ProdQtd> lista) {
		System.out.print("1 - adicionar produto \n");
		System.out.print("0 - Sair \n");
		int a = Ler.umInt();
		do {
			System.out.print("Introduza o codigo do produto: ");
			int cod = Ler.umInt();
			System.out.print("Introduza a quantidade: ");
			int qtd = Ler.umInt();
			ProdQtd p = new ProdQtd(cod, qtd);
			lista.add(p);
		}while(a!=0);
	}


}
