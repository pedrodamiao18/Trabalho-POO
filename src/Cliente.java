public class Cliente {
    private String nome;
    private int telemovel;
    private int nif;
    private double gastoTotal;
    private int numeroDeCompras;

    public Cliente(int nif, String nome, int telemovel) {
        this.nif = nif;
        this.nome = nome;
        this.telemovel = telemovel;
        this.gastoTotal = 0.0;
        this.numeroDeCompras = 0;
    }

    public void registrarCompra(double valor) {
        this.numeroDeCompras++;
        this.gastoTotal += valor;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nif=" + nif +
                ", nome='" + nome + '\'' +
                ", telemovel=" + telemovel +
                ", gastoTotal=" + gastoTotal +
                ", numeroDeCompras=" + numeroDeCompras +
                '}';
    }
}
