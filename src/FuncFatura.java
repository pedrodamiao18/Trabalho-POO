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
		try {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i<lista.size(); i++) {
				sb.append(lista.get(i).getCod()).append("; ")
						.append(lista.get(i).getPreco()).append("€").append("; ")
						.append(lista.get(i).getQtd()).append(" Unt").append("\n");
			}
			Files.write(Paths.get(nomeArquivo), sb.toString().getBytes());
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

			gravarEmArquivo(fatura.getItens()+ "\n", "src/faturas.txt");

			writer.println("Valor: " + fatura.getTotal());
			writer.println("--------------------"); // Separador entre as faturas

		} catch (IOException e) {
			System.out.println("Erro ao guardar as faturas: " + e.getMessage());
		}
	}



	public static void criarFatura(ArrayList<Fatura>faturas, ArrayList<ProdQtd> lista, ArrayList<Produto> produtos, Cliente c) {
				int numFatura = obterNumeroFatura();
				Fatura f = new Fatura(c, numFatura, lista); // Cria uma nova instância de Venda
				faturas.add(f);

				ArrayList<Cliente> clientes = FuncCliente.lerClienteDoArquivo();
				ArrayList<String> itens = new ArrayList<>();

				for (int x = 0; x < lista.size(); x++) {
					// Iterar sobre os clientes para encontrar o cliente correspondente
					for (Cliente cliente : clientes) {
						if (c.getNif() == cliente.getNif()) {

							// Iterar sobre os produtos para encontrar o produto correspondente
							for (Produto produto : produtos) {
								if (lista.get(x).getCod() == produto.getCod()) {
									// Obter a quantidade e calcular o valor do item
									int qtd = lista.get(x).getQtd(); // Corrigido: usa o índice x
									double preco = produto.getPreco();
									double valorItem = qtd * preco;

									produto.setQuantidadeVendida(produto.getQuantidadeVendida() + qtd);
									produto.setValorFaturado(produto.getValorFaturado() + valorItem);
									f.setTotal(f.getTotal() + valorItem);


									// Atualizar o total gasto pelo cliente
									cliente.setGastoTotal(cliente.getGastoTotal() + valorItem);
									cliente.setNumeroDeCompras(cliente.getNumeroDeCompras() + 1);

								// Atualizar o estoque do produto
								produto.setStock(produto.getStock() - qtd);
								FuncProdutos.atualizarArquivo(produtos);
								FuncCliente.atualizarArquivoClientes(clientes);
								atualizarArquivoFaturas(faturas);

							}
						}
					}
				}
			}
				atualizarNumeroFatura(numFatura);
				guardarFatura(f);
	    }
	    
	    private static int obterNumeroFatura() {
			try (BufferedReader reader = new BufferedReader(new FileReader(nFatura))) {
	            String line = reader.readLine();
	            return line != null ? Integer.parseInt(line) : 0; // Retorna 0 se o arquivo estiver vazio
	        } catch (IOException e) {
	            return 0; // Retorna 0 se houver um erro ao ler o arquivo
	        }
	    }
	    
	    private static void atualizarNumeroFatura(int numFatura) {
	        try (FileWriter fw = new FileWriter(nFatura)) {
	            fw.write(String.valueOf(numFatura + 1)); // Incrementa o número da fatura
	        } catch (IOException e) {
	        	System.out.println(e.getMessage());
	        }
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
