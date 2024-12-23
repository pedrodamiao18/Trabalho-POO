import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import myinputs.Ler;
import java.io.BufferedReader;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;

public class funcFatura {
	    
	    private static String nFatura = "num_fatura.txt";

		public static void criarFatura(ArrayList<Fatura>faturas, ArrayList<ProdQtd> lista, ArrayList<Produto> produtos, Cliente c) {
	        int numFatura = obterNumeroFatura();
	        Fatura f = new Fatura(c, numFatura); // Cria uma nova instância de Venda

	        faturas.add(f);
	        
	        try{
	        	ObjectOutputStream fr = new ObjectOutputStream(new FileOutputStream("faturas.dat"));
	            // Itens da Fatura
	            for (int i = 0; i < lista.size(); i++) {
	                for (int j = 0; j < produtos.size(); j++) {
	                    if (lista.get(i).getCod() == produtos.get(j).getCod()) {
	                        int qtd = lista.get(i).getQtd();
	                        double preco = produtos.get(j).getPreco();
	                        double valorItem = qtd * preco;
	                        f.setTotal(f.getTotal()+valorItem);
	                    
	                        produtos.get(j).setStock(produtos.get(j).getStock() - qtd);
	                    }//escrever a lista dos pordutos com as quantidades atualizadas 
	                }
	            }
	            
	            fr.writeObject(faturas);
	            fr.flush();
	            
	            atualizarNumeroFatura(f.getNumfatura());

	        } catch (IOException e) {
	        	System.out.println(e.getMessage());
	        }
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
	    	ArrayList<Fatura> faturas = funcFatura.lerFaturasdoArquivo();
			for(int i = 0; i < faturas.size(); i++) {
				if(faturas.get(i).getCliente().getNif()==nif) {
					totalgasto += faturas.get(i).getTotal(); 
				}
			}
			return totalgasto;
	    }
}
