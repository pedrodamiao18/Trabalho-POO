import java.time.LocalDateTime;

public class ProdutoPeso extends Produto{
    private double peso;

    public ProdutoPeso(int id, String nome, double preco, int stock, LocalDateTime validade, double peso) {
        super(nome, "Talho/Peixaria/LegumesFrutas", preco, stock, validade);
        this.peso = peso;
    }
}
