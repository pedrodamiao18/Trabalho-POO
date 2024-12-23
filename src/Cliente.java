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

    public double getGastoTotal() {
        return gastoTotal;
    }

    public void setGastoTotal(double gastoTotal) {
        this.gastoTotal = gastoTotal;
    }

    public int getNif() {
        return nif;
    }

    public void setNif(int nif) {
        this.nif = nif;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumeroDeCompras() {
        return numeroDeCompras;
    }

    public void setNumeroDeCompras(int numeroDeCompras) {
        this.numeroDeCompras = numeroDeCompras;
    }

    public int getTelemovel() {
        return telemovel;
    }

    public void setTelemovel(int telemovel) {
        this.telemovel = telemovel;
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
