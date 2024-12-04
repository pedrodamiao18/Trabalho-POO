public class Produtos {
    private static int ultimo;
    private int id;
    private String nome;
    private int stock;
    private double preco;

    public Produtos(String nome, double preco, int stock) {
        ultimo++;
        id = ultimo;
        this.nome = nome;
        this.preco = preco;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public static int getUltimo() {
        return ultimo;
    }

    public static void setUltimo(int ultimo) {
        Produtos.ultimo = ultimo;
    }

    @Override
    public String toString() {
        return "Produtos{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", stock=" + stock +
                ", preco=" + preco +
                '}';
    }

    public void adicionarStock(int quantidade){
        this.stock += quantidade;
    }
}
