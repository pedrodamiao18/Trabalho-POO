import java.time.LocalDateTime;

public class ProdutoBebida extends Produto{
    private double volume;

    public ProdutoBebida(String nome, double preco, int stock, double volume, LocalDateTime validade) {
        super(nome, "Bebida", preco, stock, validade);
        this.volume = volume;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        return "ProdutoBebida{" +
                "volume=" + volume +
                "} " + super.toString();
    }
}
