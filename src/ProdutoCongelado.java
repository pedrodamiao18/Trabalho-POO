import java.time.LocalDate;


public class ProdutoCongelado extends Produto{
    private double temperaturaRecomendada;

    public ProdutoCongelado(String nome, double preco, int stock, LocalDate validade, double temperaturaRecomendada, double quantidadeMedida) {
        super( nome, "Congelado", preco, stock, validade, "Kg", quantidadeMedida);
        this.temperaturaRecomendada = temperaturaRecomendada;
    }

    public double getTemperaturaRecomendada() {
        return temperaturaRecomendada;
    }

    public void setTemperaturaRecomendada(double temperaturaRecomendada) {
        this.temperaturaRecomendada = temperaturaRecomendada;
    }


}
