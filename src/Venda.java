import java.io.Serializable;
import java.util.ArrayList;

public class Venda {


    /*private Cliente cliente;
    private ArrayList<Produto> carrinho;
    private Fatura fatura;

    public Venda(Cliente cliente) {
        this.cliente = cliente;
        this.carrinho = new ArrayList<>();
        this.fatura = new Fatura(cliente, gerarNumeroFatura());
    }



    public void adicionarProduto(Produto produto, int quantidade) {
        if (produto.getStock() >= quantidade) {
            produto.setStock(produto.getStock() - quantidade);
            carrinho.add(produto);
            double valor = quantidade * produto.getPreco();
            produto.setQuantidadeVendida(produto.getQuantidadeVendida() + quantidade);
            produto.setValorFaturado(produto.getValorFaturado() + valor);
            fatura.setTotal(fatura.getTotal() + valor);
        } else {
            System.out.println("Estoque insuficiente para o produto: " + produto.getNome());
        }
    }

    public void finalizarVenda() {
        cliente.registrarCompra(fatura.getTotal());
        System.out.println("Venda finalizada com sucesso!");
        System.out.println("Fatura:\n" + fatura);
        System.out.println("Produtos vendidos:");
        for (Produto produto : carrinho) {
            System.out.println(produto.getNome() + " - Quantidade: " + produto.getQuantidadeVendida());
        }
    }

    private int gerarNumeroFatura() {
        return (int) (Math.random() * 100000); // Número aleatório para a fatura
    }

    public Cliente getCliente() {
        return cliente;
    }

    public ArrayList<Produto> getCarrinho() {
        return carrinho;
    }

    public Fatura getFatura() {
        return fatura;
    }*/
}
