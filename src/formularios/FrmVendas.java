package formularios;

import classes.Database;
import classes.Produto;
import classes.Utilidades;
import java.util.Date;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class FrmVendas extends javax.swing.JInternalFrame {

    private Database dados;
    private DefaultTableModel tableModel;

    public void setDatabase(Database dados) {
        this.dados = dados;
    }

    public FrmVendas() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtData = new javax.swing.JTextField();
        cmbProduto = new javax.swing.JComboBox<>();
        txtQuantidadeProduto = new javax.swing.JTextField();
        btnPesquisarProduto = new javax.swing.JButton();
        btnAdicionar = new javax.swing.JButton();
        btnDeletar = new javax.swing.JButton();
        btnSalvarVendas = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVendas = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        txtTotalQuantidade = new javax.swing.JTextField();
        txtTotalValor = new javax.swing.JTextField();

        setClosable(true);
        setTitle("Formularios de Vendas.:");

        jLabel1.setText("Data.:");

        jLabel3.setText("Produto.:");

        jLabel4.setText("Quantidade.:");

        btnPesquisarProduto.setText("Pesquisar Produto");

        btnAdicionar.setText("Adicionar");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        btnDeletar.setText("Deletar");
        btnDeletar.setEnabled(false);
        btnDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletarActionPerformed(evt);
            }
        });

        btnSalvarVendas.setText("Salvar Venda");
        btnSalvarVendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarVendasActionPerformed(evt);
            }
        });

        tblVendas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title5"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblVendas);

        jLabel5.setText("Total.:");

        txtTotalQuantidade.setEnabled(false);

        txtTotalValor.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 918, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cmbProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnPesquisarProduto))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtQuantidadeProduto, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnAdicionar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addComponent(btnDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSalvarVendas)))
                        .addGap(0, 257, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(txtTotalQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtTotalValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cmbProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisarProduto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtQuantidadeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdicionar)
                    .addComponent(btnSalvarVendas)
                    .addComponent(btnDeletar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtTotalQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTotalValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        int selectedIndex = cmbProduto.getSelectedIndex();
        if (cmbProduto.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Favor selecionar um produto");
            cmbProduto.requestFocusInWindow();
            return;
        }

        if (txtQuantidadeProduto.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Favor entrar com uma quantidade");
            txtQuantidadeProduto.requestFocusInWindow();
            return;
        }

        if (!Utilidades.isNumeric(txtQuantidadeProduto.getText())) {
            JOptionPane.showMessageDialog(rootPane, "Favor digitar somente números");
            txtQuantidadeProduto.setText("");
            txtQuantidadeProduto.requestFocusInWindow();
            return;
        }

        int quantidade = Integer.parseInt(txtQuantidadeProduto.getText());
        if (quantidade <= 0) {
            JOptionPane.showMessageDialog(rootPane, "Favor entrar com número positivo acima de zero");
            txtQuantidadeProduto.setText("");
            txtQuantidadeProduto.requestFocusInWindow();
            return;
        }

        List<Produto> produtos = (List<Produto>) dados.getProdutos();
        if (produtos == null || produtos.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Não há produtos cadastrados.");
            JOptionPane.showMessageDialog(rootPane, "Cadastre um produto.");
            return;
        }

        // Cria um array para armazenar os dados do produto a serem adicionados na tabela
        int pos = selectedIndex - 1;
        String[] registro = new String[7];
        registro[0] = dados.getProdutos().get(pos).getVenda();
        registro[1] = dados.getProdutos().get(pos).getProduto();
        registro[2] = dados.getProdutos().get(pos).getDataAtual();
        registro[3] = dados.getProdutos().get(pos).getDescricao();
        registro[4] = String.valueOf(dados.getProdutos().get(pos).getPreco());
        registro[5] = String.valueOf(quantidade);
        registro[6] = String.valueOf(valor);
        registro[7] = String.valueOf(quantidade * dados.getProdutos().get(pos).getPreco());

        //Adiciona a linha com os dados do produto à tabela
        tableModel.addRow(registro);

        totalGeral();

        cmbProduto.setSelectedIndex(0);
        txtQuantidadeProduto.setText("");
        cmbProduto.requestFocusInWindow();

        tblVendas.setModel(tableModel);
        preencherTabela();

        int id = evt.getID();
        System.out.println("ID do evento: " + id);
        System.out.println("Operacao realizada com sucesso!");
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void btnDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarActionPerformed
        int id = evt.getID();
        System.out.println("ID do evento: " + id);
    }//GEN-LAST:event_btnDeletarActionPerformed

    private void btnSalvarVendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarVendasActionPerformed
        int totalQtde = Utilidades.objectToInt(txtTotalQuantidade.getText());
        if (totalQtde == 0) {
            JOptionPane.showMessageDialog(rootPane, "Insira dados para uma venda!");
            cmbProduto.requestFocusInWindow();
            return;
        }

        int resposta = JOptionPane.showConfirmDialog(rootPane, "Deseja efetuar esta venda?");
        if (resposta != 0) {
            return;
        }

        int numVenda = dados.getNumeroVenda();

        int num = tblVendas.getRowCount();
        for (int i = 0; i < num; i++) {
            dados.adicionarDetalheVendas(numVenda, i,
                    Utilidades.objectToString(tblVendas.getValueAt(i, 0)),
                    Utilidades.objectToString(tblVendas.getValueAt(i, 1)),
                    Utilidades.objectToInt(tblVendas.getValueAt(i, 2)),
                    Utilidades.objectToInt(tblVendas.getValueAt(i, 3)));
        }

        JOptionPane.showMessageDialog(rootPane, "Venda:" + numVenda + "Venda realizada com sucesso");
        cmbProduto.setSelectedIndex(0);
        limparTabela();
        totalGeral();
        cmbProduto.requestFocusInWindow();

        int id = evt.getID();
        System.out.println("ID do evento: " + id);
    }//GEN-LAST:event_btnSalvarVendasActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnDeletar;
    private javax.swing.JButton btnPesquisarProduto;
    private javax.swing.JButton btnSalvarVendas;
    private javax.swing.JComboBox<String> cmbProduto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblVendas;
    private javax.swing.JTextField txtData;
    private javax.swing.JTextField txtQuantidadeProduto;
    private javax.swing.JTextField txtTotalQuantidade;
    private javax.swing.JTextField txtTotalValor;
    // End of variables declaration//GEN-END:variables

    private void preencherTabela() {
        String titulos[] = {"ID Produto", "Descrição", "Preço", "Quantidade", "Valor"};
        String registro[] = new String[5];
        tableModel = new DefaultTableModel(null, titulos);
        tblVendas.setModel(tableModel);
        tableModel.addRow(registro);

        // Centraliza o conteúdo em cada coluna
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int i = 0; i < tblVendas.getColumnCount(); i++) {
            tblVendas.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }

    private void totalGeral() {
        // Inicializar variáveis para calcular o total de quantidade e valor
        int totalQuantidade = 0;
        int totalValor = 0;

        // Percorrer todas as linhas da tabela para calcular a soma dos valores dos produtos
        int rowCount = tblVendas.getRowCount();
        for (int i = 0; i < rowCount; i++) {
            // Obter a quantidade e o valor do produto na linha atual da tabela
            int quantidadeProduto = Utilidades.objectToInt(tblVendas.getValueAt(i, 3));
            double valorProduto = Utilidades.objectToDouble(tblVendas.getValueAt(i, 4));

            // Somar a quantidade e o valor do produto aos totais
            totalQuantidade += quantidadeProduto;
            totalValor += valorProduto;
        }

        // Atualizar os campos txtTotalQuantidade e txtTotalValor com os valores totais calculados
        txtTotalQuantidade.setText(String.valueOf(totalQuantidade));
        txtTotalValor.setText(String.valueOf(totalValor));
    }

    public void limparTabela() {
        try {
            DefaultTableModel modelo = (DefaultTableModel) tblVendas.getModel();
            int Linha = tblVendas.getRowCount();
            for (int i = 0; Linha > i; i++) {
                modelo.removeRow(0);
            }
        } catch (Exception e) {
        }
    }
}
