package formularios;

import classes.BackGround;
import classes.Dados;
import com.formdev.flatlaf.IntelliJTheme;

public class FrmPrincipal extends javax.swing.JFrame {

    private Dados msDados;

    public void setDados(Dados msDados) {
        this.msDados = msDados;
    }

    public FrmPrincipal() {
        initComponents();
        msDados = new Dados();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dpnDesk = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnuArquivo = new javax.swing.JMenu();
        mnuArquivoProdutos = new javax.swing.JMenuItem();
        mnuArquivoSair = new javax.swing.JMenuItem();
        mnuMovimentos = new javax.swing.JMenu();
        mnuMovimentosNovaVenda = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Principal");
        setMaximumSize(new java.awt.Dimension(1920, 1080));
        setMinimumSize(new java.awt.Dimension(1360, 768));
        setPreferredSize(new java.awt.Dimension(1920, 1080));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        dpnDesk.setMaximumSize(new java.awt.Dimension(1920, 1080));
        dpnDesk.setMinimumSize(new java.awt.Dimension(1360, 768));
        dpnDesk.setPreferredSize(new java.awt.Dimension(1920, 1080));
        dpnDesk.setRequestFocusEnabled(false);

        javax.swing.GroupLayout dpnDeskLayout = new javax.swing.GroupLayout(dpnDesk);
        dpnDesk.setLayout(dpnDeskLayout);
        dpnDeskLayout.setHorizontalGroup(
            dpnDeskLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1904, Short.MAX_VALUE)
        );
        dpnDeskLayout.setVerticalGroup(
            dpnDeskLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1049, Short.MAX_VALUE)
        );

        mnuArquivo.setText("Arquivo");

        mnuArquivoProdutos.setText("Produtos");
        mnuArquivoProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuArquivoProdutosActionPerformed(evt);
            }
        });
        mnuArquivo.add(mnuArquivoProdutos);

        mnuArquivoSair.setText("Sair");
        mnuArquivoSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuArquivoSairActionPerformed(evt);
            }
        });
        mnuArquivo.add(mnuArquivoSair);

        jMenuBar1.add(mnuArquivo);

        mnuMovimentos.setText("Movimentos");

        mnuMovimentosNovaVenda.setText("Nova Venda");
        mnuMovimentosNovaVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuMovimentosNovaVendaActionPerformed(evt);
            }
        });
        mnuMovimentos.add(mnuMovimentosNovaVenda);

        jMenuBar1.add(mnuMovimentos);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dpnDesk, javax.swing.GroupLayout.DEFAULT_SIZE, 1904, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dpnDesk, javax.swing.GroupLayout.DEFAULT_SIZE, 1049, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1920, 1080));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
//        BackGround background = new BackGround("/img/Logo.jpg");
//        dpnDesk.add(background);
//        dpnDesk.moveToBack(background);
//        ((BackGround) dpnDesk).setImagem("/img/Logo.jpg");

        int id = evt.getID();
        System.out.println("ID do evento: " + id);
    }//GEN-LAST:event_formWindowOpened

    private void mnuArquivoProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuArquivoProdutosActionPerformed
        FrmProdutos msProdutos = new FrmProdutos();
        msProdutos.setDados(msDados);
        dpnDesk.add(msProdutos);
        msProdutos.show();

        int id = evt.getID();
        System.out.println("ID do evento: " + id);
    }//GEN-LAST:event_mnuArquivoProdutosActionPerformed

    private void mnuArquivoSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuArquivoSairActionPerformed
        msDados.salvarTodo();
        System.exit(0);

        int id = evt.getID();
        System.out.println("ID do evento: " + id);
    }//GEN-LAST:event_mnuArquivoSairActionPerformed

    private void mnuMovimentosNovaVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuMovimentosNovaVendaActionPerformed
        FrmFatura mFatura = new FrmFatura();
        mFatura.setDados(msDados);
        dpnDesk.add(mFatura);
        mFatura.show();

        int id = evt.getID();
        System.out.println("ID do evento: " + id);
    }//GEN-LAST:event_mnuMovimentosNovaVendaActionPerformed

    public static void main(String args[]) {
        try {
            IntelliJTheme.setup(FrmPrincipal.class
                    .getResourceAsStream("/Visual_Studio_2019_Dark_Theme.theme.json"));
        } catch (Exception e) {
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new FrmPrincipal().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane dpnDesk;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu mnuArquivo;
    private javax.swing.JMenuItem mnuArquivoProdutos;
    private javax.swing.JMenuItem mnuArquivoSair;
    private javax.swing.JMenu mnuMovimentos;
    private javax.swing.JMenuItem mnuMovimentosNovaVenda;
    // End of variables declaration//GEN-END:variables
}
