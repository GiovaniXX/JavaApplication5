package formularios;

import classes.Dados;
import classes.Opcoes;
import classes.Produto;
import classes.Utilidades;
import java.util.Date;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class FrmFatura extends javax.swing.JInternalFrame {

    private Dados dados;
    private DefaultTableModel tableModel;

    public void setDados(Dados dados) {
        this.dados = dados;
    }

    public FrmFatura() {
        initComponents();
        this.dados = new Dados();
        //Dados dados = new Dados;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtData = new javax.swing.JTextField();
        cmbCliente = new javax.swing.JComboBox<>();
        cmbProduto = new javax.swing.JComboBox<>();
        txtQuantidadeProduto = new javax.swing.JTextField();
        btnPesquisarCliente = new javax.swing.JButton();
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
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
        });

        jLabel1.setText("Data.:");

        jLabel2.setText("Cliente.:");

        jLabel3.setText("Produto.:");

        jLabel4.setText("Quantidade.:");

        cmbCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbCliente.setEnabled(false);

        btnPesquisarCliente.setText("Pesquisar Cliente");
        btnPesquisarCliente.setEnabled(false);

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
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cmbProduto, 0, 431, Short.MAX_VALUE)
                                    .addComponent(cmbCliente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnPesquisarProduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnPesquisarCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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
                    .addComponent(jLabel2)
                    .addComponent(cmbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisarCliente))
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
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
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

        List<Produto> produtos = dados.getProdutos();
        if (produtos == null || produtos.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Não há produtos cadastrados.");
            return;
        }

        int pos = selectedIndex - 1;
        Produto produtoSelecionado = produtos.get(pos);
        String[] registro = new String[5];
        registro[0] = produtoSelecionado.getIdProduto();
        registro[1] = produtoSelecionado.getDescricao();
        registro[2] = String.valueOf(produtoSelecionado.getPreco());
        registro[3] = String.valueOf(quantidade);
        registro[4] = String.valueOf(quantidade * produtoSelecionado.getPreco());

//        // Cria um array para armazenar os dados do produto a serem adicionados na tabela
//        int pos = selectedIndex - 1;
//        String[] registro = new String[5];
//        registro[0] = dados.getProdutos()[pos].getIdProduto();
//        registro[1] = dados.getProdutos()[pos].getDescricao();
//        registro[2] = String.valueOf(dados.getProdutos()[pos].getPreco());
//        registro[3] = String.valueOf(quantidade);
//        registro[4] = String.valueOf(quantidade * dados.getProdutos()[pos].getPreco());
        // Adiciona a linha com os dados do produto à tabela
        tableModel.addRow(registro);

        totalGeral();

        cmbProduto.setSelectedIndex(0);
        txtQuantidadeProduto.setText("");
        cmbProduto.requestFocusInWindow();

        int id = evt.getID();
        System.out.println("ID do evento: " + id);
        System.out.println("Operacao realizada com sucesso!");
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        Opcoes opc = new Opcoes("ID Produto", "Selecione um produto");
        cmbProduto.addItem(opc.getDescricao());
        for (int i = 0; i < dados.numeroProdutos(); i++) {
            opc = new Opcoes(
                    dados.getProdutos().get(i).getIdProduto(),
                    dados.getProdutos().get(i).getDescricao());
            cmbProduto.addItem(opc.getDescricao());
        }

        txtData.setText(Utilidades.formatDate(new Date()));
        txtTotalQuantidade.setText("0");
        txtTotalValor.setText("0");
        preencherTabela();

        int id = evt.getID();
        System.out.println("ID do evento: " + id);
    }//GEN-LAST:event_formInternalFrameOpened

    private void btnDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarActionPerformed
        int id = evt.getID();
        System.out.println("ID do evento: " + id);
    }//GEN-LAST:event_btnDeletarActionPerformed

    private void btnSalvarVendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarVendasActionPerformed
        JOptionPane.showMessageDialog(rootPane, "Venda realizada com sucesso!");

        cmbProduto.requestFocusInWindow();

        int id = evt.getID();
        System.out.println("ID do evento: " + id);
    }//GEN-LAST:event_btnSalvarVendasActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnDeletar;
    private javax.swing.JButton btnPesquisarCliente;
    private javax.swing.JButton btnPesquisarProduto;
    private javax.swing.JButton btnSalvarVendas;
    private javax.swing.JComboBox<String> cmbCliente;
    private javax.swing.JComboBox<String> cmbProduto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
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
}
