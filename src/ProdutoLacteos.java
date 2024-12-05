import java.time.LocalDateTime;

public class ProdutoLacteos extends Produto {
    private double porcentagemGordura;

    public ProdutoLacteos(String nome, double preco, int stock, double porcentagemGordura, LocalDateTime validade) {
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
