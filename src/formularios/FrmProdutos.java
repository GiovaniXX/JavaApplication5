package formularios;

import classes.Dados;
import classes.Produto;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class FrmProdutos extends javax.swing.JInternalFrame {

    private Dados dados;
    private final int proAtual = 0;
    private boolean novo = false;
    private DefaultTableModel mTabela;
    private double preco;

    public void setDados(Dados dados) {
        this.dados = dados;
    }

    public FrmProdutos() {
        initComponents();
        cmbImposto.addItem("0%");
        cmbImposto.addItem("5%");
        cmbImposto.addItem("10%");
        cmbImposto.addItem("15%");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtIdProduto = new javax.swing.JTextField();
        txtDescricao = new javax.swing.JTextField();
        txtPreco = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAnotacao = new javax.swing.JTextArea();
        cmbImposto = new javax.swing.JComboBox<>();
        btnNovo = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblProdutos = new javax.swing.JTable();

        setClosable(true);
        setTitle("Cadastro de Produtos.:");
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

        jLabel1.setText("Id Produto.:");

        jLabel2.setText("Descrição.:");

        jLabel3.setText("Preço.:");

        jLabel4.setText("Imposto.:");

        jLabel5.setText("Anotação.:");

        txtIdProduto.setEnabled(false);

        txtDescricao.setEnabled(false);

        txtPreco.setEnabled(false);

        txtAnotacao.setColumns(20);
        txtAnotacao.setRows(5);
        jScrollPane1.setViewportView(txtAnotacao);

        cmbImposto.setEnabled(false);

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(39, 39, 39)
                                        .addComponent(txtPreco))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtDescricao)))
                                .addGap(12, 12, 12)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmbImposto, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtIdProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 811, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(321, 321, 321)
                                            .addComponent(btnSalvar)
                                            .addGap(18, 18, 18)
                                            .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGap(112, 112, 112))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtIdProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(cmbImposto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(btnNovo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 578, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        btnNovo.setEnabled(false);
        btnSalvar.setEnabled(true);

        txtIdProduto.setEnabled(true);
        txtDescricao.setEnabled(true);
        txtPreco.setEnabled(true);
        txtAnotacao.setEnabled(true);
        cmbImposto.setEnabled(true);

        txtIdProduto.setText("");
        txtDescricao.setText("");
        txtPreco.setText("");
        txtAnotacao.setText("");
        cmbImposto.setSelectedIndex(0);

        novo = true;
        txtIdProduto.requestFocus();

        int id = evt.getID();
        System.out.println("ID do evento: " + id);
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if (txtIdProduto.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Favor inserir um número de ID");
            txtIdProduto.requestFocusInWindow();
            return;
        }

        if (cmbImposto.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Favor selecionar um valor");
            cmbImposto.requestFocusInWindow();
            return;
        }

        if (txtPreco.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Favor digitar o preço");
            txtPreco.requestFocusInWindow();
            return;
        }

        try {
            preco = Double.parseDouble(txtPreco.getText());
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

        if (txtDescricao.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Favor digitar uma descrição");
            txtDescricao.requestFocusInWindow();
            return;
        }

        int pos = dados.posicaoProduto(txtIdProduto.getText());

        if (pos != -1) {
            JOptionPane.showMessageDialog(rootPane, "Este produto já existe");
            txtIdProduto.requestFocusInWindow();
            return;
        }

        Produto mProduto = new Produto(txtIdProduto.getText(), txtDescricao.getText(), preco, cmbImposto.getSelectedIndex(), txtAnotacao.getText());
        String msg = dados.adicionarProduto(mProduto);
        JOptionPane.showMessageDialog(rootPane, msg);

        btnNovo.setEnabled(true);
        btnSalvar.setEnabled(false);

        txtIdProduto.setEnabled(false);
        txtDescricao.setEnabled(false);
        txtPreco.setEnabled(false);
        cmbImposto.setEnabled(false);
        txtAnotacao.setEnabled(false);

        preencherTabela();

        int id = evt.getID();
        System.out.println("ID do evento: " + id);
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        mostrarRegistro();
        preencherTabela();

        int id = evt.getID();
        System.out.println("ID do evento: " + id);
    }//GEN-LAST:event_formInternalFrameOpened

    private void mostrarRegistro() {
        Produto produto = dados.getProdutos()[proAtual];
        if (produto != null) {
            txtIdProduto.setText(dados.getProdutos()[proAtual].getIdProduto());
            txtDescricao.setText(dados.getProdutos()[proAtual].getDescricao());
            txtPreco.setText(String.valueOf(dados.getProdutos()[proAtual].getPreco()));
            cmbImposto.setSelectedIndex(dados.getProdutos()[proAtual].getImposto());
            txtAnotacao.setText(dados.getProdutos()[proAtual].getAnotacao());
        } else {
            JOptionPane.showMessageDialog(rootPane, "Produto não encontrado!");
            JOptionPane.showMessageDialog(rootPane, "Cadastre um produto!");

        }
    }

    private void preencherTabela() {
        String titulos[] = {"ID Produto", "Descrição", "Preço", "Imposto", "Anotação"};
        String registro[] = new String[5];
        mTabela = new DefaultTableModel(null, titulos);
        for (int i = 0; i < dados.numeroProdutos(); i++) {
            registro[0] = dados.getProdutos()[i].getIdProduto();
            registro[1] = dados.getProdutos()[i].getDescricao();
            registro[2] = String.valueOf(dados.getProdutos()[i].getPreco());
            registro[3] = imposto(dados.getProdutos()[i].getImposto());
            registro[4] = dados.getProdutos()[i].getAnotacao();
            mTabela.addRow(registro);
        }
        tblProdutos.setModel(mTabela);

        // Centraliza o conteúdo em cada coluna
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int i = 0; i < tblProdutos.getColumnCount(); i++) {
            tblProdutos.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }

    private String imposto(int idImposto) {
        return switch (idImposto) {
            case 0 ->
                "0%";
            case 1 ->
                "5%";
            case 2 ->
                "10%";
            case 3 ->
                "15%";
            default ->
                "Não definido";
        };
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> cmbImposto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblProdutos;
    private javax.swing.JTextArea txtAnotacao;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JTextField txtIdProduto;
    private javax.swing.JTextField txtPreco;
    // End of variables declaration//GEN-END:variables
}
