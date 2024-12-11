import java.time.LocalDate;

//carne, peixe, legumes, fruta
public class ProdutoFresco extends Produto{

    private String tipoProduto;

    public ProdutoFresco(String nome, double preco, int stock, LocalDate validade, double quantidadeunidade, String tipo) {
        super(nome, "Fresco", preco, stock, validade, "Kg", quantidadeunidade);
        this.tipoProduto = tipo;
    }
}
