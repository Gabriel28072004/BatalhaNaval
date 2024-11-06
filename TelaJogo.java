/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ig;


import java.util.Timer;
import java.util.TimerTask;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import jogo.Barco;
import jogo.Jogador;
import jogo.Jogo;
/**
 *
 * @author bigma
 */
public class TelaJogo extends javax.swing.JPanel {
    IGbatalha painelPrincipal;
    TelaInicio j1, j2;
    Jogador jg1, jg2;
    Jogo jg;
    String nome_jogador1,nome_jogador2;
    private Barco barco_selecionado;
    private JButton tabuleiro_inimigo[];
    private JButton tabuleiro_jogador[];
    private JButton tabuleiro_inimigo2[];
    private JButton tabuleiro_jogador2[];
    
    public TelaJogo(IGbatalha painelPrincipal, String nome_jogador, String nome_jogador2) {
        
        jg1 = new Jogador(nome_jogador);
        jg2 = new Jogador(nome_jogador2);
        jg = new Jogo(jg1, jg2);
        initComponents();
        this.painelPrincipal = painelPrincipal;
        criaTabuleiroInimigo();
        criaTabuleiroJogador();
        criaTabuleiroJogador2();
        criaTabuleiroInimigo2();
        btnRodada.setVisible(false);
        nomeJogador1.setText(nome_jogador);
        jg1.setTurno(true);
        this.painelPrincipal.setSize(1768, 268);
        this.nome_jogador1 = nome_jogador;
        this.nome_jogador2 = nome_jogador2;
        
        
        
        
    }
    
    public void resetarBotoes(){
        Color cor_botao = new Color(187,187,187);
        PortaAvioes.setBackground(cor_botao);
        JetSki.setBackground(cor_botao);
        submarino.setBackground(cor_botao);
        submarino.setForeground(Color.BLACK);
        navioTanque.setBackground(cor_botao);
        navioTanque.setForeground(Color.BLACK);
        
    }
    
    
    
    public void criaTabuleiroInimigo(){
      boolean fim_rodada = false;
      Color cor_tabuleiro = new Color(102,255,255);  
      tabuleiro_inimigo = new JButton[100];
      int x = 1;
      int y = 0;
      for(int casa=0; casa < 100; casa++){
          tabuleiro_inimigo[casa] = new JButton();
          tabuleiro_inimigo[casa].setBounds(40 *x, 40 *y,40,40);
          tabuleiro_inimigo[casa].setBackground(cor_tabuleiro);
          tabuleiro_inimigo[casa].addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {
                 if(jg.status() != jg.JOGANDO){
                    return;}
                JButton botaoPressionado = (JButton) e.getSource();
                for(int i = 0; i < 100; i++){
                                         
                    
                    if(botaoPressionado == tabuleiro_inimigo[i] && tabuleiro_inimigo[i].getBackground() == cor_tabuleiro ){ 
                                                                      
                        
                        
                        if(!jg1.isAtaque()){
                            jg1.setAtaque(true);
                        }else{
                            return;
                        }
                        
                        if(jg2.barco_atingido(i)){
                            tabuleiro_inimigo[i].setBackground(Color.RED);
                            tabuleiro_jogador2[i].setBackground(Color.RED);
                        }else{
                            tabuleiro_inimigo[i].setBackground(Color.BLUE);
                            tabuleiro_jogador2[i].setBackground(Color.BLUE);
                        }
                        
                        if(jg2.fim_de_jogo()){
                            JOptionPane.showMessageDialog(null, "Fim de jogo. Você venceu!");
                            painelPrincipal.trocarPainel(new TelaInicio(painelPrincipal), 500,500);
                            return;
                        } 
                        
                        
                         
                        
                        if(jg2.getJs().destruido() && jg2.getJs().isAlerta()){
                            JOptionPane.showMessageDialog(null, jg2.getJs().afundado());
                            jg2.getJs().setAlerta(false);
                            
                        }else if(jg2.getNt().destruido() && jg2.getNt().isAlerta()){
                            JOptionPane.showMessageDialog(null, jg2.getNt().afundado());
                            jg2.getNt().setAlerta(false);
                            
                        }else if(jg2.getPa().destruido() && jg2.getPa().isAlerta()){
                            JOptionPane.showMessageDialog(null, jg2.getPa().afundado());
                            jg2.getPa().setAlerta(false);
                            
                        }else if(jg2.getSb().destruido() && jg2.getSb().isAlerta()){
                            JOptionPane.showMessageDialog(null, jg2.getSb().afundado());
                            jg2.getSb().setAlerta(false);
                        }
                        
                                   
                                             
                            
                   }    

                }

             }
          });
          x++;
          if(x == 11){
             x = 1;
             y++;
          }
          tab_inimigo.add(tabuleiro_inimigo[casa]);
      } 
    }
    
    
    
    public void criaTabuleiroInimigo2(){
      Color cor_tabuleiro = new Color(102,255,255);  
      tabuleiro_inimigo2 = new JButton[100];
      int x = 1;
      int y = 0;
      for(int casa=0; casa < 100; casa++){
          tabuleiro_inimigo2[casa] = new JButton();
          tabuleiro_inimigo2[casa].setBounds(40 *x, 40 *y,40,40);
          tabuleiro_inimigo2[casa].setBackground(cor_tabuleiro);
          tabuleiro_inimigo2[casa].addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {
                 
                 if(jg.status() != jg.JOGANDO){
                    return;}
                JButton botaoPressionado = (JButton) e.getSource();
                for(int i = 0; i < 100; i++){
                    
                                        
                    
                    if(botaoPressionado == tabuleiro_inimigo2[i] && tabuleiro_inimigo2[i].getBackground() == cor_tabuleiro){
                        
                                                
                        if(!jg2.isAtaque()){
                            jg2.setAtaque(true);
                        }else{
                            return;
                        }
                        if(jg1.barco_atingido(i)){
                                tabuleiro_inimigo2[i].setBackground(Color.RED);
                                tabuleiro_jogador[i].setBackground(Color.RED);
                            }else{
                                tabuleiro_inimigo2[i].setBackground(Color.BLUE);
                                tabuleiro_jogador[i].setBackground(Color.BLUE);
                                }
                        
                        if(jg1.fim_de_jogo()){
                            JOptionPane.showMessageDialog(null, "Fim de jogo. Você venceu!");
                            painelPrincipal.trocarPainel(new TelaInicio(painelPrincipal), 500,500);
                            return;
                        }
                                               
                        
                        
                        if(jg1.getJs().destruido() && jg1.getJs().isAlerta()){
                            JOptionPane.showMessageDialog(null, jg1.getJs().afundado());
                            jg1.getJs().setAlerta(false);
                            
                        }else if(jg1.getNt().destruido() && jg1.getNt().isAlerta()){
                            JOptionPane.showMessageDialog(null, jg1.getNt().afundado());
                            jg1.getNt().setAlerta(false);
                            
                        }else if(jg1.getPa().destruido() && jg1.getPa().isAlerta()){
                            JOptionPane.showMessageDialog(null, jg1.getPa().afundado());
                            jg1.getPa().setAlerta(false);
                            
                        }else if(jg1.getSb().destruido() && jg1.getSb().isAlerta()){
                            JOptionPane.showMessageDialog(null, jg1.getSb().afundado());
                            jg1.getSb().setAlerta(false);
                        }
                                               
                                                           
                        
                        }
                    }
             }
          });
          x++;
          if(x == 11){
             x = 1;
             y++;
          }
          tab_inimigo2.add(tabuleiro_inimigo2[casa]);
          tab_jogador2.setVisible(false);
          tab_inimigo2.setVisible(false);
      } 
    }
    
    
    
    
    public void criaTabuleiroJogador(){
      Color cor_tabuleiro = new Color(102,255,255);  
      tabuleiro_jogador = new JButton[100];
      int x = 0;
      int y = 0;
      for(int casa=0; casa < 100; casa++){
        
          tabuleiro_jogador[casa] = new JButton();
          tabuleiro_jogador[casa].setBounds(40 *x, 40 *y,40,40);
          tabuleiro_jogador[casa].setBackground(cor_tabuleiro);
          
          tabuleiro_jogador[casa].addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {
                if(barco_selecionado == null){
                    JOptionPane.showMessageDialog(null, "Você precisa selecionar um barco primeiro.");}
                else{
                    
                    if(jg.status() != jg.POSICIONANDO){
                        return;}
                    JButton botaoPressionado = (JButton) e.getSource();
                    String item = "";
                        if(barco_selecionado.isPosicionado()){
                        JOptionPane.showMessageDialog(null, "Barco já posicionado");}
                        else{
                        
                            for(int i = 0; i < 100; i++){
                                if(botaoPressionado == tabuleiro_jogador[i]){
                                    
                                    if(jg1.fim_de_jogo()){
                                        JOptionPane.showMessageDialog(null, "Fim de jogo. O jogador 2 venceu!");
                                        painelPrincipal.trocarPainel(new TelaInicio(painelPrincipal), 500,500);
                                    }
                        
                                    boolean posicaok = jg.posicao_valida(barco_selecionado, i, direcao_posicionamento.getSelectedItem().toString());
                                    msgErro.setText("");
       
                                    if(posicaok){                               
                                        jg1.posicionar_barcos(barco_selecionado, i, direcao_posicionamento.getSelectedItem().toString());
                                        pintar_tabuleiro(barco_selecionado,i, direcao_posicionamento.getSelectedItem().toString());                            
                                        tabuleiro_jogador[i].setBackground(barco_selecionado.getCor_barco());
                                        barco_selecionado.setPosicionado(true);  
                                    }else{
                                        JOptionPane.showMessageDialog(null, "Posição Inválida");
                                    }                    
                                }
                            }        
                            }                       
                  
                    }
             }    
            });
          x++;
          if(x == 10){
             x = 0;
             y++;
          }
          tab_jogador.add(tabuleiro_jogador[casa]);
      } 
    }
    
    
    public void criaTabuleiroJogador2(){
      Color cor_tabuleiro = new Color(102,255,255);  
      tabuleiro_jogador2 = new JButton[100];
      int x = 0;
      int y = 0;
      for(int casa=0; casa < 100; casa++){
          tabuleiro_jogador2[casa] = new JButton();
          tabuleiro_jogador2[casa].setBounds(40 *x, 40 *y,40,40);
          tabuleiro_jogador2[casa].setBackground(cor_tabuleiro);
          
          tabuleiro_jogador2[casa].addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {
                if(barco_selecionado == null){
                    JOptionPane.showMessageDialog(null, "Você precisa selecionar um barco primeiro.");}
                else{ 
                    
                    
                    
                    if(jg.status() != jg.POSICIONANDO){
                        return;}
                    
                    JButton botaoPressionado = (JButton) e.getSource();
                        if(barco_selecionado.isPosicionado()){
                        JOptionPane.showMessageDialog(null, "Barco já posicionado");}
                        else{
                            for(int i = 0; i < 100; i++){
                                if(botaoPressionado == tabuleiro_jogador2[i]){
                        
                                    boolean posicaok = jg.posicao_valida(barco_selecionado, i, direcao_posicionamento.getSelectedItem().toString());
                                    msgErro.setText("");
       
                                    if(posicaok){                               
                                        jg2.posicionar_barcos(barco_selecionado, i, direcao_posicionamento.getSelectedItem().toString());
                                        pintar_tabuleiro(barco_selecionado,i, direcao_posicionamento.getSelectedItem().toString());                            
                                        tabuleiro_jogador2[i].setBackground(barco_selecionado.getCor_barco());
                                        barco_selecionado.setPosicionado(true);  
                                    }else{
                                        JOptionPane.showMessageDialog(null, "Posição Inválida");
                                    }
                                    
                      
                                }   
                            }        
                        }
                  
                    }
             }
          });
          x++;
          if(x == 10){
             x = 0;
             y++;
          }
          tab_jogador2.add(tabuleiro_jogador2[casa]);
          tab_jogador2.setVisible(false);
          tab_inimigo2.setVisible(false);
      } 
    }
    
    
    
    
    public void pintar_tabuleiro(Barco b, int indice_casa, String direcao){
        if(direcao.equals("Horizontal")){
            for(int indice_atual = indice_casa; indice_atual < indice_casa + b.getTamanho(); indice_atual++){
               if(jg1.isTurno()){
                   tabuleiro_jogador[indice_atual].setBackground(b.getCor_barco());
               }else{
                   tabuleiro_jogador2[indice_atual].setBackground(b.getCor_barco());
               } 
            }
           
        }else{
            for(int indice_atual = indice_casa; indice_atual < indice_casa + (b.getTamanho() * 10); indice_atual += 10){
              if(jg1.isTurno()){  
                 tabuleiro_jogador[indice_atual].setBackground(b.getCor_barco());
              }else{
                 tabuleiro_jogador2[indice_atual].setBackground(b.getCor_barco());
              }
            } 
          
        }
    }
      
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        infoJogadores = new javax.swing.JPanel();
        nomeJogador1 = new javax.swing.JLabel();
        txtAcao = new javax.swing.JLabel();
        PortaAvioes = new javax.swing.JButton();
        JetSki = new javax.swing.JButton();
        submarino = new javax.swing.JButton();
        navioTanque = new javax.swing.JButton();
        posicionamento = new javax.swing.JLabel();
        direcao_posicionamento = new javax.swing.JComboBox<>();
        nomeJogador3 = new javax.swing.JLabel();
        nomeJogador2 = new javax.swing.JLabel();
        infoBarcos = new javax.swing.JPanel();
        msgErro = new javax.swing.JLabel();
        btnPronto1 = new javax.swing.JButton();
        btnRodada = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        tab_inimigo2 = new javax.swing.JPanel();
        tab_jogador2 = new javax.swing.JPanel();
        tab_inimigo = new javax.swing.JPanel();
        tab_jogador = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(700, 600));
        setPreferredSize(new java.awt.Dimension(1920, 1080));
        setLayout(null);

        infoJogadores.setMinimumSize(new java.awt.Dimension(600, 400));
        infoJogadores.setLayout(null);

        nomeJogador1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        nomeJogador1.setForeground(new java.awt.Color(255, 255, 255));
        nomeJogador1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        infoJogadores.add(nomeJogador1);
        nomeJogador1.setBounds(30, 20, 120, 40);

        txtAcao.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtAcao.setForeground(new java.awt.Color(255, 255, 255));
        txtAcao.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtAcao.setText("Posicione os barcos");
        infoJogadores.add(txtAcao);
        txtAcao.setBounds(0, 40, 180, 90);

        PortaAvioes.setText("PortaAvioes");
        PortaAvioes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PortaAvioesMouseClicked(evt);
            }
        });
        infoJogadores.add(PortaAvioes);
        PortaAvioes.setBounds(40, 210, 100, 23);

        JetSki.setText("JetSki");
        JetSki.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JetSkiActionPerformed(evt);
            }
        });
        infoJogadores.add(JetSki);
        JetSki.setBounds(50, 130, 72, 23);

        submarino.setText("Submarino");
        submarino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submarinoActionPerformed(evt);
            }
        });
        infoJogadores.add(submarino);
        submarino.setBounds(40, 170, 90, 23);

        navioTanque.setText("NavioTanque");
        navioTanque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                navioTanqueActionPerformed(evt);
            }
        });
        infoJogadores.add(navioTanque);
        navioTanque.setBounds(30, 250, 120, 23);

        posicionamento.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        posicionamento.setForeground(new java.awt.Color(255, 255, 255));
        posicionamento.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        posicionamento.setText("Posicionamento:");
        infoJogadores.add(posicionamento);
        posicionamento.setBounds(10, 300, 160, 20);

        direcao_posicionamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Horizontal", "Vertical" }));
        direcao_posicionamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                direcao_posicionamentoActionPerformed(evt);
            }
        });
        infoJogadores.add(direcao_posicionamento);
        direcao_posicionamento.setBounds(40, 330, 100, 22);

        nomeJogador3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        nomeJogador3.setForeground(new java.awt.Color(255, 255, 255));
        nomeJogador3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        infoJogadores.add(nomeJogador3);
        nomeJogador3.setBounds(30, 10, 120, 40);

        nomeJogador2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        nomeJogador2.setForeground(new java.awt.Color(255, 255, 255));
        nomeJogador2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        infoJogadores.add(nomeJogador2);
        nomeJogador2.setBounds(30, 20, 120, 40);

        add(infoJogadores);
        infoJogadores.setBounds(0, 0, 180, 400);

        infoBarcos.setBackground(new java.awt.Color(204, 204, 204));
        infoBarcos.setMinimumSize(new java.awt.Dimension(700, 700));
        infoBarcos.setLayout(null);

        msgErro.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        msgErro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        infoBarcos.add(msgErro);
        msgErro.setBounds(230, 60, 120, 30);

        btnPronto1.setBackground(new java.awt.Color(0, 0, 204));
        btnPronto1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnPronto1.setForeground(new java.awt.Color(255, 255, 255));
        btnPronto1.setText("Pronto");
        btnPronto1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPronto1ActionPerformed(evt);
            }
        });
        infoBarcos.add(btnPronto1);
        btnPronto1.setBounds(450, 80, 170, 40);

        btnRodada.setBackground(new java.awt.Color(255, 255, 255));
        btnRodada.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnRodada.setForeground(new java.awt.Color(0, 0, 153));
        btnRodada.setText("Próxima rodada");
        btnRodada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRodadaActionPerformed(evt);
            }
        });
        infoBarcos.add(btnRodada);
        btnRodada.setBounds(450, 80, 170, 40);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Batalha Naval");
        infoBarcos.add(jLabel1);
        jLabel1.setBounds(380, 20, 310, 32);

        add(infoBarcos);
        infoBarcos.setBounds(0, 400, 1020, 200);

        tab_inimigo2.setBackground(new java.awt.Color(255, 255, 255));
        tab_inimigo2.setLayout(null);
        add(tab_inimigo2);
        tab_inimigo2.setBounds(580, 0, 440, 400);

        tab_jogador2.setBackground(new java.awt.Color(255, 255, 255));
        tab_jogador2.setLayout(null);
        add(tab_jogador2);
        tab_jogador2.setBounds(180, 0, 400, 400);

        tab_inimigo.setBackground(new java.awt.Color(255, 255, 255));
        tab_inimigo.setLayout(null);
        add(tab_inimigo);
        tab_inimigo.setBounds(580, 0, 440, 400);

        tab_jogador.setBackground(new java.awt.Color(255, 255, 255));
        tab_jogador.setLayout(null);
        add(tab_jogador);
        tab_jogador.setBounds(180, 0, 400, 400);

        getAccessibleContext().setAccessibleName("t");
    }// </editor-fold>//GEN-END:initComponents

    private void JetSkiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JetSkiActionPerformed
        if(jg1.isTurno()){
          barco_selecionado = jg1.getJs(); 
            System.out.println("Jogador1");
       }else{
          barco_selecionado = jg2.getJs();
           System.out.println("Jogador2");
       }
        
        if(barco_selecionado.isPosicionado()){
            JOptionPane.showMessageDialog(null, "Jetski já foi posicionado");
        }else{            
            JetSki.setBackground(barco_selecionado.getCor_barco());
        }
       
    }//GEN-LAST:event_JetSkiActionPerformed

    private void submarinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submarinoActionPerformed
       if(jg1.isTurno()){
          barco_selecionado = jg1.getSb(); 
       }else{
          barco_selecionado = jg2.getSb();
       }
       
        if(barco_selecionado.isPosicionado()){
            JOptionPane.showMessageDialog(null, "Submarino já foi posicionado");
        }else{            
            
            submarino.setBackground(barco_selecionado.getCor_barco());
            submarino.setForeground(Color.WHITE);
        }
    }//GEN-LAST:event_submarinoActionPerformed

    private void navioTanqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_navioTanqueActionPerformed
        
        if(jg1.isTurno()){
          barco_selecionado = jg1.getNt(); 
       }else{
          barco_selecionado = jg2.getNt();
       }
        
        if(barco_selecionado.isPosicionado()){
            JOptionPane.showMessageDialog(null, "Navio-Tanque já foi posicionado");
        }else{            
            
            navioTanque.setBackground(barco_selecionado.getCor_barco());
            navioTanque.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_navioTanqueActionPerformed

    private void PortaAvioesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PortaAvioesMouseClicked
       
       if(jg1.isTurno()){
          barco_selecionado = jg1.getPa(); 
       }else{
          barco_selecionado = jg2.getPa();
       } 
       
       if(barco_selecionado.isPosicionado()){
            JOptionPane.showMessageDialog(null, "Porta-Aviões já foi posicionado");
        }else{                      
            PortaAvioes.setBackground(barco_selecionado.getCor_barco());
            
        }
    }//GEN-LAST:event_PortaAvioesMouseClicked

    private void direcao_posicionamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_direcao_posicionamentoActionPerformed
    }//GEN-LAST:event_direcao_posicionamentoActionPerformed

    private void btnPronto1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPronto1ActionPerformed
    
            if(jg1.isTurno()){
                 if(jg1.tabuleiro_pronto()){
                    tab_jogador.setVisible(false);
                    tab_inimigo.setVisible(false);
                    tab_jogador2.setVisible(true);
                    tab_inimigo2.setVisible(true);
                    nomeJogador1.setText("");
                    nomeJogador2.setText(nome_jogador2);
                    jg2.setTurno(true);
                    jg1.setTurno(false);
                    resetarBotoes();
                }else{
                    JOptionPane.showMessageDialog(null, "Você precisa posicionar todos os barcos.");
                } 
            }else{
                if(jg2.tabuleiro_pronto()){
                    tab_jogador2.setVisible(false);
                    tab_inimigo2.setVisible(false);
                    tab_jogador.setVisible(true);
                    tab_inimigo.setVisible(true);
                    nomeJogador2.setText("");
                    nomeJogador1.setText(nome_jogador1);
                    JOptionPane.showMessageDialog(null, "HORA DA BATALHA!"); 
                    txtAcao.setText("Está atacando");
                    posicionamento.setText("");
                    direcao_posicionamento.setVisible(false);
                    jg2.setTurno(false);
                    jg1.setTurno(true);
                    btnPronto1.setVisible(false);
                    btnRodada.setVisible(true);
               }else{
                  JOptionPane.showMessageDialog(null, "Você precisa posicionar todos os barcos.");  
               }
            }
            jg.verifica_tabuleiros();  
    }//GEN-LAST:event_btnPronto1ActionPerformed

    
    private void btnRodadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRodadaActionPerformed
         if(jg1.isTurno()){
                if(!jg1.isAtaque()){
                    JOptionPane.showMessageDialog(null, "Você precisa atacar primeiro.");
                    return;
                }
                tab_jogador.setVisible(false);
                tab_inimigo.setVisible(false);
                tab_jogador2.setVisible(true);
                tab_inimigo2.setVisible(true);
                nomeJogador1.setText("");
                nomeJogador2.setText(nome_jogador2);
                jg2.setTurno(true);
                jg1.setTurno(false);
                jg1.setAtaque(false);
                
                
                if(jg2.getJs().destruido()){
                    JetSki.setBackground(Color.red);
                    JetSki.setForeground(Color.WHITE);
                    
                }else{
                    JetSki.setBackground(jg2.getJs().getCor_barco());
                    JetSki.setForeground(Color.BLACK);
                }
                
                if(jg2.getPa().destruido()){
                    PortaAvioes.setBackground(Color.red);
                    PortaAvioes.setForeground(Color.WHITE);
                    
                }else{
                    PortaAvioes.setBackground(jg1.getPa().getCor_barco());
                    PortaAvioes.setForeground(Color.BLACK);
                }
                
                if(jg2.getNt().destruido()){
                    navioTanque.setBackground(Color.red);
                    navioTanque.setForeground(Color.WHITE);
                }else{
                    navioTanque.setBackground(jg2.getNt().getCor_barco());
                    navioTanque.setForeground(Color.BLACK);
                }
                
                if(jg2.getSb().destruido()){
                    submarino.setBackground(Color.red);
                    submarino.setForeground(Color.WHITE);
                    
                }else{
                    submarino.setBackground(jg2.getSb().getCor_barco());
                    submarino.setForeground(Color.WHITE);
                }

              
            }else{
                if(!jg2.isAtaque()){
                    JOptionPane.showMessageDialog(null, "Você precisa atacar primeiro.");
                    return;
                }
                tab_jogador2.setVisible(false);
                tab_inimigo2.setVisible(false);
                tab_jogador.setVisible(true);
                tab_inimigo.setVisible(true);
                nomeJogador2.setText("");
                nomeJogador1.setText(nome_jogador1); 
                txtAcao.setText("Está atacando");
                posicionamento.setText("");
                direcao_posicionamento.setVisible(false);
                jg2.setTurno(false);
                jg1.setTurno(true);
                jg2.setAtaque(false);
                
                
                if(jg1.getJs().destruido()){
                    JetSki.setBackground(Color.red);
                    JetSki.setForeground(Color.WHITE);
                    
                }else{
                    JetSki.setBackground(jg1.getJs().getCor_barco());
                    JetSki.setForeground(Color.BLACK);
                }
                if(jg1.getSb().destruido()){
                    submarino.setBackground(Color.red);
                    submarino.setForeground(Color.WHITE);
                    
                }else{
                    submarino.setBackground(jg1.getSb().getCor_barco());
                    submarino.setForeground(Color.WHITE);
                }
                if(jg1.getPa().destruido()){
                    PortaAvioes.setBackground(Color.red);
                    PortaAvioes.setForeground(Color.WHITE);
                    
                }else{
                    PortaAvioes.setBackground(jg1.getPa().getCor_barco());
                    PortaAvioes.setForeground(Color.BLACK);
                }
                
                if(jg1.getNt().destruido()){
                    navioTanque.setBackground(Color.red);
                    navioTanque.setForeground(Color.WHITE);
                }else{
                    navioTanque.setBackground(jg1.getNt().getCor_barco());
                    navioTanque.setForeground(Color.BLACK);
                }
                
            }
    }//GEN-LAST:event_btnRodadaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JetSki;
    private javax.swing.JButton PortaAvioes;
    private javax.swing.JButton btnPronto1;
    private javax.swing.JButton btnRodada;
    private javax.swing.JComboBox<String> direcao_posicionamento;
    private javax.swing.JPanel infoBarcos;
    private javax.swing.JPanel infoJogadores;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel msgErro;
    private javax.swing.JButton navioTanque;
    private javax.swing.JLabel nomeJogador1;
    private javax.swing.JLabel nomeJogador2;
    private javax.swing.JLabel nomeJogador3;
    private javax.swing.JLabel posicionamento;
    private javax.swing.JButton submarino;
    private javax.swing.JPanel tab_inimigo;
    private javax.swing.JPanel tab_inimigo2;
    private javax.swing.JPanel tab_jogador;
    private javax.swing.JPanel tab_jogador2;
    private javax.swing.JLabel txtAcao;
    // End of variables declaration//GEN-END:variables
}
