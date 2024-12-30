import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class Fatura implements Serializable {
	private int numfatura;
	private LocalDate data;
	private Cliente cliente;
	private ArrayList<ProdQtd> itens;
	private double total;
	private static int ultimoNumFatura;

	public Fatura(Cliente cliente, ArrayList<ProdQtd> itens) {
		carregarUltimoNumFatura();
		ultimoNumFatura++;
		this.numfatura = ultimoNumFatura;
		this.cliente = cliente;
		this.data = LocalDate.now();
		this.itens = itens;
		this.total = 0;
		salvarUltimoNumFatura();
	}

	private void carregarUltimoNumFatura() {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/ultimoNumFatura.dat"))) {
			ultimoNumFatura = ois.readInt();
		} catch (IOException e) {
			ultimoNumFatura = 0; // Se o arquivo não existir, inicializa com 0
		}
	}

	private void salvarUltimoNumFatura() {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/ultimoNumFatura.dat"))) {
			oos.writeInt(ultimoNumFatura);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Getters e setters

	public int getNumfatura() {
		return numfatura;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public LocalDate getData() {
		return this.data;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public ArrayList<ProdQtd> getItens() {
		return itens;
	}

	public void setItens(ArrayList<ProdQtd> itens) {
		this.itens = itens;
	}


	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();

		for (ProdQtd item : itens) {
			s.append("cod " + item.getCod()).append(" - ").append("quantidade" + item.getQtd()).append("; ");
		}

		return "Fatura{" +
				"cliente=" + cliente +
				", numfatura=" + numfatura +
				", data=" + data +
				", itens= " + s +
				"total=" + total +
				'}';
	}
}