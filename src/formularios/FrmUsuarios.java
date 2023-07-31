package formularios;

import com.formdev.flatlaf.IntelliJTheme;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import classes.Dados;
import classes.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import classes.Utilidades;

public class FrmUsuarios extends javax.swing.JInternalFrame {

    private Dados dados;
    private int usuAtual = 0;
    private boolean novo = false;
    private DefaultTableModel mTabela;

    private String ID;
    private String Nome;
    private String SNome;

    public void setDados(Dados dados) {
        this.dados = dados;
    }

    public FrmUsuarios() {
        initComponents();
        jpfSenha.setEnabled(false);
        jpfConfirmarSenha.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        txtIDUsuario = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cmbPerfil = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtSNome = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jpfSenha = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        jpfConfirmarSenha = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        btnPrimeiro = new javax.swing.JButton();
        btnAnterior = new javax.swing.JButton();
        btnProximo = new javax.swing.JButton();
        btnUltimo = new javax.swing.JButton();
        btnNovo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnPesquisar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtTabela = new javax.swing.JTable();

        jLabel2.setForeground(new java.awt.Color(3, 155, 216));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("ID Usuario.:");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        txtIDUsuario.setBackground(new java.awt.Color(30, 30, 30));
        txtIDUsuario.setForeground(new java.awt.Color(2, 154, 184));
        txtIDUsuario.setBorder(null);
        txtIDUsuario.setCaretColor(new java.awt.Color(255, 255, 255));
        txtIDUsuario.setDisabledTextColor(new java.awt.Color(174, 146, 144));
        txtIDUsuario.setEnabled(false);
        txtIDUsuario.setPreferredSize(new java.awt.Dimension(71, 22));

        jLabel7.setForeground(new java.awt.Color(3, 155, 216));
        jLabel7.setText("Perfil.:");

        cmbPerfil.setBackground(new java.awt.Color(122, 126, 140));
        cmbPerfil.setForeground(new java.awt.Color(255, 255, 255));
        cmbPerfil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione um Perfil", "Admin", "Usuario" }));
        cmbPerfil.setEnabled(false);

        jLabel3.setForeground(new java.awt.Color(3, 155, 216));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Nome.:");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        txtNome.setBackground(new java.awt.Color(30, 30, 30));
        txtNome.setForeground(new java.awt.Color(2, 154, 184));
        txtNome.setBorder(null);
        txtNome.setCaretColor(new java.awt.Color(255, 255, 255));
        txtNome.setDisabledTextColor(new java.awt.Color(174, 146, 144));
        txtNome.setEnabled(false);
        txtNome.setPreferredSize(new java.awt.Dimension(71, 22));

        jLabel4.setForeground(new java.awt.Color(3, 155, 216));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("S_Nome.:");

        txtSNome.setBackground(new java.awt.Color(30, 30, 30));
        txtSNome.setForeground(new java.awt.Color(2, 154, 184));
        txtSNome.setBorder(null);
        txtSNome.setCaretColor(new java.awt.Color(255, 255, 255));
        txtSNome.setDisabledTextColor(new java.awt.Color(174, 146, 144));
        txtSNome.setEnabled(false);
        txtSNome.setPreferredSize(new java.awt.Dimension(71, 22));

        jLabel5.setForeground(new java.awt.Color(3, 155, 216));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Senha.:");

        jpfSenha.setBackground(new java.awt.Color(30, 30, 30));
        jpfSenha.setForeground(new java.awt.Color(2, 154, 184));
        jpfSenha.setBorder(null);
        jpfSenha.setPreferredSize(new java.awt.Dimension(71, 22));

        jLabel6.setForeground(new java.awt.Color(3, 155, 216));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Conf Senha.:");

        jpfConfirmarSenha.setBackground(new java.awt.Color(30, 30, 30));
        jpfConfirmarSenha.setForeground(new java.awt.Color(2, 154, 184));
        jpfConfirmarSenha.setBorder(null);
        jpfConfirmarSenha.setPreferredSize(new java.awt.Dimension(71, 22));

        jLabel1.setForeground(new java.awt.Color(3, 155, 216));
        jLabel1.setText("Conf Chave.:");

        jPasswordField1.setBackground(new java.awt.Color(30, 30, 30));

        btnPrimeiro.setBackground(new java.awt.Color(0, 0, 0));
        btnPrimeiro.setForeground(new java.awt.Color(3, 155, 216));
        btnPrimeiro.setText("Primeiro");
        btnPrimeiro.setBorder(null);
        btnPrimeiro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPrimeiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrimeiroActionPerformed(evt);
            }
        });

        btnAnterior.setBackground(new java.awt.Color(0, 0, 0));
        btnAnterior.setForeground(new java.awt.Color(3, 155, 216));
        btnAnterior.setText("Anterior");
        btnAnterior.setBorder(null);
        btnAnterior.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnteriorActionPerformed(evt);
            }
        });

        btnProximo.setBackground(new java.awt.Color(0, 0, 0));
        btnProximo.setForeground(new java.awt.Color(3, 155, 216));
        btnProximo.setText("Proximo");
        btnProximo.setBorder(null);
        btnProximo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnProximo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProximoActionPerformed(evt);
            }
        });

        btnUltimo.setBackground(new java.awt.Color(0, 0, 0));
        btnUltimo.setForeground(new java.awt.Color(3, 155, 216));
        btnUltimo.setText("Ultimo");
        btnUltimo.setBorder(null);
        btnUltimo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUltimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUltimoActionPerformed(evt);
            }
        });

        btnNovo.setBackground(new java.awt.Color(0, 0, 0));
        btnNovo.setForeground(new java.awt.Color(3, 155, 216));
        btnNovo.setText("Novo");
        btnNovo.setBorder(null);
        btnNovo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnEditar.setBackground(new java.awt.Color(0, 0, 0));
        btnEditar.setForeground(new java.awt.Color(3, 155, 216));
        btnEditar.setText("Editar");
        btnEditar.setBorder(null);
        btnEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnSalvar.setBackground(new java.awt.Color(0, 0, 0));
        btnSalvar.setForeground(new java.awt.Color(3, 155, 216));
        btnSalvar.setText("Salvar");
        btnSalvar.setBorder(null);
        btnSalvar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalvar.setEnabled(false);
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnExcluir.setBackground(new java.awt.Color(0, 0, 0));
        btnExcluir.setForeground(new java.awt.Color(3, 155, 216));
        btnExcluir.setText("Excluir");
        btnExcluir.setBorder(null);
        btnExcluir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnCancelar.setBackground(new java.awt.Color(0, 0, 0));
        btnCancelar.setForeground(new java.awt.Color(3, 155, 216));
        btnCancelar.setText("Cancelar");
        btnCancelar.setBorder(null);
        btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnPesquisar.setBackground(new java.awt.Color(0, 0, 0));
        btnPesquisar.setForeground(new java.awt.Color(3, 155, 216));
        btnPesquisar.setText("Pesquisar");
        btnPesquisar.setBorder(null);
        btnPesquisar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        jtTabela.setBackground(new java.awt.Color(0, 0, 0));
        jtTabela.setForeground(new java.awt.Color(3, 155, 216));
        jtTabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Usuario", "Nome", "S_Nome", "Perfil"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtTabela.setGridColor(new java.awt.Color(0, 0, 0));
        jtTabela.setSelectionBackground(new java.awt.Color(122, 126, 140));
        jtTabela.setSelectionForeground(new java.awt.Color(3, 155, 216));
        jtTabela.setShowGrid(false);
        jScrollPane1.setViewportView(jtTabela);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1350, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(427, 427, 427)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)
                            .addComponent(txtIDUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(70, 70, 70)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 0)
                            .addComponent(cmbPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(427, 427, 427)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(427, 427, 427)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)
                            .addComponent(txtSNome, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(427, 427, 427)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)
                            .addComponent(jpfSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(407, 407, 407)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)
                            .addComponent(jpfConfirmarSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(427, 427, 427)
                            .addComponent(jLabel1)
                            .addGap(12, 12, 12)
                            .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(507, 507, 507)
                            .addComponent(btnPrimeiro, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(7, 7, 7)
                            .addComponent(btnAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(7, 7, 7)
                            .addComponent(btnProximo, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(7, 7, 7)
                            .addComponent(btnUltimo, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(507, 507, 507)
                            .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(7, 7, 7)
                            .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(7, 7, 7)
                            .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(7, 7, 7)
                            .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(587, 587, 587)
                            .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(7, 7, 7)
                            .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1350, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 713, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(cmbPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(3, 3, 3)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(txtIDUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7))))
                    .addGap(8, 8, 8)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3)
                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(8, 8, 8)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel4)
                        .addComponent(txtSNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(8, 8, 8)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel5)
                        .addComponent(jpfSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(8, 8, 8)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel6)
                        .addComponent(jpfConfirmarSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(8, 8, 8)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1)
                        .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnPrimeiro, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnProximo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnUltimo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(5, 5, 5)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(5, 5, 5)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(15, 15, 15)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPrimeiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrimeiroActionPerformed
        usuAtual = 0;
        mostrarRegistro();

        int id = evt.getID();
        System.out.println("ID do evento: " + id);
    }//GEN-LAST:event_btnPrimeiroActionPerformed

    private void btnAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnteriorActionPerformed
        usuAtual--;
        if (usuAtual == -1) {
            usuAtual = dados.numeroUsuarios() - 1;
        }
        mostrarRegistro();

        int id = evt.getID();
        System.out.println("ID do evento: " + id);
    }//GEN-LAST:event_btnAnteriorActionPerformed

    private void btnProximoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProximoActionPerformed
        usuAtual++;
        if (usuAtual == dados.numeroUsuarios()) {
            usuAtual = 0;
        }
        mostrarRegistro();

        int id = evt.getID();
        System.out.println("ID do evento: " + id);
    }//GEN-LAST:event_btnProximoActionPerformed

    private void btnUltimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUltimoActionPerformed
        usuAtual = dados.numeroUsuarios() - 1;
        mostrarRegistro();
        mostrarRegistro();

        int id = evt.getID();
        System.out.println("ID do evento: " + id);
    }//GEN-LAST:event_btnUltimoActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        btnPrimeiro.setEnabled(false);
        btnAnterior.setEnabled(false);
        btnProximo.setEnabled(false);
        btnUltimo.setEnabled(false);
        btnNovo.setEnabled(false);
        btnEditar.setEnabled(false);
        btnExcluir.setEnabled(false);
        btnPesquisar.setEnabled(false);
        btnSalvar.setEnabled(true);
        btnCancelar.setEnabled(true);

        txtIDUsuario.setEnabled(true);
        txtNome.setEnabled(true);
        txtSNome.setEnabled(true);
        jpfSenha.setEnabled(true);
        jpfConfirmarSenha.setEnabled(true);
        cmbPerfil.setEnabled(true);

        txtIDUsuario.setText("");
        txtNome.setText("");
        txtSNome.setText("");
        jpfSenha.setText("");
        jpfConfirmarSenha.setText("");
        cmbPerfil.setSelectedIndex(0);

        novo = true;
        txtIDUsuario.requestFocus();

        int id = evt.getID();
        System.out.println("ID do evento: " + id);
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        btnPrimeiro.setEnabled(false);
        btnAnterior.setEnabled(false);
        btnProximo.setEnabled(false);
        btnUltimo.setEnabled(false);
        btnNovo.setEnabled(false);
        btnEditar.setEnabled(false);
        btnExcluir.setEnabled(false);
        btnPesquisar.setEnabled(false);
        btnSalvar.setEnabled(true);
        btnCancelar.setEnabled(true);

        txtNome.setEnabled(true);
        txtSNome.setEnabled(true);
        jpfSenha.setEnabled(true);
        jpfConfirmarSenha.setEnabled(true);
        cmbPerfil.setEnabled(true);

        novo = false;
        txtNome.requestFocus();

        int id = evt.getID();
        System.out.println("ID do evento: " + id);
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if (txtIDUsuario.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Favor inserir um número de ID!");
            txtIDUsuario.requestFocusInWindow();
            return;
        }

        if (cmbPerfil.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Favor selecionar um perfil!");
            cmbPerfil.requestFocusInWindow();
            return;
        }

        if (txtNome.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Favor digitar um nome válido!");
            txtNome.requestFocusInWindow();
            return;
        }

        if (txtSNome.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Favor digitar um sobre nome válido!");
            txtSNome.requestFocusInWindow();
            return;
        }

        String senha = new String(jpfSenha.getPassword());
        String confirmar = new String(jpfConfirmarSenha.getPassword());

        if (senha.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Favor digitar uma senha válida!");
            jpfSenha.requestFocusInWindow();
            return;
        }

        if (confirmar.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Favor confirmar sua senha!");
            jpfConfirmarSenha.requestFocusInWindow();
            return;
        }

        if (!senha.equals(confirmar)) {
            JOptionPane.showMessageDialog(rootPane, "A sua senha esta diferente da confirmação!");
            jpfSenha.setText("");
            jpfConfirmarSenha.setText("");
            jpfSenha.requestFocusInWindow();
            return;
        }

        if (novo) {
            if (dados.existeUsuario(txtIDUsuario.getText())) {
                JOptionPane.showMessageDialog(rootPane, "Este usuário já existe!");
                txtIDUsuario.requestFocusInWindow();
                return;
            }
        } else {
            if (dados.existeUsuario(txtIDUsuario.getText())) {
                JOptionPane.showMessageDialog(rootPane, "Este usuário não existe!");
                txtIDUsuario.requestFocusInWindow();
                return;
            }
        }
        //String chave = null;
        String chave = "";

        Usuario mUsuario = new Usuario(txtIDUsuario.getText(), txtNome.getText(), txtSNome.getText(), senha, chave, cmbPerfil.getSelectedIndex());

        String msg;
        if (novo) {
            msg = dados.adicionarUsuario(mUsuario);
        } else {
            msg = dados.editarUsuario(mUsuario);
        }
        JOptionPane.showMessageDialog(rootPane, msg);

        btnPrimeiro.setEnabled(true);
        btnAnterior.setEnabled(true);
        btnProximo.setEnabled(true);
        btnUltimo.setEnabled(true);
        btnNovo.setEnabled(true);
        btnEditar.setEnabled(true);
        btnExcluir.setEnabled(true);
        btnPesquisar.setEnabled(true);
        btnSalvar.setEnabled(false);
        btnCancelar.setEnabled(false);

        txtIDUsuario.setEnabled(false);
        txtNome.setEnabled(false);
        txtSNome.setEnabled(false);
        jpfSenha.setEnabled(false);
        jpfConfirmarSenha.setEnabled(false);
        cmbPerfil.setEnabled(false);

        preencherTabela();

        int id = evt.getID();
        System.out.println("ID do evento: " + id);
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int resposta = JOptionPane.showConfirmDialog(rootPane, "Deletar este cadastro?");
        if (resposta != 0) {
            return;
        }
        String msg;
        msg = dados.deletarUsuario(txtIDUsuario.getText());
        JOptionPane.showMessageDialog(rootPane, msg);
        usuAtual = 0;
        preencherTabela();
        mostrarRegistro();

        int id = evt.getID();
        System.out.println("ID do evento: " + id);
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        btnPrimeiro.setEnabled(true);
        btnAnterior.setEnabled(true);
        btnProximo.setEnabled(true);
        btnUltimo.setEnabled(true);
        btnNovo.setEnabled(true);
        btnEditar.setEnabled(true);
        btnExcluir.setEnabled(true);
        btnPesquisar.setEnabled(true);
        btnSalvar.setEnabled(false);
        btnCancelar.setEnabled(false);

        txtIDUsuario.setEnabled(false);
        txtNome.setEnabled(false);
        txtSNome.setEnabled(false);
        jpfSenha.setEnabled(false);
        jpfConfirmarSenha.setEnabled(false);
        cmbPerfil.setEnabled(false);

        txtIDUsuario.setText(ID);
        txtNome.setText(Nome);
        txtSNome.setText(SNome);
        jpfSenha.setText("");
        jpfConfirmarSenha.setText("");

        carregarPrimeiroRegistro();

        int id = evt.getID();
        System.out.println("ID do evento: " + id);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        String usuario = JOptionPane.showInputDialog("Insira o código do usuário");
        if (usuario.equals("")) {
            return;
        }

        if (!dados.existeUsuario(usuario)) {
            JOptionPane.showMessageDialog(rootPane, "Este usuário não existe!");
            return;
        }
        int num = jtTabela.getRowCount();
        for (int i = 0; i < num; i++) {
            if (Utilidades.objectToString(jtTabela.getValueAt(i, 0)).equals(usuario)) {
                usuAtual = i;
                break;
            }
        }
        mostrarRegistro();

        int id = evt.getID();
        System.out.println("ID do evento: " + id);
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void mostrarRegistro() {
        txtIDUsuario.setText(Utilidades.objectToString(jtTabela.getValueAt(usuAtual, 0)));
        txtNome.setText(Utilidades.objectToString(jtTabela.getValueAt(usuAtual, 1)));
        txtSNome.setText(Utilidades.objectToString(jtTabela.getValueAt(usuAtual, 2)));
        jpfSenha.setText("");
        jpfConfirmarSenha.setText("");
        cmbPerfil.setSelectedIndex(perfil(Utilidades.objectToString(jtTabela.getValueAt(usuAtual, 3))));
    }

    private void preencherTabela() {
        try {
            String titulos[] = {"ID Usuario", "Nome", "Sobre-Nome", "Perfil"};
            String registro[] = new String[4];
            mTabela = new DefaultTableModel(null, titulos);
            ResultSet rs = dados.getUsuarios();

            while (rs.next()) {
                registro[0] = rs.getString("idUsuario");
                registro[1] = rs.getString("nome");
                registro[2] = rs.getString("snome");
                registro[3] = perfil(rs.getInt("idPerfil"));

                mTabela.addRow(registro);
            }
            jtTabela.setModel(mTabela);
            //TabelaColorida.destacarLinhas(jtTabela);
        } catch (SQLException ex) {
            Logger.getLogger(FrmUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void carregarPrimeiroRegistro() {
        ResultSet rs = dados.getUsuarios();
        try {
            if (rs.next()) {
                ID = rs.getString("IDUsuario");
                Nome = rs.getString("Nome");
                SNome = rs.getString("SNome");

                txtIDUsuario.setText(ID);
                txtNome.setText(Nome);
                txtSNome.setText(SNome);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FrmUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private String perfil(int idPerfil) {
        if (idPerfil == 1) {
            return "Administrador";
        } else {
            return "Usuario";
        }
    }

    private int perfil(String perfil) {
        if (perfil.equals("Administrador")) {
            return 1;
        } else {
            return 2;
        }
    }

//    public static void main(String args[]) {
//        try {
//            IntelliJTheme.setup(FrmPrincipal.class
//                    .getResourceAsStream("/Visual_Studio_2019_Dark_Theme.theme.json"));
//        } catch (Exception e) {
//        }
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(() -> {
//            new FrmPrincipal().setVisible(true);
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnterior;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnPrimeiro;
    private javax.swing.JButton btnProximo;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnUltimo;
    private javax.swing.JComboBox<String> cmbPerfil;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPasswordField jpfConfirmarSenha;
    private javax.swing.JPasswordField jpfSenha;
    private javax.swing.JTable jtTabela;
    private javax.swing.JTextField txtIDUsuario;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtSNome;
    // End of variables declaration//GEN-END:variables
}
