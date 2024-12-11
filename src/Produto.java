import java.io.Serializable;
import java.time.LocalDateTime;

public class Produto implements Serializable {
    private String nome;
    private int stock;
    private double preco;
    private String categoria;
    private LocalDateTime validade;
    private int quantidadeVendida;
    private double valorFaturado;

    public Produto(String nome, String categoria, double preco, int stock, LocalDateTime validade) {
        this.categoria = categoria;
        this.nome = nome;
        this.preco = preco;
        this.stock = stock;
        this.validade = validade;
        quantidadeVendida = 0;
        valorFaturado = 0.0;
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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public LocalDateTime getValidade() {
        return validade;
    }

    public void setValidade(LocalDateTime validade) {
        this.validade = validade;
    }

    public int getQuantidadeVendida() {
        return quantidadeVendida;
    }

    public double getValorFaturado() {
        return valorFaturado;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "categoria='" + categoria + '\'' +
                ", nome='" + nome + '\'' +
                ", stock=" + stock +
                ", preco=" + preco +
                ", validade=" + validade +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && this.getClass() == obj.getClass()){
            Produto p = (Produto) obj;
            return(this.nome.equals(p.nome) && this.stock == p.stock && this.preco == p.preco);
        }
        return false;
    }
}
