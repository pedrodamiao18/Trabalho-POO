import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import myinputs.Ler;

public class FuncProdutos {
    public static void adicionarProduto(ArrayList<Produto> produtos) {
        System.out.println("Insira o nome do produto a adicionar:");
        String nome = Ler.umaString();

        System.out.println("Insira a categoria do produto:");
        String categoria = Ler.umaString();

        System.out.println("Insira o preço do produto:");
        double preco = Ler.umDouble();

        System.out.println("Insira a quantidade de produtos que deseja a adicionar(stock):");
        int stock = Ler.umInt();

        LocalDate validade = null;
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        while (validade == null) {
            System.out.println("Insira a validade do produto (formato: dd-MM-yyyy):");
            String validadeStr = Ler.umaString();
            try {
                validade = LocalDate.parse(validadeStr, formato);
            } catch (DateTimeParseException e) {
                System.out.println("Data inválida. Certifique-se de usar o formato dd-MM-yyyy.");
            }
        }
        // Cria o novo produto
        Produto novoProduto = new Produto(nome, categoria, preco, stock, validade);

        // Adiciona o novo produto à lista
        produtos.add(novoProduto);
        System.out.println("Produto adicionado com sucesso: " + novoProduto);
    }
}
