import java.time.LocalDate;
import java.time.LocalDateTime;

public class ProdutoCongelado extends Produto{
    private double temperaturaRecomendada;

    public ProdutoCongelado(String nome, double preco, int stock, LocalDateTime validade, double temperaturaRecomendada) {
        super( nome, "Congelado", preco, stock, validade);
        this.temperaturaRecomendada = temperaturaRecomendada;
    }

    public double getTemperaturaRecomendada() {
        return temperaturaRecomendada;
    }

    public void setTemperaturaRecomendada(double temperaturaRecomendada) {
        this.temperaturaRecomendada = temperaturaRecomendada;
    }

    @Override
    public String toString() {
        return "ProdutoCongelado{" +
                "temperaturaRecomendada=" + temperaturaRecomendada +
                "} " + super.toString();
    }
}
