import java.time.LocalDateTime;

public class ProdutoMercearia extends Produto{

    public ProdutoMercearia( String nome, double preco, int stock, LocalDateTime validade) {
        super(nome, "Mercearia", preco, stock, validade);
    }
}
