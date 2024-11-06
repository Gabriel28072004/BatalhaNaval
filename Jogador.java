/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jogo;

import java.awt.Color;

public class Jogador {
    
    private String nome;
    private boolean turno = false;
    private boolean ataque = false;    
    private JetSki js;
    private PortaAvioes pa;
    private Submarino sb;
    private NaviosTanque nt;

    public boolean isAtaque() {
        return ataque;
    }

    public void setAtaque(boolean ataque) {
        this.ataque = ataque;
    }

   
    
      
    
    public JetSki getJs() {
        return js;
    }


    public PortaAvioes getPa() {
        return pa;
    }

    public Submarino getSb() {
        return sb;
    }


    public NaviosTanque getNt() {
        return nt;
    }
 
    public Jogador(String nome){        
        this.js = new JetSki("JetSki", 2);
        this.pa = new PortaAvioes("PortaAvioes", 5);
        this.sb = new Submarino("Submarino", 3);
        this.nt = new NaviosTanque("NavioTanque", 4);
        
        
        this.nome = nome;
    }

    public boolean isTurno() {
        return turno;
    }

    public void setTurno(boolean turno) {
        this.turno = turno;
    }
    
    public boolean tabuleiro_pronto(){
        boolean pronto = false;
        
        if(this.js.isPosicionado() && this.pa.isPosicionado() && this.sb.isPosicionado() && this.nt.isPosicionado()){
            pronto = true;
        }
        
        return pronto;
    }
    
    public boolean barco_atingido(int indice_casa){
        boolean atingido = false;
        if(this.js.atingido(indice_casa) || this.nt.atingido(indice_casa) || this.pa.atingido(indice_casa) || this.sb.atingido(indice_casa)){
            atingido = true;            
        }
        
        return atingido;
    }
    
    public boolean barco_destruido(){
        boolean destruido = false;
        if(this.js.destruido() || this.nt.destruido() || this.pa.destruido() || this.sb.destruido()){
            destruido = true; 
        }
        
        return destruido;
    }
    
    
       
    
    
    public void posicionar_barcos(Barco b, int indice_casa, String direcao){
        
         
        if(direcao.equals("Horizontal")){
            for(int posicao_atual = indice_casa; posicao_atual < indice_casa + b.getTamanho(); posicao_atual++){              
               b.addPosicao(posicao_atual);
            }
           
        }else{
            for(int posicao_atual = indice_casa; posicao_atual < indice_casa + (b.getTamanho() * 10); posicao_atual+=10){
               b.addPosicao(posicao_atual);
             
            } 
          
        }
      
       
    }
      
    
    public boolean fim_de_jogo(){
        boolean retorno = false;
        
        if(this.js.destruido() && this.nt.destruido() && this.pa.destruido() && this.sb.destruido()){
            
            retorno = true;
        }
        
        return retorno;
    }
        
    
}
