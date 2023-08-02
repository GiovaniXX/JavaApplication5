package formularios;

import classes.Database;
import com.formdev.flatlaf.IntelliJTheme;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class FrmLogin extends javax.swing.JFrame {

    private Timer timerMySQL;
    private Timer timerDataHoraSistema;
    private Database dados = new Database();
    private Connection con;
    //private Database dados;

    public void setDatabase(Database dados) {
        this.dados = dados;
    }

    public FrmLogin() {
        initComponents();
        status();
        setIcon();
    }

    private void status() {
        try {
            // Timer to update the MySQL image every 1 second
            timerMySQL = new Timer(1000, e -> atualizarImagemMySQL(dados));
            timerMySQL.setRepeats(true);
            timerMySQL.start();

            // Timer to update system date and time every 1 second
            timerDataHoraSistema = new Timer(1000, e -> atualizarDataHoraSistema());
            timerDataHoraSistema.setRepeats(true);
            timerDataHoraSistema.start();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "An unexpected error occurred: " + e.getMessage());
        }
    }

    private void atualizarImagemMySQL(Database msd) {
        try {
            con = msd.con;
            if (con != null && !con.isClosed()) {
                MySQL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/db_unlocked_128px.png")));
                jLabel_StatusDatabase.setText("Successfully connected to the Essence Royale App database");
            } else {
                MySQL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/db_bloqued_128px.png")));
                jLabel_StatusDatabase.setText("Unable to connect to Essence Royale App database");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "An error occurred while accessing the database: " + ex.getMessage());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "An error occurred while closing the database connection: " + ex.getMessage());
            }
        }
    }

    private void atualizarDataHoraSistema() {
        String dataHoraAtual = obterDataHoraAtual();
        jLabel_DataHoraSistema.setText(dataHoraAtual);
    }

    private String obterDataHoraAtual() {
        Date dataHoraAtual = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String dataHoraFormatada = formato.format(dataHoraAtual);
        return dataHoraFormatada;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jTextField_User = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jPasswordField_AccessCode = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        jPasswordField_SecurityKey = new javax.swing.JPasswordField();
        jButton_LogIn = new javax.swing.JButton();
        jButton_LogOut = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel_StatusDatabase = new javax.swing.JLabel();
        jLabel_DataHoraSistema = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel_InfoDev = new javax.swing.JLabel();
        MySQL = new javax.swing.JLabel();
        jLabel_LogoMySQLworkbench = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(".:Login");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(147, 147, 147));
        jLabel1.setText("Login System");

        jLabel2.setForeground(new java.awt.Color(147, 147, 147));
        jLabel2.setText("User.:");

        jLabel3.setForeground(new java.awt.Color(147, 147, 147));
        jLabel3.setText("Access Code.:");

        jLabel4.setForeground(new java.awt.Color(147, 147, 147));
        jLabel4.setText("Security Key.:");

        jButton_LogIn.setForeground(new java.awt.Color(147, 147, 147));
        jButton_LogIn.setText("Log in");
        jButton_LogIn.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 20, 10, 20));
        jButton_LogIn.setBorderPainted(false);
        jButton_LogIn.setMargin(new java.awt.Insets(10, 20, 10, 20));
        jButton_LogIn.setOpaque(true);
        jButton_LogIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_LogInActionPerformed(evt);
            }
        });

        jButton_LogOut.setForeground(new java.awt.Color(147, 147, 147));
        jButton_LogOut.setText("Log out");
        jButton_LogOut.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 20, 10, 20));
        jButton_LogOut.setBorderPainted(false);
        jButton_LogOut.setMargin(new java.awt.Insets(10, 20, 10, 20));
        jButton_LogOut.setOpaque(true);
        jButton_LogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_LogOutActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(147, 147, 147));
        jLabel5.setText("Status Database");

        jLabel_StatusDatabase.setForeground(new java.awt.Color(147, 147, 147));
        jLabel_StatusDatabase.setPreferredSize(new java.awt.Dimension(0, 16));

        jLabel_DataHoraSistema.setForeground(new java.awt.Color(147, 147, 147));
        jLabel_DataHoraSistema.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel_DataHoraSistema.setPreferredSize(new java.awt.Dimension(0, 16));

        jLabel_InfoDev.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel_InfoDev.setForeground(new java.awt.Color(147, 147, 147));
        jLabel_InfoDev.setText("Giovani V. Chaves - Desenvolvimentos© 2023");

        MySQL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/db_bloqued_128px.png"))); // NOI18N

        jLabel_LogoMySQLworkbench.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/New_MySQL_128px.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addGap(268, 268, 268))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel2))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(9, 9, 9)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jPasswordField_SecurityKey, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 685, Short.MAX_VALUE)
                                    .addComponent(jTextField_User)
                                    .addComponent(jPasswordField_AccessCode))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.LEADING))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel_StatusDatabase, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
                            .addComponent(jSeparator6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel_DataHoraSistema, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                            .addComponent(jSeparator5))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(MySQL)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel_LogoMySQLworkbench)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel_InfoDev, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator7))
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton_LogIn, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton_LogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(137, 137, 137))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(279, 279, 279))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField_User, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jPasswordField_AccessCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jPasswordField_SecurityKey, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_LogIn)
                    .addComponent(jButton_LogOut))
                .addGap(18, 18, 18)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_StatusDatabase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_DataHoraSistema, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(MySQL)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel_InfoDev))
                            .addComponent(jLabel_LogoMySQLworkbench, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_LogInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_LogInActionPerformed
        if (!dados.ValidateUser(jTextField_User.getText(),
                new String(jPasswordField_AccessCode.getPassword()),
                new String(jPasswordField_SecurityKey.getPassword()))) {
            String message = "<html><font color='red'><b>Validation With Database Denied.!</b></font></html>";
            JOptionPane.showMessageDialog(rootPane, message, "ERROR.!", JOptionPane.ERROR_MESSAGE);

            jTextField_User.setText("");
            jPasswordField_AccessCode.setText("");
            jPasswordField_SecurityKey.setText("");
            jTextField_User.requestFocusInWindow();
            return;
        }
        FrmPrincipal principal = new FrmPrincipal();
        this.setVisible(false);
        principal.setDatabase(dados);
        //principal.setProfile(msd.getProfile(jTextField_User.getText()));
        principal.setAccessCode(new String(jPasswordField_AccessCode.getPassword()));
        principal.setSecurityKey(new String(jPasswordField_SecurityKey.getPassword()));
        principal.setUser(jTextField_User.getText());
        principal.setExtendedState(JFrame.MAXIMIZED_BOTH);
        principal.setVisible(true);

        int id = evt.getID();
        System.out.println("ID do evento: " + id);
    }//GEN-LAST:event_jButton_LogInActionPerformed

    private void jButton_LogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_LogOutActionPerformed
        System.exit(0);

        int id = evt.getID();
        System.out.println("ID do evento: " + id);
    }//GEN-LAST:event_jButton_LogOutActionPerformed

    public static void main(String args[]) {
        try {
            IntelliJTheme.setup(FrmLogin.class
                    .getResourceAsStream("/Visual_Studio_2019_Dark_Theme.theme.json"));
        } catch (Exception e) {
        }

        java.awt.EventQueue.invokeLater(() -> {
            new FrmLogin().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel MySQL;
    private javax.swing.JButton jButton_LogIn;
    private javax.swing.JButton jButton_LogOut;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel_DataHoraSistema;
    private javax.swing.JLabel jLabel_InfoDev;
    private javax.swing.JLabel jLabel_LogoMySQLworkbench;
    private javax.swing.JLabel jLabel_StatusDatabase;
    private javax.swing.JPasswordField jPasswordField_AccessCode;
    private javax.swing.JPasswordField jPasswordField_SecurityKey;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JTextField jTextField_User;
    // End of variables declaration//GEN-END:variables

    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/up_images/Icons/Icon.jpg")));
    }
}
