import java.io.Serializable;

public class ProdQtd implements Serializable {

	private int qtd;
	private int cod;
	private double preco;
	
	public ProdQtd(int cod, int qtd, double preco) {
		this.cod = cod;
		this.qtd = qtd;
		this.preco = preco;
	}
	
	public int getQtd() {
		return qtd;
	}
	public void setQtd(int qtd) {
		this.qtd = qtd;
	}
	public int getCod() {
		return cod;
	}
	public void setCod(int cod) {
		this.cod = cod;
	}
	public double getPreco(){return preco;}
	public void setPreco(double preco){this.preco = preco;}
	
}
