import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FuncFatura {
	    
	private static String nFatura = "num_fatura.txt";

	public static void atualizarArquivoFaturas(ArrayList<Fatura> faturas) {
		try {
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("src/faturas.dat"));
			os.writeObject(faturas);
			os.flush();
			os.close();
		} catch (IOException e) {
			System.out.println("Erro ao atualizar o arquivo: " + e.getMessage());
		}
	}

	public static void gravarEmArquivo(ArrayList<ProdQtd> lista, String nomeArquivo) {
		ArrayList<Produto> produtos = FuncProdutos.lerProdutosDoArquivo();

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo, true))) {
			for (Produto produto : produtos) {
				for (ProdQtd item : lista) {
					if (produto.getCod() == item.getCod()) {
						writer.write("Cod " + item.getCod() + "; " +
								produto.getNome() + "; " +
								item.getPreco() + "€; " +
								"Quantide: " + item.getQtd() );
						writer.newLine();
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void guardarFatura(Fatura fatura) {
		try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("src/faturas.txt", true)))) {
			writer.println("Número: " + fatura.getNumfatura());
			writer.println("Data: " + fatura.getData());
			writer.println("Cliente: " + fatura.getCliente().getNome());
			writer.println("NIF: " + fatura.getCliente().getNif());
			writer.println("Telefone: " + fatura.getCliente().getTelemovel());
			gravarEmArquivo(fatura.getItens(), "src/faturas.txt");
			writer.println("Valor: " + fatura.getTotal() + "€");
			writer.println("--------------------");
		} catch (IOException e) {
			System.out.println("Erro ao guardar as faturas: " + e.getMessage());
		}
	}



	public static void criarFatura(ArrayList<Fatura> faturas, ArrayList<ProdQtd> lista, ArrayList<Produto> produtos, Cliente clienteAtual) {
		Fatura f = new Fatura(clienteAtual, lista); // Cria uma nova instância de Fatura
		faturas.add(f);

		ArrayList<String> itens = new ArrayList<>();

		for (int x = 0; x < lista.size(); x++) {
			for (Produto produto : produtos) {
				if (lista.get(x).getCod() == produto.getCod()) {
					// Obter a quantidade e calcular o valor do item
					int qtd = lista.get(x).getQtd();
					double preco = produto.getPreco();
					double valorItem = qtd * preco;

					// Atualizar os dados do produto
					produto.setQuantidadeVendida(produto.getQuantidadeVendida() + qtd);
					produto.setValorFaturado(produto.getValorFaturado() + valorItem);
					produto.setStock(produto.getStock() - qtd);

					// Atualizar o total da fatura
					f.setTotal(f.getTotal() + valorItem);

					// Atualizar o total gasto e número de compras do cliente atual
					clienteAtual.setGastoTotal(clienteAtual.getGastoTotal() + valorItem);
					clienteAtual.setNumeroDeCompras(clienteAtual.getNumeroDeCompras() + 1);
				}
			}
		}

		// Atualizar arquivos
		FuncProdutos.atualizarArquivo(produtos);
		atualizarArquivoFaturas(faturas);
		FuncCliente.atualizarArquivoClientes(FuncCliente.lerClienteDoArquivo());

		guardarFatura(f);
	}

	public static ArrayList<Fatura> lerFaturasdoArquivo(){
			ArrayList<Fatura> faturas = new ArrayList<>();
			// Ler ficheiro
			try {
				ObjectInputStream is = new ObjectInputStream( new FileInputStream("src/faturas.dat"));
				faturas = (ArrayList<Fatura>) is.readObject();
			}
			catch (IOException e){
				System.out.println(e.getMessage());
			}
			catch ( ClassNotFoundException e) {
				System.out.println(e.getMessage());
			}
	    	
	    	return faturas;
	    }
	    
	    public static int VerificarTotal(int nif) {
	    	int totalgasto = 0;
	    	ArrayList<Fatura> faturas = FuncFatura.lerFaturasdoArquivo();
			for(int i = 0; i < faturas.size(); i++) {
				if(faturas.get(i).getCliente().getNif()==nif) {
					totalgasto += faturas.get(i).getTotal();
				}
			}
			return totalgasto;
	    }

	public static void imprimirTodasFaturas(ArrayList<Fatura> faturas) {
		for (Fatura fatura : faturas) {
			System.out.println(fatura);
		}
	}
}
