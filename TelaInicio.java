/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ig;

import javax.swing.JOptionPane;
import jogo.Conexao;
import jogo.Jogador;
import jogo.Jogo;

/**
 *
 * @author bigma
 */
public class TelaInicio extends javax.swing.JPanel {
    Jogo jg; 
    Jogador jg1;
    IGbatalha painelPrincipal;
    public TelaInicio(IGbatalha painelPrincipal) {
        this.painelPrincipal = painelPrincipal;
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        nomeJogador = new javax.swing.JTextField();
        btnIniciar = new javax.swing.JButton();
        erro = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnCriarConta = new javax.swing.JButton();
        senha_usuario = new javax.swing.JPasswordField();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(500, 500));
        setPreferredSize(new java.awt.Dimension(500, 500));
        setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Batalha Naval");
        add(jLabel1);
        jLabel1.setBounds(160, -10, 180, 90);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Digite seu usuario");
        add(jLabel3);
        jLabel3.setBounds(200, 150, 130, 30);
        add(nomeJogador);
        nomeJogador.setBounds(160, 190, 200, 30);

        btnIniciar.setBackground(new java.awt.Color(0, 0, 153));
        btnIniciar.setForeground(new java.awt.Color(255, 255, 255));
        btnIniciar.setText("Entrar");
        btnIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarActionPerformed(evt);
            }
        });
        add(btnIniciar);
        btnIniciar.setBounds(180, 340, 160, 30);

        erro.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        erro.setForeground(new java.awt.Color(0, 0, 0));
        erro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add(erro);
        erro.setBounds(120, 70, 260, 40);

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Digite sua senha");
        add(jLabel2);
        jLabel2.setBounds(190, 240, 140, 20);

        btnCriarConta.setBackground(new java.awt.Color(0, 0, 153));
        btnCriarConta.setForeground(new java.awt.Color(255, 255, 255));
        btnCriarConta.setText("Criar conta");
        btnCriarConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCriarContaActionPerformed(evt);
            }
        });
        add(btnCriarConta);
        btnCriarConta.setBounds(180, 390, 160, 30);
        add(senha_usuario);
        senha_usuario.setBounds(160, 280, 200, 30);
    }// </editor-fold>//GEN-END:initComponents

    private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarActionPerformed
        
        String nome_jogador = nomeJogador.getText();
        String senha = senha_usuario.getText();
        
        
        if (Conexao.validarLogin(nome_jogador, senha)) {
           painelPrincipal.trocarPainel(new Lobby(this.painelPrincipal, nome_jogador), 500, 500);
        }else{
            JOptionPane.showMessageDialog(null, "Usuario ou senha incorretos.");
        }
 
    }//GEN-LAST:event_btnIniciarActionPerformed

    private void btnCriarContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCriarContaActionPerformed
        //this.painelPrincipal.setSize(500,500);
        this.painelPrincipal.trocarPainel(new CriarConta(this.painelPrincipal), 500, 500);
      
    }//GEN-LAST:event_btnCriarContaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCriarConta;
    private javax.swing.JButton btnIniciar;
    private javax.swing.JLabel erro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField nomeJogador;
    private javax.swing.JPasswordField senha_usuario;
    // End of variables declaration//GEN-END:variables
}
