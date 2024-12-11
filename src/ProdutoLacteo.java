import java.time.LocalDate;

//queijos, leite, yogurte
public class ProdutoLacteo extends Produto {
    private double porcentagemGordura;

    public ProdutoLacteo(String nome, double preco, int stock, double porcentagemGordura, LocalDate validade, String unidadeMedida, double quantidadeMedida) {
        super(nome, "Lácteo", preco, stock, validade, unidadeMedida, quantidadeMedida);
        this.porcentagemGordura = porcentagemGordura;
    }

    public double getPorcentagemGordura() {
        return porcentagemGordura;
    }

    public void setPorcentagemGordura(double porcentagemGordura) {
        this.porcentagemGordura = porcentagemGordura;
    }


}
