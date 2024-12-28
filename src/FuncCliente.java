import java.io.*;
import java.util.ArrayList;
import myinputs.Ler;

public class FuncCliente {

	public static void atualizarArquivoClientes(ArrayList<Cliente> clientes) {
		try {
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("src/clientes.dat"));
			os.writeObject(clientes);
			os.flush();
			os.close();
		} catch (IOException e) {
			System.out.println("Erro ao atualizar o arquivo: " + e.getMessage());
		}
	}

	public static Cliente novoCliente(ArrayList<Cliente> clientes) {
		try {
			System.out.print("Introduza o seu NIF: ");
			int nif = Ler.umInt();
			if (nif <= 0) {
				throw new DadosInvalidosException("O NIF deve ser maior que zero.");
			}

			System.out.print("Introduza o seu nome: ");
			String nome = Ler.umaString();
			if (nome == null) {
				throw new DadosInvalidosException("O nome não pode estar vazio.");
			}

			System.out.print("Introduza o seu telemovel: ");
			int telemovel = Ler.umInt();
			if (telemovel <= 0) {
				throw new DadosInvalidosException("O telemovel deve ser maior que zero.");
			}

			Cliente c = new Cliente(nif, nome, telemovel);
			clientes.add(c);
			System.out.println("Cliente adicionado com sucesso!");

			atualizarArquivoClientes(clientes);
			return c;

		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
		return null;
	}

	public static Cliente clienteExistente(ArrayList<Cliente> clientes) {
		try {
			System.out.print("Introduza o seu NIF para continuar: ");
			int nifExistente = Ler.umInt();
			if (nifExistente <= 0) {
				throw new DadosInvalidosException("O NIF deve ser maior que zero.");
			}

			for (Cliente c : clientes) {
				if (c.getNif() == nifExistente) {
					System.out.println("Bem-vindo de volta, " + c.getNome() + "!");
					return c;
				}
			}
			throw new ClienteNaoEncontradoException("Cliente não encontrado!");
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
		return null;
	}

	// Método para alterar dados do cliente
	public static void alterarDados(ArrayList<Cliente> clientes) {
		try {
			System.out.print("Introduza o seu NIF: ");
			int nif = Ler.umInt();
			if (nif <= 0) {
				throw new DadosInvalidosException("O NIF deve ser maior que zero.");
			}


			Cliente cliente = encontrarClientePorNIF(clientes, nif);

			System.out.print("Introduza o seu novo nome: ");
			String nome = Ler.umaString();
			if (nome == null || nome.trim().isEmpty()) {
				throw new DadosInvalidosException("O nome não pode estar vazio.");
			}
			cliente.setNome(nome);

			System.out.print("Introduza o seu novo telemovel: ");
			int telemovel = Ler.umInt();

			cliente.setTelemovel(telemovel);

			System.out.println("Dados atualizados com sucesso!");
			atualizarArquivoClientes(clientes);

		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}


	public static void verificarTotalGasto(ArrayList<Cliente> clientes) {
		try {
			System.out.print("Introduza o seu NIF: ");
			int nif = Ler.umInt();
			if (nif <= 0) {
				throw new DadosInvalidosException("O NIF deve ser maior que zero.");
			}

			Cliente cliente = encontrarClientePorNIF(clientes, nif);
			System.out.println("Total gasto: " + cliente.getGastoTotal());

		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}

	// Método para criar uma lista de compras
	public static void criarLista(ArrayList<ProdQtd> lista, ArrayList<Produto> produtos) {
		try {
			System.out.println("1 - Adicionar produto");
			System.out.println("0 - Sair");
			int escolha = Ler.umInt();

			if (escolha == 1) {
				System.out.print("Introduza o código do produto: ");
				int cod = Ler.umInt();

				System.out.print("Introduza a quantidade: ");
				int qtd = Ler.umInt();
				if (qtd <= 0) {
					throw new DadosInvalidosException("Quantidade deve ser maior que zero.");
				}
				double preco = 0;
				for(int i = 0; i<produtos.size(); i++) {
					if(cod == produtos.get(i).getCod()) {
						preco = produtos.get(i).getPreco();
					}
				}

				ProdQtd p = new ProdQtd(cod, qtd, preco);
				lista.add(p);
				System.out.println("Produto adicionado à lista.");
			} else if (escolha == 0) {
				if (lista.isEmpty()) {
					throw new ListaVaziaException("A lista está vazia! Não há produtos para processar.");
				}
				System.out.println("Lista de compras criada com sucesso.");
			} else {
				throw new DadosInvalidosException("Opção inválida!");
			}

		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}

	// Métodos auxiliares
	private static Cliente encontrarClientePorNIF(ArrayList<Cliente> clientes, int nif) throws ClienteNaoEncontradoException {
		for (Cliente c : clientes) {
			if (c.getNif() == nif) {
				return c;
			}
		}
		throw new ClienteNaoEncontradoException("Cliente com NIF " + nif + " não encontrado.");
	}

	public static ArrayList<Cliente> lerClienteDoArquivo() {
		ArrayList<Cliente> clientes = new ArrayList<>();
		// Ler ficheiro
		try {
			ObjectInputStream is = new ObjectInputStream( new FileInputStream("src/clientes.dat"));
			clientes = (ArrayList<Cliente>) is.readObject();
		}
		catch (IOException e){
			System.out.println(e.getMessage());
		}
		catch ( ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		return clientes;
	}

}

