import java.time.LocalDateTime;

public class ProdutoLacteo extends Produto {
    private double porcentagemGordura;

    public ProdutoLacteo(String nome, double preco, int stock, double porcentagemGordura, LocalDateTime validade) {
        super(nome, "Lácteo", preco, stock, validade);
        this.porcentagemGordura = porcentagemGordura;
    }

    public double getPorcentagemGordura() {
        return porcentagemGordura;
    }

    public void setPorcentagemGordura(double porcentagemGordura) {
        this.porcentagemGordura = porcentagemGordura;
    }


}
