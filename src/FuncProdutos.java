import myinputs.Ler;
import java.time.LocalDate;
import java.util.ArrayList;
import java.io.*;

public class FuncProdutos {
    public static void adicionarProduto (ArrayList<Produto> produtos){

        System.out.println("Digite a categoria do produto (Escolha entre as opções):");
        for (String categoria : Produto.categoriasPossiveis) {
            System.out.print(categoria + ", ");
        }
        System.out.println(); // Pula linha após mostrar as categorias

        String categoria = Ler.umaString();

        // Verificar se a categoria é válida usando um for
        boolean categoriaValida = false;
        for (String cat : Produto.categoriasPossiveis) {
            if (cat.equalsIgnoreCase(categoria)) { // Comparação case insensitive
                categoriaValida = true;
                break;
            }
        }

        if (!categoriaValida) {
            System.out.println("Categoria inválida! Produto não adicionado.");
            return;
        }

        System.out.println("Digite o nome do produto:");
        String nome = Ler.umaString();

        System.out.println("Digite o preço do produto:");
        double preco = Ler.umDouble();

        System.out.println("Digite o stock do produto:");
        int stock = Ler.umInt();

        System.out.println("Digite a unidade de medida (ex: Kg, Litro):");
        String unidadeMedida = Ler.umaString();

        System.out.println("Digite a quantidade medida:");
        double quantidadeMedida = Ler.umDouble();

        // Criar o produto e adicionar à lista
        Produto novoProduto = new Produto(nome, categoria, preco, stock, unidadeMedida, quantidadeMedida);
        produtos.add(novoProduto);

        System.out.println("Produto adicionado com sucesso: " + novoProduto);

        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("src/produtos.dat"));
            // escrever o objeto livros no ficheiro
            os.writeObject(produtos);
            os.flush(); // os dados são copiados de memória para o disco
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void listarProdutosCategoria (ArrayList<Produto> produtos){

        System.out.println("Digite a categoria do produto (Escolha entre as opções):");
        for (String categoria : Produto.categoriasPossiveis) {
            System.out.print(categoria + ", ");
        }
        System.out.println(); // Pula linha após mostrar as categorias

        String categoria = Ler.umaString();

        // Verificar se a categoria é válida usando um for
        boolean categoriaValida = false;
        for (String cat : Produto.categoriasPossiveis) {
            if (cat.equals(categoria)) { // Comparação case insensitive
                categoriaValida = true;
                break;
            }
        }

        if (!categoriaValida) {
            System.out.println("Categoria inválida! Produto não adicionado.");
            return;
        }

        for (Produto produto : produtos) {
            if (produto.getCategoria().equals(categoria)) {
                System.out.println(produto);
            }
        }
        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("src/produtos.dat"));
            // escrever o objeto livros no ficheiro
            os.writeObject(produtos);
            os.flush(); // os dados são copiados de memória para o disco
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
