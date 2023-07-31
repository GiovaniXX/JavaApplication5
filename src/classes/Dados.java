package classes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public final class Dados {

    private final int maxPro = 50;
    private final Produto msProdutos[] = new Produto[maxPro];
    private int conPro = 0;

    public Dados() {
//        criarDiretorio("Data");
        preencherProdutos();
    }

//    public static void criarDiretorio(String Data) {
//        File diretorio = new File(Data);
//        if (!diretorio.exists()) {
//            diretorio.mkdirs();
//        }
//    }
    public int numeroProdutos() {
        return conPro;
    }

    public Produto[] getProdutos() {
        return msProdutos;
    }

    public int posicaoProduto(String produto) {
        for (int i = 0; i < conPro; i++) {
            if (msProdutos[i].getIdProduto().equals(produto)) {
                return i;
            }
        }
        return -1;
    }

    public String adicionarProduto(Produto mProduto) {
        if (conPro == maxPro) {
            return "Não é possível cadastrar mais produtos";
        }
        msProdutos[conPro] = mProduto;
        conPro++;
        return "Produto cadastrado com sucesso";
    }

    public void salvarTodo() {
        salvarProdutos();
    }

    public void salvarProdutos() {
        FileWriter fw = null;
        PrintWriter pw = null;
        try {
            fw = new FileWriter("Data/produtos.txt");
            pw = new PrintWriter(fw);

            for (int i = 0; i < conPro; i++) {
                pw.println(msProdutos[i].toString());
            }

            System.out.println("Produtos salvos com sucesso!");
        } catch (IOException e1) {
            e1.printStackTrace();
        } finally {
            try {
                if (fw != null) {
                    fw.close();
                }
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void preencherProdutos() {
        File arquivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            arquivo = new File("Data/produtos.txt");
            fr = new FileReader(arquivo);
            br = new BufferedReader(fr);

            int pos;
            String aux;
            String linha;
            String idProduto;
            String descricao;
            double preco;
            int imposto;
            String anotacao;

            while ((linha = br.readLine()) != null) {
                pos = linha.indexOf("|");
                aux = linha.substring(0, pos);
                idProduto = aux;
                linha = linha.substring(pos + 1);

                pos = linha.indexOf("|");
                aux = linha.substring(0, pos);
                descricao = aux;
                linha = linha.substring(pos + 1);

                pos = linha.indexOf("|");
                aux = linha.substring(0, pos);
                preco = Double.parseDouble(aux);
                linha = linha.substring(pos + 1);

                pos = linha.indexOf("|");
                aux = linha.substring(0, pos);
                imposto = Integer.parseInt(aux);
                linha = linha.substring(pos + 1);

                anotacao = linha;

                Produto mProduto = new Produto(idProduto, descricao, preco, imposto, anotacao);
                msProdutos[conPro] = mProduto;
                conPro++;
            }
        } catch (IOException | NumberFormatException e1) {
            e1.printStackTrace();
        } finally {
            try {
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }
}
