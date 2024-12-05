import java.time.LocalDateTime;

public class ProdutoPadaria extends Produto {


    public ProdutoPadaria(int id, String nome, double preco, int stock, LocalDateTime validade) {
        super(nome, "Padaria", preco, stock, validade);
    }



}
