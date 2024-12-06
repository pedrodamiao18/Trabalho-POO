import java.time.LocalDateTime;

public class ProdutoLegumeFruta extends Produto{
    private double peso;

    public ProdutoLegumeFruta(int id, String nome, double preco, int stock, LocalDateTime validade, double peso) {
        super(nome, "Legumes/Frutas", preco, stock, validade);
        this.peso = peso;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "ProdutoLegumeFruta{" +
                "peso=" + peso +
                "} " + super.toString();
    }
}
