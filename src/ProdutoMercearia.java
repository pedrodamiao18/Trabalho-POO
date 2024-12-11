import java.time.LocalDate;

//arroz, massa, ovos
public class ProdutoMercearia extends Produto{

    public ProdutoMercearia( String nome, double preco, int stock, LocalDate validade,String unidadeMedia, double quantidadeMedida) {
        super(nome, "Mercearia", preco, stock, validade,unidadeMedia , quantidadeMedida);

    }


}
