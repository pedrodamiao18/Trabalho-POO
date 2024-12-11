import java.time.LocalDate;

//carne, peixe, legumes, fruta
public class ProdutoFresco extends Produto{

    private String tipo;

    public ProdutoFresco(String nome, double preco, int stock, LocalDate validade, double quantidadeunidade, String tipo) {
        super(nome, "Fresco", preco, stock, validade, "Kg", quantidadeunidade);
        this.tipo = tipo;
    }
}
