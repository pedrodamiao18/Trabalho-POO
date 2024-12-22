import myinputs.Ler;
import java.util.ArrayList;
import java.io.*;

public class FuncProdutos {
    public static void adicionarProduto(ArrayList<Produto> produtos) {

        System.out.println("Digite a categoria do produto (Escolha entre as opções):");
        for (String categoria : Produto.categoriasPossiveis) {
            System.out.print(categoria + " ");
        }
        System.out.println();

        String categoria = Ler.umaString();

        // Verificar se a categoria é válida usando um for
        boolean categoriaValida = false;
        for (String cat : Produto.categoriasPossiveis) {
            if (cat.equals(categoria)) { // Comparação case insensitive
                categoriaValida = true;
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

    public static void apagarProduto(ArrayList<Produto> produtos) {

        // Solicita a categoria do produto
        System.out.println("Insira a categoria do produto que pretende remover!");
        for (String categoria : Produto.categoriasPossiveis) {
            System.out.print(categoria + " ");
        }
        System.out.println();

        String categoriaEscolhida = Ler.umaString();

        // Verifica se a categoria é válida
        boolean categoriaValida = false;
        for (String categoria : Produto.categoriasPossiveis) {
            if (categoria.equals(categoriaEscolhida)) {
                categoriaValida = true;
            }
        }

        if (!categoriaValida) {
            System.out.println("Categoria inválida!");
            return;
        }

        // Lista os produtos da categoria escolhida
        System.out.println("Produtos disponíveis na categoria: " + categoriaEscolhida);
        boolean produtoEncontrado = false;
        for (Produto produto : produtos) {
            if (produto.getCategoria().equals(categoriaEscolhida)) {
                System.out.println("Código: " + produto.getCod() + " - " + produto.getNome());
                produtoEncontrado = true;
            }
        }

        if (!produtoEncontrado) {
            System.out.println("Nenhum produto encontrado nessa categoria.");
            return;
        }

        // Solicita o código do produto a ser removido
        System.out.println("Insira o código do produto que deseja remover:");
        int codigoRemover = Ler.umInt();

        // Procura e remove o produto com o código fornecido
        boolean produtoARemover = false;
        for (Produto produto : produtos) {
            if (produto.getCod() == codigoRemover) {
                produtos.remove(produto);
                System.out.println("Produto removido com sucesso!");
                produtoARemover = true;
            }
        }

        if (!produtoARemover) {
            System.out.println("Nenhum produto encontrado com o código fornecido.");
        }

        // Atualiza o arquivo "produtos.dat"
        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("src/produtos.dat"));
            os.writeObject(produtos);
            os.flush();
            os.close();
        } catch (IOException e) {
            System.out.println("Erro ao atualizar o arquivo: " + e.getMessage());
        }
    }

    public static void alterarPrecoProduto(ArrayList<Produto> produtos) {
        // Solicita a categoria do produto
        System.out.println("Insira a categoria do produto cujo preço deseja alterar:");
        for (String categoria : Produto.categoriasPossiveis) {
            System.out.print(categoria + " ");
        }
        System.out.println();

        String categoriaEscolhida = Ler.umaString();

        // Verifica se a categoria é válida
        boolean categoriaValida = false;
        for (String categoria : Produto.categoriasPossiveis) {
            if (categoria.equals(categoriaEscolhida)) {
                categoriaValida = true;
            }
        }

        if (!categoriaValida) {
            System.out.println("Categoria inválida!");
            return;
        }

        // Lista os produtos da categoria escolhida
        System.out.println("Produtos disponíveis na categoria: " + categoriaEscolhida);
        boolean produtoEncontrado = false;
        for (Produto produto : produtos) {
            if (produto.getCategoria().equals(categoriaEscolhida)) {
                System.out.println("Código: " + produto.getCod() + " - Nome: " + produto.getNome() + " - Preço: " + produto.getPreco() + "€");
                produtoEncontrado = true;
            }
        }

        if (!produtoEncontrado) {
            System.out.println("Nenhum produto encontrado nessa categoria.");
            return;
        }

        // Solicita o código do produto a ser alterado
        System.out.println("Insira o código do produto que deseja alterar:");
        int codigoAlterar = Ler.umInt();

        // Procura o produto com o código fornecido
        boolean produtoAAlterar = false;
        for (Produto produto : produtos) {
            if (produto.getCod() == codigoAlterar) {
                System.out.println("Insira o novo preço para o produto " + produto.getNome() + ":");
                double novoPreco = Ler.umDouble();
                produto.setPreco(novoPreco);
                System.out.println("Preço atualizado com sucesso! Novo preço de " + produto.getNome() + ": " + produto.getPreco() + "€");
                produtoAAlterar = true;
            }
        }

        if (!produtoAAlterar) {
            System.out.println("Nenhum produto encontrado com o código fornecido.");
        }

        // Atualiza o arquivo "produtos.dat"
        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("src/produtos.dat"));
            os.writeObject(produtos);
            os.flush();
            os.close();
        } catch (IOException e) {
            System.out.println("Erro ao atualizar o arquivo: " + e.getMessage());
        }
    }


    public static void listarProdutosCategoria (ArrayList<Produto> produtos) {

        System.out.println("Digite a categoria do produto (Escolha entre as opções):");
        for (String categoria : Produto.categoriasPossiveis) {
            System.out.print(categoria + " ");
        }
        System.out.println(); // Pula linha após mostrar as categorias

        String categoria = Ler.umaString();

        // Verificar se a categoria é válida usando um for
        boolean categoriaValida = false;
        for (String cat : Produto.categoriasPossiveis) {
            if (cat.equals(categoria)) { // Comparação case insensitive
                categoriaValida = true;

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
            os.writeObject(produtos);
            os.flush();
            os.close();
        } catch (IOException e) {
            System.out.println("Erro ao atualizar o arquivo: " + e.getMessage());
        }
    }
    
    public static ArrayList<Produto> lerProdutosDoArquivo() {
        ArrayList<Produto> produtos = new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("produtos.dat"))) {
            while (true) {
                try {
                    Produto produto = (Produto) ois.readObject();
                    produtos.add(produto);
                } catch (EOFException e) {
                    // Fim do arquivo
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return produtos;
    }

}
