import java.time.LocalDate;
import java.io.Serializable;
import java.util.ArrayList;

public class Fatura  implements Serializable{
	private int numfatura;
	private LocalDate data;
	private Cliente cliente;
	private ArrayList<ProdQtd> itens;
	private double total;

	public Fatura(Cliente cliente, int numfatura, ArrayList<ProdQtd> itens) {
		this.cliente = cliente;
		this.numfatura = numfatura;
		data = LocalDate.now();
		this.itens = itens;
		this.total = 0;
	}


	public int getNumfatura() {
		return numfatura;
	}
	
	public double getTotal() {
		return total;
	}
	
	public void setTotal(double total) {
		this.total = total;
	}

	public LocalDate getData() {return this.data;}

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
		return "Fatura{" +
				"cliente=" + cliente +
				", numfatura=" + numfatura +
				", data=" + data +
				", itens=" + itens +
				", total=" + total +
				'}';
	}
}
