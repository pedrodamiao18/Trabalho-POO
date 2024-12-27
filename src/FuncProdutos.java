import myinputs.Ler;
import java.util.ArrayList;
import java.io.*;

public class FuncProdutos {

    private static Produto encontrarProdutoPorCodigo(ArrayList<Produto> produtos, int codigo) throws ProdutoNaoEncontradoException {
        for (Produto produto : produtos) {
            if (produto.getCod() == codigo) {
                return produto;
            }
        }
        throw new ProdutoNaoEncontradoException("Produto com o código " + codigo + " não encontrado.");
    }

    public static void atualizarArquivo(ArrayList<Produto> produtos) {
        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("src/produtos.dat"));
            os.writeObject(produtos);
            os.flush();
            os.close();
        } catch (IOException e) {
            System.out.println("Erro ao atualizar o arquivo: " + e.getMessage());
        }
    }

    // Método para adicionar produto
    public static void adicionarProduto(ArrayList<Produto> produtos) {
        try {
            System.out.println("Digite a categoria do produto (Escolha entre as opções):");
            for (String categoria : Produto.categoriasPossiveis) {
                System.out.print(categoria + " ");
            }
            System.out.println();

            String categoria = Ler.umaString();
            verificarCategoria(categoria);

            System.out.println("Digite o nome do produto:");
            String nome = Ler.umaString();

            System.out.println("Digite o preço do produto:");
            double preco = Ler.umDouble();
            if (preco <= 0) {
                throw new QuantidadeInvalidaException("Preço deve ser maior que zero.");
            }

            System.out.println("Digite o stock do produto:");
            int stock = Ler.umInt();
            if (stock < 0) {
                throw new QuantidadeInvalidaException("Stock não pode ser negativo.");
            }

            System.out.println("Digite a unidade de medida (ex: Kg, Litro):");
            String unidadeMedida = Ler.umaString();

            System.out.println("Digite a quantidade medida:");
            double quantidadeMedida = Ler.umDouble();
            if (quantidadeMedida <= 0) {
                throw new QuantidadeInvalidaException("Quantidade medida deve ser maior que zero.");
            }

            Produto novoProduto = new Produto(nome, categoria, preco, stock, unidadeMedida, quantidadeMedida);
            produtos.add(novoProduto);
            System.out.println("Produto adicionado com sucesso: " + novoProduto);

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
        atualizarArquivo(produtos);
    }

    // Método para apagar produto
    public static void apagarProduto(ArrayList<Produto> produtos) {
        try {
            System.out.println("Digite a categoria do produto para remover:");
            for (String categoria : Produto.categoriasPossiveis) {
                System.out.print(categoria + " ");
            }
            System.out.println();

            String categoriaEscolhida = Ler.umaString();
            verificarCategoria(categoriaEscolhida);

            System.out.println("Digite o código do produto a remover:");
            int codigo = Ler.umInt();

            Produto produtoRemover = encontrarProdutoPorCodigo(produtos, codigo);
            produtos.remove(produtoRemover);
            System.out.println("Produto removido com sucesso!");

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
        atualizarArquivo(produtos);
    }

    // Método para alterar preço
    public static void alterarPrecoProduto(ArrayList<Produto> produtos) {
        try {
            System.out.println("Digite a categoria do produto:");
            for (String categoria : Produto.categoriasPossiveis) {
                System.out.print(categoria + " ");
            }
            System.out.println();

            String categoriaEscolhida = Ler.umaString();
            verificarCategoria(categoriaEscolhida);

            System.out.println("Digite o código do produto para alterar o preço:");
            int codigo = Ler.umInt();

            Produto produto = encontrarProdutoPorCodigo(produtos, codigo);

            System.out.println("Digite o novo preço:");
            double novoPreco = Ler.umDouble();
            if (novoPreco <= 0) {
                throw new QuantidadeInvalidaException("O preço deve ser maior que zero.");
            }

            produto.setPreco(novoPreco);
            System.out.println("Preço alterado com sucesso para o produto: " + produto.getNome());

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
        atualizarArquivo(produtos);
    }

    // Método para listar produtos por categoria
    public static void listarProdutosCategoria(ArrayList<Produto> produtos) {
        try {
            System.out.println("Digite a categoria do produto:");
            for (String categoria : Produto.categoriasPossiveis) {
                System.out.print(categoria + " ");
            }
            System.out.println();

            String categoriaEscolhida = Ler.umaString();
            verificarCategoria(categoriaEscolhida);

            System.out.println("Produtos na categoria " + categoriaEscolhida + ":");
            boolean produtoEncontrado = false;
            for (Produto produto : produtos) {
                if (produto.getCategoria().equalsIgnoreCase(categoriaEscolhida)) {
                    System.out.println(produto);
                    produtoEncontrado = true;
                }
            }

            if (!produtoEncontrado) {
                throw new ProdutoNaoEncontradoException("Nenhum produto encontrado nesta categoria.");
            }

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    // Método para adicionar stock
    public static void adicionarStock(ArrayList<Produto> produtos) {
        try {
            System.out.println("Digite a categoria do produto:");
            for (String categoria : Produto.categoriasPossiveis) {
                System.out.print(categoria + " ");
            }
            System.out.println();

            String categoriaEscolhida = Ler.umaString();
            verificarCategoria(categoriaEscolhida);

            System.out.println("Digite o código do produto para adicionar stock:");
            int codigo = Ler.umInt();

            Produto produto = encontrarProdutoPorCodigo(produtos, codigo);

            System.out.println("Digite a quantidade de stock a adicionar:");
            int quantidade = Ler.umInt();
            if (quantidade <= 0) {
                throw new QuantidadeInvalidaException("A quantidade deve ser maior que zero.");
            }

            produto.setStock(produto.getStock() + quantidade);
            System.out.println("Stock atualizado com sucesso!");

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
        atualizarArquivo(produtos);
    }

    // Métodos auxiliares
    private static void verificarCategoria(String categoria) throws CategoriaInvalidaException {
        boolean categoriaValida = false;
        for (String cat : Produto.categoriasPossiveis) {
            if (cat.equalsIgnoreCase(categoria)) {
                categoriaValida = true;
                break;
            }
        }
        if (!categoriaValida) {
            throw new CategoriaInvalidaException("Categoria inválida!");
        }
    }

    public static ArrayList<Produto> lerProdutosDoArquivo() {
        ArrayList<Produto> produtos = new ArrayList<>();
        // Ler ficheiro
        try {
            ObjectInputStream is = new ObjectInputStream( new FileInputStream("src/produtos.dat"));
            produtos = (ArrayList<Produto>) is.readObject();
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
        catch ( ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return produtos;
    }

}
