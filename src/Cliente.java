public class Cliente {
    private String nome;
    private int telemovel;
    private int contribuinte;
    private double gastoTotal;
    private int numeroDeCompras;

    public Cliente(int contribuinte, String nome, int telemovel) {
        this.contribuinte = contribuinte;
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
                "contribuinte=" + contribuinte +
                ", nome='" + nome + '\'' +
                ", telemovel=" + telemovel +
                ", gastoTotal=" + gastoTotal +
                ", numeroDeCompras=" + numeroDeCompras +
                '}';
    }
}
