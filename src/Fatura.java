import java.time.LocalDate;
import java.io.Serializable;

public class Fatura extends Cliente implements Serializable{
	private int numfatura;
	private LocalDate data;
	private double total;

	public Fatura(Cliente c, int numfatura) {
		super(c.getNif(), c.getNome(), c.getTelemovel());
		this.numfatura = numfatura;
		data = LocalDate.now();
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
