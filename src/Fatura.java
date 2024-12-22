import java.time.LocalDate;
import java.util.ArrayList;

public class Fatura implements Serielizable {
	private int numfatura;
	private LocalDate data;
	private Cliente c;
	private double total;

	public Fatura(Cliente c, int numfatura) {
		numFatura = numfatura;
		data = LocalDate.now();
		this.c = c;
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

}
