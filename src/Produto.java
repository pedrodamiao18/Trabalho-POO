import java.io.Serializable;
import java.time.LocalDate;

public class Produto implements Serializable {
    private int cod;
    private static int ultimo = 0;
    private String nome;
    private int stock;
    private double preco;
    private String categoria;
    private LocalDate validade;
    private int quantidadeVendida;
    private double valorFaturado;
    private String unidadeMedida;
    private double quantidadeMedida;

    public Produto(String nome, String categoria, double preco, int stock, LocalDate validade, String unidadeMedida, double quantidadeMediade) {
        ultimo++;
        cod = ultimo;
        this.categoria = categoria;
        this.nome = nome;
        this.preco = preco;
        this.stock = stock;
        this.validade = validade;
        quantidadeVendida = 0;
        valorFaturado = 0.0;
        this.unidadeMedida = unidadeMedida;
        this.quantidadeMedida = quantidadeMedida;
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

    public LocalDate getValidade() {
        return validade;
    }

    public void setValidade(LocalDate validade) {
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
                "cod=" + cod +
                ", categoria='" + categoria + '\'' +
                ", nome='" + nome + '\'' +
                ", preco=" + preco +
                ", stock=" + stock +
                ", unidadeMedida='" + unidadeMedida + '\'' +
                ", quantidadeMedida=" + quantidadeMedida +
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