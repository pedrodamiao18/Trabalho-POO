import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import myinputs.Ler;

public class FuncCliente {

	public static Cliente novoCliente(ArrayList<Cliente> clientes) {
		System.out.print("Introduza o seu NIF: \n");
		int nif = Ler.umInt();
		System.out.print("Introduza o seu nome: \n");
		String nome = Ler.umaString();
		System.out.print("Introduza o seu telemovel: \n");
		int telemovel = Ler.umInt();
		Cliente c = new Cliente(nif, nome, telemovel);
		clientes.add(c);

		try {
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("src/clientes.dat"));
			os.writeObject(clientes);
			os.flush();
			os.close();
		} catch (IOException e) {
			System.out.println("Erro ao atualizar o arquivo: " + e.getMessage());
		}
		return c;
	}

	public static Cliente clienteExistente(ArrayList<Cliente> clientes) {
		System.out.print("Introduza o seu NIF para continuar: ");
		int nifExistente = Ler.umInt();
		boolean clienteEncontrado = false;
		for (Cliente c : clientes) {
			if (c.getNif() == nifExistente) {
				clienteEncontrado = true;
				System.out.println("Bem-vindo de volta, " + c.getNome() + "!");
				return c;
			}
		}
		if (!clienteEncontrado) {
			System.out.println("Cliente não encontrado! Tente novamente.");
		}

		return null;
	}

	public static void alterarDados(ArrayList<Cliente> clientes) {
		System.out.print("Introduza o seu NIF: \n");
		int nif = Ler.umInt();
		for (Cliente c : clientes) {
			if (c.getNif() == nif) {
				System.out.print("Introduza o seu novo nome: \n");
				String nome = Ler.umaString();
				c.setNome(nome);
				System.out.print("Introduza o seu novo telemovel: \n");
				int telemovel = Ler.umInt();
				c.setTelemovel(telemovel);
			}
		}
		try {
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("src/clientes.dat"));
			os.writeObject(clientes);
			os.flush();
			os.close();
		} catch (IOException e) {
			System.out.println("Erro ao atualizar o arquivo: " + e.getMessage());
		}
	}

	public static void criarLista(ArrayList<ProdQtd> lista) {
		System.out.print("1 - adicionar produto \n");
		System.out.print("0 - Sair \n");
		int a = Ler.umInt();
		if (a == 1) {
			System.out.print("Introduza o codigo do produto: ");
			int cod = Ler.umInt();
			System.out.print("Introduza a quantidade: ");
			int qtd = Ler.umInt();
			ProdQtd p = new ProdQtd(cod, qtd);
			lista.add(p);
		}
	}
}
