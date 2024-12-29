import java.io.*;

public class Produto implements Serializable {
    private int cod;
    private static int ultimo;
    private String nome;
    private int stock;
    private double preco;
    private String categoria;
    private int quantidadeVendida;
    private double valorFaturado;
    private String unidadeMedida;
    private double quantidadeMedida;

    public static final String[] categoriasPossiveis = {
            "Mercearia", "Congelados", "Lacteos", "Talho", "Peixaria",
            "Frutaria", "Legumes", "Padaria", "Charcutaria", "Bebidas"
    };

    public Produto(String nome, String categoria, double preco, int stock, String unidadeMedida, double quantidadeMedida) {
        carregarUltimo();
        ultimo++;
        this.cod = ultimo;
        this.categoria = categoria;
        this.nome = nome;
        this.preco = preco;
        this.stock = stock;
        this.quantidadeVendida = 0;
        this.valorFaturado = 0.0;
        this.unidadeMedida = unidadeMedida;
        this.quantidadeMedida = quantidadeMedida;
        salvarUltimo();
    }

    private void carregarUltimo() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/ultimo.dat"))) {
            ultimo = ois.readInt();
        } catch (IOException e) {
            ultimo = 0; // Se o arquivo não existir, inicializa com 0
        }
    }

    private void salvarUltimo() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/ultimo.dat"))) {
            oos.writeInt(ultimo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Getters e setters

    public int getCod() {
        return cod;
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

    public int getQuantidadeVendida() {
        return quantidadeVendida;
    }

    public double getValorFaturado() {
        return valorFaturado;
    }

    public void setQuantidadeVendida(int quantidadeVendida) {
        this.quantidadeVendida = quantidadeVendida;
    }

    public void setValorFaturado(double valorFaturado) {
        this.valorFaturado = valorFaturado;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "cod = " + cod +
                ", categoria = '" + categoria + '\'' +
                ", nome = '" + nome + '\'' +
                ", preco = " + preco + "€" +
                ", stock = " + stock +
                ", quantidade = " + quantidadeMedida + " " + unidadeMedida +
                '}' + "\n";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && this.getClass() == obj.getClass()) {
            Produto p = (Produto) obj;
            return this.cod == p.cod &&
                    this.nome.equals(p.nome) &&
                    this.stock == p.stock &&
                    this.preco == p.preco &&
                    this.categoria.equals(p.categoria) &&
                    this.unidadeMedida.equals(p.unidadeMedida) &&
                    this.quantidadeMedida == p.quantidadeMedida;
        }
        return false;
    }
}