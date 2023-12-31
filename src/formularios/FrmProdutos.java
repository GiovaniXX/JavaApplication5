package formularios;

import classes.Database;
import classes.Produto;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class FrmProdutos extends javax.swing.JInternalFrame {

    private Database dados;
    private final int proAtual = 0;
    private boolean novo = false;
    private DefaultTableModel tableModel;
    private double preco;

    public void setDatabase(Database dados) {
        this.dados = dados;
    }

    public FrmProdutos() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtProduto = new javax.swing.JTextField();
        txtDescricao = new javax.swing.JTextField();
        txtPreco = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtaAnotacao = new javax.swing.JTextArea();
        btnNovo = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblProdutos = new javax.swing.JTable();
        btnDeletar = new javax.swing.JButton();

        setClosable(true);
        setTitle("Cadastro de Produtos.:");

        jLabel1.setText("ID Produto.:");

        jLabel2.setText("Descrição.:");

        jLabel3.setText("Preço.:");

        jLabel5.setText("Anotação.:");

        txtProduto.setEnabled(false);

        txtDescricao.setEnabled(false);

        txtPreco.setEnabled(false);

        jtaAnotacao.setColumns(20);
        jtaAnotacao.setRows(5);
        jtaAnotacao.setEnabled(false);
        jScrollPane1.setViewportView(jtaAnotacao);

        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnSalvar.setText("Salvar");
        btnSalvar.setEnabled(false);
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        tblProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tblProdutos);

        btnDeletar.setText("Deletar");
        btnDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtDescricao))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(39, 39, 39)
                                    .addComponent(txtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(747, 747, 747))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addGap(18, 18, 18)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 811, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(112, 112, 112))
            .addGroup(layout.createSequentialGroup()
                .addGap(353, 353, 353)
                .addComponent(btnSalvar)
                .addGap(18, 18, 18)
                .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnDeletar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(btnNovo)
                    .addComponent(btnDeletar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        txtDescricao.setEnabled(true);
        txtPreco.setEnabled(true);
        jtaAnotacao.setEnabled(true);
        btnSalvar.setEnabled(true);

        novo = true;
        txtDescricao.requestFocus();

        int id = evt.getID();
        System.out.println("ID do evento: " + id);
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if (txtProduto.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Favor inserir um número de ID");
            txtProduto.requestFocusInWindow();
            return;
        }

        if (txtDescricao.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Favor digitar uma descrição");
            txtDescricao.requestFocusInWindow();
            return;
        }

        if (txtPreco.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Favor digitar o preço");
            txtPreco.requestFocusInWindow();
            return;
        }

        try {
            double preco = Double.parseDouble(txtPreco.getText());
            if (preco <= 0) {
                JOptionPane.showMessageDialog(rootPane, "Favor digitar um número acima de zero");
                txtPreco.requestFocusInWindow();
                return;
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(rootPane, "Favor digitar um valor numérico válido");
            txtPreco.requestFocusInWindow();
            return;
        }

        int pos = dados.posicaoProduto(txtProduto.getText());

        if (pos != -1) {
            JOptionPane.showMessageDialog(rootPane, "Este produto já existe");
            txtProduto.requestFocusInWindow();
            return;
        }

        Produto produto = new Produto(txtProduto.getText(), txtDescricao.getText(), txtPreco, jtaAnotacao.getText());
        String msg = dados.adicionarProduto(produto);
        JOptionPane.showMessageDialog(rootPane, msg);

        btnNovo.setEnabled(true);
        btnSalvar.setEnabled(false);

        txtProduto.setEnabled(false);
        txtDescricao.setEnabled(false);
        txtPreco.setEnabled(false);
        jtaAnotacao.setEnabled(false);

        preencherTabela();
        mostrarRegistro();

        int id = evt.getID();
        System.out.println("ID do evento: " + id);
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarActionPerformed

        int id = evt.getID();
        System.out.println("ID do evento: " + id);
    }//GEN-LAST:event_btnDeletarActionPerformed

    private void mostrarRegistro() {
        List<Produto> produtos = (List<Produto>) dados.getProdutos();
        if (proAtual >= 0 && proAtual < produtos.size()) {
            Produto produto = produtos.get(proAtual);
            txtProduto.setText(String.valueOf(produto.getProduto()));
            txtDescricao.setText(produto.getDescricao());
            txtPreco.setText(String.valueOf(produto.getPreco()));
            jtaAnotacao.setText(produto.getAnotacao());
        } else {
            JOptionPane.showMessageDialog(rootPane, "Produto não encontrado!");
            JOptionPane.showMessageDialog(rootPane, "Cadastre um produto!");
        }
    }

    private void preencherTabela() {
        String titulos[] = {"ID Produto", "Descrição", "Preço", "Quantidade", "Valor"};
        String registro[] = new String[5];
        tableModel = new DefaultTableModel(null, titulos);
        tblProdutos.setModel(tableModel);
        tableModel.addRow(registro);

        // Centraliza o conteúdo em cada coluna
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int i = 0; i < tblProdutos.getColumnCount(); i++) {
            tblProdutos.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDeletar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jtaAnotacao;
    private javax.swing.JTable tblProdutos;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JTextField txtPreco;
    private javax.swing.JTextField txtProduto;
    // End of variables declaration//GEN-END:variables
}
